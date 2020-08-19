package cn.ebing.dog.api.thread.masterworker;

public class MyWorker extends Worker {
	@Override
	public Object doTask(Task task) {
		//暂停0.5秒，模拟任务处理
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//计算数字的平方
		int num = task.getNum();
		return num * num;
	}
}