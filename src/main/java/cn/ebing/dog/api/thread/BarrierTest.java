package cn.ebing.dog.api.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier 结合 Executors，可以循环使用
 *
 * CountDownLatch 是一个线程等待其他线程， CyclicBarrier 是多个线程互相等待。
 * CountDownLatch 的计数是减 1 直到 0，CyclicBarrier 是加 1，直到指定值。
 * CountDownLatch 是一次性的， CyclicBarrier  可以循环利用。
 * CyclicBarrier 可以在最后一个线程达到屏障之前，选择先执行一个操作。
 *
 * CountDownLatch and CyclicBarrier 是相反的！！！奥利给
 * Semaphore ，需要拿到许可才能执行，并可以选择公平和非公平模式。
 */
public class BarrierTest {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3);  //①
		Runner runner1 = new Runner(barrier, "张三");
		Runner runner2 = new Runner(barrier, "李四");
		Runner runner3 = new Runner(barrier, "王五");
		Runner runner6 = new Runner(barrier, "666");

		ExecutorService service = Executors.newFixedThreadPool(4);
		service.execute(runner1);
		service.execute(runner2);
		service.execute(runner3);
		service.execute(runner6);

		service.shutdown();
	}

}


class Runner implements Runnable {

	private CyclicBarrier barrier;
	private String name;

	public Runner(CyclicBarrier barrier, String name) {
		this.barrier = barrier;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			//模拟准备耗时
			Thread.sleep(new Random().nextInt(5000));
			System.out.println(name + ":准备OK");
			barrier.await();
			System.out.println(name +": 开跑");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e){
			e.printStackTrace();
		}
	}
}