package cn.ebing.dog.api.thread.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
	//共享阻塞队列
	private BlockingDeque<Data> queue;
	//是否还在运行
	private volatile boolean isRunning = true;
	//id生成器
	private static AtomicInteger count = new AtomicInteger();
	//生成随机数
	private static Random random = new Random();

	public Producer(BlockingDeque<Data> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while(isRunning){
				//模拟注水耗时
				Thread.sleep(random.nextInt(1000));

				int num = count.incrementAndGet();
				Data data = new Data(num, num);
				System.out.println("当前>>注水管:"+Thread.currentThread().getName()+"注水容量(L):"+num);

				if(!queue.offer(data,2, TimeUnit.SECONDS)){
					System.out.println("注水失败...");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void stop(){
		isRunning = false;
	}
}
