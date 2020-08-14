package cn.ebing.dog.api.test.threadpool;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * google 异步 feature addListener,也是一个 lambda
 * listeningDecorator 一个装饰器模式
 * 从运行结果可以看出来：获取运行结果是在另外的线程里面执行的，完全没有阻塞主线程。
 */
public class JDKThreadPoolExecutorTest {
	public static void main(String[] args) throws Exception {
		ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
		ListenableFuture<String> listenableFuture = executor.submit(() -> {
			System.out.println(Thread.currentThread().getName()+"-女神：我开始化妆了，好了我叫你。");
			TimeUnit.SECONDS.sleep(5);
			return "化妆完毕了。";
		});

		listenableFuture.addListener(() -> {
			try {
				System.out.println(Thread.currentThread().getName()+"-future的内容:" + listenableFuture.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, executor);
		System.out.println(Thread.currentThread().getName()+"-等女神化妆的时候可以干点自己的事情。");
		Thread.currentThread().join();
	}
}
