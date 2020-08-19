package cn.ebing.dog.api.thread.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {
	private BlockingDeque<Data> queue ;

	private static Random random = new Random();

	public Consumer(BlockingDeque<Data> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Data data = queue.take();
				//模拟抽水耗时
				Thread.sleep(random.nextInt(1000));
				if (data == null) {
					System.out.println("抽水完成");
					break;
				}
				System.out.println("当前<<抽水管:"+Thread.currentThread().getName()+",抽取水容量(L):"+data.getNum());

			}catch (Exception e){
				e.printStackTrace();
			}

		}
	}
}
