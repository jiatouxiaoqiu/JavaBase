package cn.ebing.dog.api.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 同步工具类！！！
 * 大家一起做事情，CountDownLatch 就是保证最后完成的时间，取决于那个最大的那个人
 * 做android的，一个页面有A,B,C三个网络请求，其中请求C需要请求A和请求B的返回数据作为参数，用过CountdownLatch解决。
 */
public class CountDownTest {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		Worker w1 = new Worker("张三", 2000, latch);
		Worker w2 = new Worker("李四", 3000, latch);
		w1.start();
		w2.start();

		long startTime = System.currentTimeMillis();
		latch.await();
		System.out.println("bug全部解决，领导可以给客户交差了，任务总耗时："+ (System.currentTimeMillis() - startTime));

	}

	static class Worker extends Thread{
		String name;
		int workTime;
		CountDownLatch latch;

		public Worker(String name, int workTime, CountDownLatch latch) {
			this.name = name;
			this.workTime = workTime;
			this.latch = latch;
		}

		/**
		 * countDown 就是完成结束的打卡
		 */
		@Override
		public void run() {
			System.out.println(name+"开始修复bug，当前时间："+sdf.format(new Date()));
			doWork();
			System.out.println(name+"结束修复bug，当前时间："+sdf.format(new Date()));
			latch.countDown();
		}

		private void doWork() {
			try {
				//模拟工作耗时
				Thread.sleep(workTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}