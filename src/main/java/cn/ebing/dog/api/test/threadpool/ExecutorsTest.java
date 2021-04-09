package cn.ebing.dog.api.test.threadpool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个线程池中的线程异常了，那么线程池会怎么处理这个线程?
 *
 *当执行方式是execute时,可以看到堆栈异常的输出。
 * 当执行方式是submit时,堆栈异常没有输出。但是调用Future.get()方法时，可以捕获到异常。
 * 不会影响线程池里面其他线程的正常执行。
 * 线程池会把这个线程移除掉，并创建一个新的线程放到线程池中。
 */
public class ExecutorsTest {
	public static void main(String[] args) {
		ThreadPoolTaskExecutor executorService = buildThreadPoolTaskExecutor();
		executorService.execute(() -> sayHi("execute"));
		executorService.execute(() -> sayHi("submit"));
	}

	private static void sayHi(String name) {
		String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name+"】";
		System.out.println(printStr);
		throw new RuntimeException(printStr + ",异常啦");
	}

	public static ThreadPoolTaskExecutor buildThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
		executorService.setThreadNamePrefix("dog_api_thread_name-");
		executorService.setCorePoolSize(5);
		executorService.setMaxPoolSize(10);
		executorService.setQueueCapacity(1000);
		executorService.setKeepAliveSeconds(30);
//		executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executorService.initialize();
		return executorService;
	}

	/**
	 * 这个方法是JVM调用的，我们只需要指定我们想要的处理方式即可。
	 * 人工指定。setUncaughtExceptionHandler
	 */
	private void test() {
		//直接new Thread()的时候
		Thread t = new Thread();
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				//根据业务场景，做你想做的
			}
		});

		//线程池的时候:
		ExecutorService threadPool = Executors.newFixedThreadPool(1, r -> {
			Thread thread = new Thread(r);
			thread.setUncaughtExceptionHandler(
					(t1, e) -> System.out.println("根据业务场景，做你想做的:" + e.getMessage()));
			return thread;
		});
	}


}

