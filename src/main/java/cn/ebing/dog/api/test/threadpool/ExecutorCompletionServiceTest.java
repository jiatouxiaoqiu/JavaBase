package cn.ebing.dog.api.test.threadpool;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 我们先对比一下 Executor 直接提交和 ExecutorCompletionService 提交的差异：
 * QueueingFuture 继承自 FutureTask。重写了 done 方法，然后把 task 放到 queue 里面。
 * 这个方法的含义就是当任务执行完成后，就会被放到队列里面去了。也就是说队列里面的 task 都是已经 done 了的 task，而这个 task 就是一个个 future。
 * 如果调用 queue 的 task 方法，就是阻塞等待。等到的一定是就绪了的 future，调用 get 就能立马获得结果。
 * 你说这一套操作是在干啥？
 * 这不就是在做解耦吗？
 * 之前你提交任务后还需要直接关心每个任务返回的 future。现在 CompletionService 帮你对这些 future 进行了跟踪。
 * 完成了调用者和 future 之间的解耦。
 * 原理分析完了，说一个需要注意的地方。
 * 当你的使用场景是不关心返回值的时候千万不要闲的蛋疼的用 CompletionService 去提交任务。
 * 为什么？
 * 因为前面说了，里面有个队列。而当你不关心返回值的时候也就是不会去处理这个队列，导致这个队列里面的对象堆积的越来越多。
 * 最后，炸了，OOM了。
 */
public class ExecutorCompletionServiceTest {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
		System.out.println("约几个妹子一起吃个饭吧。");
		completionService.submit(() -> {
			System.out.println("小红：好的，哥哥。我化妆要2个小时。等一下哦。");
			TimeUnit.SECONDS.sleep(15);
			System.out.println("小红：我2个小时准时化好了，哥哥来接我吧。");
			return "小红化完了。";
		});
		completionService.submit(() -> {
			System.out.println("小媛：好的，哥哥。我化妆要30分钟。等一下哦。");
			TimeUnit.SECONDS.sleep(5);
			System.out.println("小媛：我30分钟准时化好了，哥哥来接我吧。");
			return "小媛化完了。";
		});
		completionService.submit(() -> {
			System.out.println("小花：好的，哥哥。我化妆要1个小时。等一下哦。");
			TimeUnit.SECONDS.sleep(10);
			System.out.println("小花：我1个小时准时化好了，哥哥来接我吧。");
			return "小花化完了。";
		});
		TimeUnit.SECONDS.sleep(1);
		System.out.println("都通知完,等着吧。");
		//循环3次是因为上面提交了3个异步任务
		for (int i = 0; i < 3; i++) {
			String returnStr = completionService.take().get();
			System.out.println(returnStr + "我去接她");
		}
		Thread.currentThread().join();
	}
}
