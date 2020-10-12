package cn.ebing.dog.api.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class RedisLockThread implements Runnable {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String threadName;
	private int sleepTimeInMicroSecond;

	public RedisLockThread(String threadName, int sleepTimeInMicroSecond) {
		this.threadName = threadName;
		this.sleepTimeInMicroSecond = sleepTimeInMicroSecond;
	}

	@Override
	public void run() {
		logger.info("start run" + threadName + new Date());
		try {
			Thread.sleep(sleepTimeInMicroSecond);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end run" + threadName + new Date());
	}
}
