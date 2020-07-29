package cn.ebing.dog.api.controller;

import cn.ebing.dog.api.config.threadpool.AsyncTask;
import com.crossoverjie.distributed.annotation.SpringControllerLimit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.klock.annotation.Klock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.LockSupport;

@Controller
@RequestMapping("/easy")
public class EasyController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		}
	};

	@Resource(name = "consumerQueueThreadPool")
	private ExecutorService consumerQueueThreadPool;

	@Autowired
	private AsyncTask asyncTask;

	@ResponseBody
	@GetMapping("/asyncTask")
	public String asyncTask() {
		for (int i = 0; i < 10; i++) {
			try {
				asyncTask.doTask1(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("All tasks finished.");
		return "success";
	}

	@ResponseBody
	@Klock(waitTime = 1000, name = "klock_name")
	@GetMapping("/klock")
	public String getValue(
		@RequestParam(value = "corePoolSize") int corePoolSize
	) {
		if ("sleep".equals(corePoolSize)) {
			LockSupport.parkNanos(5000);
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//线程休眠或者断点阻塞，达到一直占用锁的测试效果
			return "Klock value";
		}
		return "success";
	}


	@SpringControllerLimit(errorCode = 401,errorMsg = "request has limited")
	@ResponseBody
	@GetMapping("/SpringControllerLimit")
	public String redisLimit() {
		return "SpringControllerLimit";
	}

	@ResponseBody
	@PostMapping("/set")
	public String set() {
		Set<Integer> set1 = new HashSet<>();

		for (int i =0; i<100; i++) {
			set1.add(i);
			set1.remove(i-1);
		}

		System.out.println(set1.size());

		Set<Short> set2 = new HashSet<>();

		for (short i =0; i<100; i++) {
			set2.add(i);
			set2.remove(i-1);
		}

		System.out.println(set2.size());

		Object i = 1 == 1 ? new Integer(3) : new Float(1);
		System.out.println(i);
		return "success";
	}
}