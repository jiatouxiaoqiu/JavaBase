package cn.ebing.dog.api.thread.threadmethod;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new ParkThread());
		t.start();
		Thread.sleep(100); //①
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
