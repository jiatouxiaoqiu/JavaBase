package cn.ebing.dog.api.thread.masterworker;

public class Client {
	public static void main(String[] args) {
		Master master = new Master(new MyWorker(), 100);
		/**
		 * Master-Worker实现计算1-100的平方和
		 * 分而治之
		 * 提交n个任务到任务队列里
		 */
		for (int i = 0; i < 100; i++) {
			Task task = new Task();
			task.setId(i);
			task.setName("任务"+i);
			task.setNum(i+1);
			master.submit(task);
		}

		//执行任务
		long start = System.currentTimeMillis();
		int res = master.execute();
		long time = (System.currentTimeMillis() - start) / 1000;
		System.out.println("结果:" +res+ ", 耗时:" +time + "秒");
	}
}
