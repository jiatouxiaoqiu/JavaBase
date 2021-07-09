package cn.ebing.dog.api.controller;

import io.swagger.annotations.ApiOperation;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CountDownLatch;

@Controller
@RequestMapping("/redis")
public class RedisController {

	private static Logger logger = LoggerFactory.getLogger(RedisController.class);

	/**
	 * 锁测试共享变量
	 */
	private Integer lockCount = 10;

	/**
	 * 无锁测试共享变量
	 */
	private Integer count = 10;

	/**
	 * 模拟线程数
	 */
	private static int threadNum = 10;

	/**
	 * 模拟并发测试加锁和不加锁
	 * @return
	 */
	@ResponseBody
	@GetMapping("/test")
	@ApiOperation(value = "模拟并发测试加锁和不加锁")
	public String lock(){
		// 计数器
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		for (int i = 0; i < threadNum; i ++) {
			MyRunnable myRunnable = new MyRunnable(countDownLatch);
			Thread myThread = new Thread(myRunnable);
			myThread.start();
		}
		// 释放所有线程
		countDownLatch.countDown();
		return "success";
	}

  /**
   * 分布式锁，锁很多。可重入锁（非公平锁）、公平锁、读写锁、RedLock
   *
   * <p>可重入锁
   *
   * <p>lock 1、lock 的 lua 脚本，crc16寻找slot，可重入锁+1, 加锁失败后，会在 Java 代码中使用 while 循环一直尝试加锁。 2、watchdog
   * addListener 这样一通续租下来，就是在过了 10s 左右将锁的时间重新设置为 30s。 unlock
   *
   * <p>公平锁
   *
   * <p>这里涉及到比较多的 Redis 操作，做一下简要总结：
   *
   * <p>Redis Hash 数据结构：存放当前锁，Redis Key 就是锁，Hash 的 field 是加锁线程，Hash 的 value 是 重入次数； Redis
   * List数据结构：充当线程等待队列，新的等待线程会使用 rpush 命令放在队列右边； Redis sorted set 有序集合数据结构：存放等待线程的顺序，分数 score
   * 用来是等待线程的超时时间戳。
   *
   * <p>MultiLock 总体而言，就是将 key1、key2、key3 …… keyN 放到一个 List 集合中，然后迭代循环加锁，直到所有的都成功。解锁的时候就是再遍历锁进行释放锁。
   *
   * <p>Redisson RedLock 是基于联锁 MultiLock 实现的，但是使用过程中需要自己判断 key 落在哪个节点上，对使用者不是很友好。
   *
   * <p>Redisson RedLock 已经被弃用，直接使用普通的加锁即可，会基于 wait 机制将锁同步到从节点，但是也并不能保证一致性。仅仅是最大限度的保证一致性。
   *
   *
   * <p>Redisson 还支持可重入读写锁，允许在分布式场景下，同时有多个读锁和一个写锁处于加锁状态。
   * 读操作>>写操作的情况下，要用读写锁，读读不互斥，读写，写写互斥；普通的锁是独占锁，读读也互斥的，只是我们一般不会在读里面加锁
   *
   * 提供了同步组件，Semaphore 和 CountDownLatch。分布式信号量。因为JUC的是单机版的信号量
   */
  @ResponseBody
  @GetMapping("/redisson")
  public String redisson() {
		Config config = new Config();
		config.useClusterServers().
				addNodeAddress("redis://127.0.0.1:7000").
				addNodeAddress("redis://127.0.0.1:7001").
				addNodeAddress("redis://127.0.0.1:7002");

		RedissonClient redissonClient = Redisson.create(config);
		RLock rLock = redissonClient.getLock("key_name");
		RLock fairLock = redissonClient.getFairLock("fairLockName");
	  fairLock.lock();

	  rLock.lock();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			logger.info("e" + e);
		}
		rLock.unlock();
		redissonClient.shutdown();

		return "success";
	}

	/**
	 * 生成redis-key
	 * @return
	 */
	@ResponseBody
	@GetMapping("/key")
	public String generateKey(
		@RequestParam Boolean isLock,
		@RequestParam Boolean isUnlock
	) {
//		if (isLock) {
//			RedisLockUtil.lock("generateKey");
//		}
//		if (isUnlock) {
//			RedisLockUtil.unlock("generateKey");
//		}
		return "success";
	}

	/**
	 * 加锁测试
	 */
	private void testLockCount() {
		String lockKey = "lock-test";
//		try {
//			// 加锁，设置超时时间2s
//			RedisLockUtil.lock(lockKey,2, TimeUnit.SECONDS);
//			lockCount--;
//			logger.info("lockCount值："+lockCount);
//		}catch (Exception e){
//			logger.error(e.getMessage(),e);
//		}finally {
//			// 释放锁
//			RedisLockUtil.unlock(lockKey);
//		}
	}

	/**
	 * 无锁测试
	 */
	private void testCount() {
		count--;
		logger.info("count值："+count);
	}


	public class MyRunnable implements Runnable {
		/**
		 * 计数器
		 */
		final CountDownLatch countDownLatch;

		public MyRunnable(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public void run() {
			try {
				// 阻塞当前线程，直到计时器的值为0
				countDownLatch.await();
			} catch (InterruptedException e) {
				logger.error(e.getMessage(),e);
			}
			// 无锁操作
			testCount();
			// 加锁操作
			testLockCount();
		}

	}
}