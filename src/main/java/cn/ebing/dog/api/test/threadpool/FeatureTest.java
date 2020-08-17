package cn.ebing.dog.api.test.threadpool;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 很明显的木桶效应。
 * 三个异步任务，耗时最长的最先执行，所以最先进入 list
 * 因此当在循环中获取这个任务结果的时候 get 操作会一直阻塞，即使执行时间为 5s/10s 的任务已经执行完成。
 * 这就是 future 在这种场景下的局限性。
 */
public class FeatureTest {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> list = new ArrayList<>();
		Future<Integer> future_15 = executorService.submit(() -> {
			TimeUnit.SECONDS.sleep(15);
			System.out.println("执行时长为15s的执行完成。");
			return 15;
		});
		list.add(future_15);

		Future<Integer> future_5 = executorService.submit(() -> {
			TimeUnit.SECONDS.sleep(5);
			System.out.println("执行时长为5s的执行完成。");
			return 5;
		});
		list.add(future_5);

		Future<Integer> future_10 = executorService.submit(() -> {
			TimeUnit.SECONDS.sleep(10);
			System.out.println("执行时长为10s的执行完成。");
			return 10;
		});
		list.add(future_10);

		System.out.println("开始准备获取结果");
		for (Future<Integer> future : list) {
			System.out.println("future.get() = " + future.get());
		}
		Thread.currentThread().join();
	}
}
