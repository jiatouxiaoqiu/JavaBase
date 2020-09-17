package cn.ebing.dog.api.test.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这个 Runnable 比 new 一个 Thread 好吧
 * lambda
 */
public class SingleThreadExecutorTest {
	private static Runnable runnable1 = new Runnable() {
		@Override
		public void run() {
			System.out.println("runnable1 start");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	private static Runnable runnable2 = () -> {
		System.out.println("runnable2 start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};

	private static Thread thread3 = new Thread(
			new Runnable() {
				@Override
				public void run() {
					System.out.println("thread3 start");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
	);

	private static Thread thread4 = new Thread(
			() -> {
				System.out.println("thread4 start");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	);


	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(runnable1);
		executorService.submit(runnable2);
		executorService.submit(thread3);
		executorService.submit(thread4);
		System.out.println("main end");
	}
}
