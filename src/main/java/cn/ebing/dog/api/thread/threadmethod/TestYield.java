package cn.ebing.dog.api.thread.threadmethod;

import java.util.concurrent.locks.LockSupport;

/**
 * Thread.yield 方法会使当前线程放弃CPU时间片，把执行机会让给相同或更高优先级的线程
 * （yield英文意思就是屈服，放弃的意思嘛，可以理解为当前线程暂时屈服于别人了）。
 * 注意，此时当前线程不会阻塞，只是进入了就绪状态，随时可以再次获得CPU时间片，从而进入运行状态。
 * 也就是说，其实yield方法，并不能保证，其它相同或更高优先级的线程一定会获得执行权，也有可能，再次被当前线程拿到执行权。
 * yield方法和sleep方法一样，也是不释放锁资源的。
 */
public class TestYield {
	public static void main(String[] args) {
		LockSupport.parkNanos(1);
		YieldThread yieldThread = new YieldThread();
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(yieldThread);
			t.start();
		}
	}
}

class YieldThread implements Runnable {

	private int count = 0;

	@Override
	public synchronized void run() {
		for (int i = 0; i < 4; i++) {
			count ++;
			if(count == 2){
				Thread.yield();
				System.out.println("线程:"+Thread.currentThread().getName() + "让步");
			}
			System.out.println("线程:"+Thread.currentThread().getName() + ",count:"+count);
		}
	}
}
