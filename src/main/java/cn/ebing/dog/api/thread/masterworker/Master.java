package cn.ebing.dog.api.thread.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	//所有任务的队列
	private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<Task>();

	//所有worker
	private HashMap<String,Thread> workerMap = new HashMap<String,Thread>();

	//共享变量，worker返回的结果
	private ConcurrentHashMap<String,Object> resultMap = new ConcurrentHashMap<String,Object>();

	//构造方法,初始化所有worker
	public Master(Worker worker, int workerCount){
		worker.setTaskQueue(this.taskQueue);
		worker.setResultMap(this.resultMap);

		for (int i = 0; i < workerCount; i++) {
			Thread t = new Thread(worker);
			this.workerMap.put("worker-"+i,t);
		}
	}

	//任务的提交
	public void submit(Task task){
		this.taskQueue.add(task);
	}

	//执行任务
	public int execute() {
		for (Map.Entry<String, Thread> entry : workerMap.entrySet()) {
			entry.getValue().start();
		}

		//一直循环，直到结果返回
		while (true){
			if(isComplete()){
				return getResult();
			}
		}

	}

	//判断是否所有线程都已经执行完毕
	public boolean isComplete(){
		for (Map.Entry<String, Thread> entry : workerMap.entrySet()) {
			//只要有任意一个线程没有结束，就返回false
			if(entry.getValue().getState() != Thread.State.TERMINATED){
				return false;
			}
		}
		return true;
	}

	//处理结果集返回最终结果
	public int getResult(){
		int res = 0;
		for (Map.Entry<String,Object> entry : resultMap.entrySet()) {
			res += (Integer) entry.getValue();
		}
		return res;
	}

}
