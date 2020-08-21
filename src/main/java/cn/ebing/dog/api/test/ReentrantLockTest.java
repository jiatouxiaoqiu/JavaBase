package cn.ebing.dog.api.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 独占锁，按顺序执行
 */
public class ReentrantLockTest {
	private static final Lock lock = new ReentrantLock(false);
	public static void main(String[] args) {
		new Thread(() -> test(),"线程A").start();
		new Thread(() -> test(),"线程B").start();
		new Thread(() -> test(),"线程C").start();
		new Thread(() -> test(),"线程1").start();
		new Thread(() -> test(),"线程2").start();
		new Thread(() -> test(),"线程3").start();
	}
	public static void  test()  {
		for(int i=0;i<2;i++) {
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName()+"获取了锁");
				TimeUnit.SECONDS.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
//				System.out.println(Thread.currentThread().getName()+"释放了锁");
				lock.unlock();
			}
		}
	}
}
