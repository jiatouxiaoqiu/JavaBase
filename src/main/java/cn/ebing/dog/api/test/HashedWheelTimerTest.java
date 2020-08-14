package cn.ebing.dog.api.test;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.TimerTask;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HashedWheelTimerTest {
	public static void main(String[] args) {
		watchDog();
	}

	private static void watchDog() {
		HashedWheelTimer timer = new HashedWheelTimer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run(Timeout timeout) throws Exception {
				System.out.println("watchDog 循环执行; date = " + new Date());
				watchDog();
			}
		};
		TimerTask timerTaskWithLambda = (Timeout timeout) -> {
			System.out.println("watchDog 循环执行; date = " + new Date());
			watchDog();
		};
		timer.newTimeout(timerTaskWithLambda, 3, TimeUnit.SECONDS);
	}
}
