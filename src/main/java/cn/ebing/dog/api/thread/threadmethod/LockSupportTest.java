package cn.ebing.dog.api.thread.threadmethod;

import java.util.concurrent.locks.LockSupport;

/**
 * 总结也是和预想的是相同的。
 *
 * <p>许可（permit）的上限是1，也就是说只有 0 或 1 。 park: 没有许可的时候，permit 为 0 ，调用 park 会阻塞；有许可的时候，permit 为 1 ， 调用
 * park 会扣除一个许可，然后返回。 unpark：没有许可的时候，permit 为 0 ，调用 unpark 会增加一个许可，因为许可上限是 1 ， 所以调用多次也只会为 1 个。
 * 线程初始的时候是没有许可的。 park 的当前线程如果被中断，会立即返回，并不会抛出中断异常。
 *
 *
 * <p>park/unpark 和 wait/notify 区别
 *
 * <p>park 阻塞当前线程，unpark 唤醒指定线程。 wait() 需要结合锁使用，并释放锁资源，如果没有设置超时时间，则需要 notify() 唤醒。而 notify()
 * 是随机唤醒线程。
 */
public class LockSupportTest {

	/**
	 * 2021年08月08日14:26:20
	 * 简单试试 park
	 * THREAD.WAITING，线程进入了 WAITING 状态
	 */
	private static void defaultPark() {
		System.out.println("开始执行……");
		LockSupport.park();
		/**
		 * 没有执行，说明：线程初始没有 permit
		 */
		System.out.println("LockSupport park 之后……");
	}

	/**
	 * 先增加许可，再消耗许可
	 */
	private static void unparkAndPark() {
		System.out.println("开始执行……");
		LockSupport.unpark(Thread.currentThread());
		System.out.println("执行 - park");
		LockSupport.park();
		System.out.println("LockSupport park 之后……");
	}

	public static void threadSleepAndParkUnpark() throws InterruptedException {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程 " + Thread.currentThread().getName() + "开始执行 park");
				LockSupport.park(this);
				System.out.println("线程 " + Thread.currentThread().getName() + "执行 park 结束");
			}
		});

		thread.start();
		/**
		 * 保证 上面线程先执行，然后再主线程
		 * sleep: 睡眠，native,
		 *
		 * 线程阻塞，可以看出 permit 只能有 1 个,所以 unpark N 个，效果和1个是一样的呀，啊呸
		 */
		Thread.sleep(5000);
		System.out.println("开始执行 unpark(thread)");
		LockSupport.unpark(thread);
		Thread.sleep(5000);
		System.out.println("执行 unpark(thread) 结束");
	}

  /**
   * 奇怪了，使用 thread.interrupt 来代替 unpark,这种直接就干掉了 permit 的限制啊。
   *
   * 1、线程中断，park 会继续执行，并且没有抛出异常。
   * 2、thread.interrupt(); 调用之后， 设置线程中断标示，unpark 没有清除中断标示，第二个 park 也会继续执行。
   */
  public static void interrupt() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程 " + Thread.currentThread().getName() + "开始执行 park");
				LockSupport.park(this);
				System.out.println("线程 " + Thread.currentThread().getName() + "执行 park 结束");

				System.out.println("线程 " + Thread.currentThread().getName() + "开始执行 park 第二次");
				LockSupport.park(this);
				System.out.println("线程 " + Thread.currentThread().getName() + "执行 park 第二次 结束");
			}
		});

		try {
			thread.start();
			// 保证 上面线程先执行，然后再主线程
			Thread.sleep(5000);
			System.out.println("开始执行 unpark(thread)");
			thread.interrupt();
			Thread.sleep(5000);
			System.out.println("执行 unpark(thread) 结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


	public static void main(String[] args) throws InterruptedException {
		//threadSleepAndParkUnpark();
		interrupt();
		// unparkAndPark();

//		defaultPark();
	}

  /**
   * sleep 会抛出中断，sleep睡眠等待，让出CPU使用权让其它线程执行，sleep不会释放锁，而wait会释放了锁。
   * 使当前线程休眠(暂停运行)指定的时间。
   *
   * 理解：sleep，没有了动静，其实CPU就是闲置了，就让出来了。
   *
   *
   *
   * @throws InterruptedException
   */
  private static void parkThread() throws InterruptedException {
  		Thread t = new Thread(new ParkThread());
		t.start();
		Thread.sleep(100);
		System.out.println(Thread.currentThread().getName()+"开始唤醒阻塞线程");
		t.interrupt();
		System.out.println(Thread.currentThread().getName()+"结束唤醒");
	}
}


/**
 * park方法可以阻塞当前线程，如果调用unpark方法或者中断当前线程，则会从park方法中返回。
 * park方法对中断方法的响应和 sleep 有一些不太一样。它不会抛出中断异常，而是从park方法直接返回，不影响线程的继续执行。
 */
class ParkThread implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始阻塞");
		LockSupport.park();
		System.out.println(Thread.currentThread().getName()+"第一次结束阻塞");
		LockSupport.park();
		System.out.println(Thread.currentThread().getName()+ "第二次结束阻塞");
	}
}
