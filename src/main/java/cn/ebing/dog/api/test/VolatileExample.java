package cn.ebing.dog.api.test;

import java.util.concurrent.TimeUnit;

/**
 * 同步访问共享的可变数据
 * @author lx
 *
 * 加了 volatile，jvm 一定会保证 stopRequested 的可见性。
 * 不加 volatile，jvm 会尽量保证 stopRequested 的可见性。
 */
public class VolatileExample {

	private static boolean flag = false;

	private static int i = 0;

	/**
	 * 方案3：
	 * Integer 居然就可以正确结束了。。。x了
	 * private static Integer i = 0;
	 *
	 */

	/**
	 * 方案4：
	 * private static volatile int i = 0;
	 * 	volatile 修饰的字段 i 进行了非原子性的操作。
	 * 	对于 volatile 修饰的变量 i，进行 i++ 操作是不对的，因为 volatile 只保证可见性，不保证原子性，而 i++ 操作就不是原子操作的
	 */
	public static void main(String[] args) {
		new Thread(() -> {
			/**
			 * 这是子线程，修改了 flag，主线程不一定知道
			 * 如果是在 HotSpot jvm 中用 Server 模式跑的程序，是一定不会被主线程看到。所以 flag 需要加上 volatile
			 *
			 * 注释了 14 行和 16 行，while 循环，循环了3359次（该次数视机器情况而定）后，
			 * 就读到了 flag 为  true，还没有触发即时编译，所以程序正常结束。不要 sleep ，就无法触发 JIT，就可以结束了
			 */
			try {
//				TimeUnit.MILLISECONDS.sleep(1000);
				flag = true;
				System.out.println("flag update to true");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();

		/**
		 * 由于变量 flag 没有被 volatile 修饰，而且在子线程休眠的 100ms 中， while 循环的 flag 一直为 false，循环到一定次数后，触发了 jvm 的即时编译功能，进行循环表达式外提（Loop Expression Hoisting），导致形成死循环。而如果加了 volatile 去修饰 flag 变量，保证了 flag 的可见性，则不会进行提升。
		 */
		while (!flag) {
			// 死循环，则 CPU 很繁忙。println，则 CPU 相对不繁忙
			i++;

			/**
			 * 方案1：sleep 会导致内存的刷新操作？？？
			 * 里面有两句话特别重要（上面红框圈起来的部分）：
			 * Thread.sleep 没有任何同步语义（Thread.yield也是）。编译器不必在调用 Thread.sleep 之前将缓存在寄存器中的写刷新到共享内存，也不必在调用 Thread.sleep 之后重新加载缓存在寄存器中的值。
			 * 编译器可以自由（free）读取 done 这个字段仅一次。
			 * 特别是第二点，注意文档中的这个 free。简直用的是一发入魂。
			 * 自由，意味着编译器可以选择只读取一次，也可以选择每次都去读取，这才是自由的含义。这是编译器自己的选择。
			 *
			 * 这是可以接受的，这种优化称作提升（hoisting）
			 * 而这个提升是 JIT 帮我们做的
			 */

			try {
				TimeUnit.MILLISECONDS.sleep(1);
				flag = true;
				System.out.println("flag 2 update to true");
			} catch (Exception e) {
				e.printStackTrace();
			}

			/**
			 * 方案2：你说你知道，因为输出语句里面有 synchronized 关键字。我屮艸芔茻
			 * JVM 不够聪明，它无法证明其他线程在设置 pizzaArrived 之后不会调用 println
			 * 因此它只能假定其他线程可能会调用 println。（所以有同步操作）
			 * 因此，如果使用 System.out.println， JVM 将无法在循环期间缓存变量。
			 */
//			 System.out.println("flag=" + flag);

		}
		System.out.println("program end, i=" + i);

	}
}
