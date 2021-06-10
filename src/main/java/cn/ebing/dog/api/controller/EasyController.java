package cn.ebing.dog.api.controller;

import cn.ebing.dog.api.config.threadpool.AsyncTask;
import cn.ebing.dog.api.thread.RedisLockThread;
import com.crossoverjie.distributed.annotation.SpringControllerLimit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.klock.annotation.Klock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;

@Controller
@RequestMapping("/easy")
public class EasyController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
	public String asyncTask(
		@RequestParam int length
	) {
		for (int i = 0; i < length; i++) {
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
	@Klock(waitTime = 3000, name = "clock_name")
	@GetMapping("/redis-clock")
	public String getValue(
		@RequestParam(value = "corePoolSize") int corePoolSize,
		@RequestParam(value = "sleepTimeInMicroSecond") int sleepTimeInMicroSecond
	) {
		consumerQueueThreadPool.execute(new RedisLockThread("name" + corePoolSize, sleepTimeInMicroSecond));
//		for (int i = 0; i < corePoolSize; i++) {
//			try {
//				consumerQueueThreadPool.execute(new RedisLockThread("name" + i, sleepTimeInMicroSecond));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		return "success";
	}


	@SpringControllerLimit(errorCode = 401,errorMsg = "request has limited")
	@ResponseBody
	@GetMapping("/SpringControllerLimit")
	public String redisLimit() {
		return "SpringControllerLimit";
	}

	String overload(String a, String b) {
		return a + b + "aa";
	}

	int overload(String a, int b) {
		return 1 + b;
	}

	/**
	 * HttpServletRequest 会把+吃掉的情况
	 */
	@ResponseBody
	@PostMapping("/add2space")
	public String overload(
		@RequestParam String add2space,
		HttpServletRequest request
	) {
		System.out.println("add2space   " + add2space);
		System.out.println("getQueryString   " + request.getQueryString());
		System.out.println("getParameter   " + request.getParameter("add2space"));

		return "success";
	}
}