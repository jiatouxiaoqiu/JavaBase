package cn.ebing.dog.api.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 独占锁，按顺序执行
 */
public class ReentrantLockTest {
	private static final Lock lock = new ReentrantLock();
	public static void main(String[] args) {
		Thread threadA = new Thread(() -> test(),"线程A");
		Thread threadB = new Thread(() -> test(),"线程B");
		Thread threadC = new Thread(() -> test(),"线程C");
		threadA.start();
		threadB.start();
		threadC.start();
	}
	public static void  test()  {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+"获取了锁");
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println(Thread.currentThread().getName()+"释放了锁");
			lock.unlock();
		}
	}
}
