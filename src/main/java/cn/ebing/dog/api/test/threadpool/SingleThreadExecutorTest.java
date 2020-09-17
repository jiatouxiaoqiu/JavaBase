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
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	);


	/**
	 * 进一步分析，线程池既然有生命周期，它的状态是如何表征的呢？
	 */
	public static void main(String[] args) {
		/**
		 * Executors 提供的 5 个静态工厂方法,为什么不推荐呢？
		 * 自定义线程，才能知道参数的作用。并且自定义ThreadFactory 才行 ThreadFactoryBuilder。
		 */
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		/**
		 * 所以，如果使用submit，要么用get拉取异常处理， 要么自己写try catch把任务执行的逻辑包起来。
		 * execute的入参是Runnable， 没有返回值。任务通过execute提交后就基本和主线程脱离关系了。
		 * list里面包含一个null元素，很显然在执行list.stream().map时会报错，但是你运行下看看会发现什么也没发生。
		 * 然后改成execute试试，运行会报如下的错误：
		 */
		executorService.submit(runnable1);
		executorService.submit(runnable2);
		executorService.submit(thread3);
		executorService.submit(thread4);
		executorService.execute(thread4);
		System.out.println("main end");
	}
}
