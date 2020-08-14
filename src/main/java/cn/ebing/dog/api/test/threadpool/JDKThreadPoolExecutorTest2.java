package cn.ebing.dog.api.test.threadpool;

import com.google.common.util.concurrent.*;
import com.sun.istack.internal.Nullable;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JDKThreadPoolExecutorTest2 {

	public static void main(String[] args) throws Exception {
		ListeningExecutorService executor = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
		ListenableFuture<String> listenableFuture = executor.submit(() -> {
			System.out.println(Thread.currentThread().getName()+"-女神：我开始化妆了，好了我叫你。");
			TimeUnit.SECONDS.sleep(5);
			return "化妆完毕了。";
		});
		Futures.addCallback(listenableFuture, new FutureCallback<String>() {
			@Override
			public void onSuccess(@Nullable String result) {
				System.out.println(Thread.currentThread().getName()+"-future的内容:" + result);
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println(Thread.currentThread().getName()+"-女神放你鸽子了。");
				t.printStackTrace();
			}
		});
		System.out.println(Thread.currentThread().getName()+"-等女神化妆的时候可以干点自己的事情。");
		Thread.currentThread().join();
	}
}