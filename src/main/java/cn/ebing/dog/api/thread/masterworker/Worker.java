package cn.ebing.dog.api.thread.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	private ConcurrentLinkedQueue<Task> taskQueue;

	private ConcurrentHashMap<String,Object> resultMap;

	public void setTaskQueue(ConcurrentLinkedQueue<Task> taskQueue) {
		this.taskQueue = taskQueue;
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	@Override
	public void run() {
		while(true) {
			/**
			 * 从任务队列中取出一个任务
			 * 多线程里面，一个线程是停不住工作的，除非没有了
			 */
			Task task = taskQueue.poll();
			if(task == null) {
				break;
			}
			//处理具体的任务
			Object res = doTask(task);
			//把每次处理的结果放到结果集里面，此处直接把num值作为结果
			resultMap.put(String.valueOf(task.getId()), res);
		}

	}

	public Object doTask(Task task) {
		return null;
	}
}
