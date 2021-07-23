//package cn.ebing.dog.api.thread;
//
//
//import java.lang.management.ManagementFactory;
//import java.lang.management.ThreadInfo;
//import java.lang.management.ThreadMXBean;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//public class DeadLockSample extends Thread {
//	private String first;
//	private String second;
//	public DeadLockSample(String name, String first, String second) {
//		super(name);
//		this.first = first;
//		this.second = second;
//	}
//
//	@Override
//	public  void run() {
//		synchronized (first) {
//			System.out.println(this.getName() + " obtained: " + first);
//			try {
//				Thread.sleep(1000L);
//				synchronized (second) {
//					System.out.println(this.getName() + " obtained: " + second);
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	/**
//	 * 1 jps
//	 * 2 jstack [pid]
//	 *
//	 * 如果知道死锁。1、用上面的Java 命令。2、用 ThreadMXBean 的 Java代码扫描。然后每10秒进行一次死锁扫描
//	 */
//	public static void main(String[] args) throws InterruptedException {
//		ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
//		Runnable dlCheck = new Runnable() {
//			@Override
//			public void run() {
//				long[] threadIds = mbean.findDeadlockedThreads();
//				if (threadIds != null) {
//					ThreadInfo[] threadInfos = mbean.getThreadInfo(threadIds);
//					System.out.println("Detected deadlock threads:");
//					for (ThreadInfo threadInfo : threadInfos) {
//						System.out.println(threadInfo.getThreadName());
//					}
//				}
//			}
//		};
//
//		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//		// 稍等5秒，然后每10秒进行一次死锁扫描
//		scheduler.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);
//		/**
//		 * 下面是死锁的 demo 代码
//		 */
//		String lockA = "lockA";
//		String lockB = "lockB";
//		DeadLockSample t1 = new DeadLockSample("Thread1", lockA, lockB);
//		DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
//		/**
//		 * 这就是因为线程调度依赖于（操作系统）调度器，虽然你可以通过优先级之类进行影响，但是具体情况是不确定的。
//		 */
//		t1.start();
//		t2.start();
//    /**
//     * https://www.jianshu.com/p/ff637be3b671 线程的合并的含义就是 将几个并行线程的线程合并为一个单线程执行，应用场景是
//     * 当一个线程必须等待另一个线程执行完毕才能执行时，Thread类提供了join方法来完成这个功能，注意，它不是静态方法。
//     */
//    t1.join();
//		t2.join();
//	}
//}