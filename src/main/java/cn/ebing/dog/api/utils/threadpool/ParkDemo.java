package cn.ebing.dog.api.utils.threadpool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * semaphore 我们一般叫它信号量，用来控制同时访问指定资源的线程数量。
 * 在运行时，有时只会执行完线程A，其线程B和线程C都静默了,why???
 * availablePermits：获取剩余可用许可证。
 * drainPermits ：获取剩余可用许可证。
 * release（int n）：释放指定数量的许可证。
 * acquire（int n）：申请指定数量的许可证。
 *
 *这句话非常关键：说的是执行 release 操作的线程不一定非得是执行了 acquire 方法的线程。release 操作这里，大家都知道需要放到 finally 代码块里面去执行。但是正是这个认知，是最容易踩坑的地方，而且出了问题还非常不好排查的那种。
 * 放肯定是要放在 finally 代码块里面的，只是怎么放，这里有点讲究。
 *
 * 导致问题的原因是没有获取到许可证的线程，调用了 release 方法。
 * 我觉得这个设定，就是非常容易踩坑的地方。简直就是一个大坑！
 * 我们可以就这个问题，对 release 方法进行增强，只有获取后的线程，才能调用 release 方法。《扩展 Semaphore 增强 release》
 */
public class ParkDemo {
	public static void main(String[] args) throws InterruptedException {

		Integer parkSpace = 3;
		System.out.println("这里有" + parkSpace + "个停车位,先到先得啊！");
		Semaphore semaphore = new Semaphore(parkSpace, true);

		Thread threadA = new Thread(new ParkCar(1, "布加迪", semaphore), "赵四");
		Thread threadB = new Thread(new ParkCar(2, "法拉利", semaphore), "刘能、谢广坤");
		Thread threadC = new Thread(new ParkCar(1, "劳斯莱斯", semaphore), "dog");

		threadA.start();
		threadB.start();
		threadC.start();

		//模拟大爷劝退
		threadB.interrupt();
	}
}

class ParkCar implements Runnable {

	private int n;
	private String carName;
	private Semaphore semaphore;

	public ParkCar(int n, String carName, Semaphore semaphore) {
		this.n = n;
		this.carName = carName;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			/**
			 * drainPermits
			 * availablePermits
			 * availablePermits 只是看看还有多少许可证，drainPermits 是拿走所有剩下的许可证。
			 */
			if (semaphore.availablePermits() < n) {
				System.out.println(Thread.currentThread().getName() + "来停车,但是停车位不够了,等着吧");
			}
			// 这个方法可以增强
			semaphore.acquire(n);
			System.out.println(Thread.currentThread().getName() + "把自己的" + carName + "停进来了,剩余停车位:" + semaphore.availablePermits() + "辆");
			//模拟停车时长
			int parkTime = ThreadLocalRandom.current().nextInt(1, 6);
			TimeUnit.SECONDS.sleep(parkTime);
			System.out.println(Thread.currentThread().getName() + "把自己的" + carName + "开走了,停了" + parkTime + "小时");
		} catch (InterruptedException e) {
			System.err.println(Thread.currentThread().getName() + "被门口大爷劝走了。");
		} finally {
			// 这个方法可以增强
			semaphore.release(n);
			System.out.println(Thread.currentThread().getName() + "走后,剩余停车位:" + semaphore.availablePermits() + "辆");
		}
	}
}