package cn.ebing.dog.api.controller;

import cn.ebing.dog.api.config.threadpool.AsyncTask;
import cn.ebing.dog.api.thread.RedisLockThread;
import com.crossoverjie.distributed.annotation.SpringControllerLimit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.klock.annotation.Klock;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;

@Controller
@RequestMapping("/easy")
public class EasyController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ApplicationContext applicationContext;

	/**
	 * @time 2021年06月22日16:11:55
	 * 避免和 系统变量、环境变量 冲突，最好的方法是加 prefix, 比如 dogUser.username; 这样
	 */
	@Value("${username}")
	String username;

	@Value("${password}")
	String password;

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
	@GetMapping("/value")
	public String valueTest() {
		return "username: " + username + "; password: " + password;
	}


	@ResponseBody
	@GetMapping("/hash")
	public int hash(
		@RequestParam String key
	) {
		int h;
		return  (h = key.hashCode()) ^ (h >>> 16);
	}

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

	/**
	 * @time 2021年06月23日10:19:08
	 *  name include /
	 *  需要看的是URL的匹配逻辑
	 *
	 *  2021年06月23日11:01:10
	 *
	 *  HttpHeader 里面可以用map
	 *  1、在http协议里面，header是忽略大小写的
	 *  2、在 java spring 框架的实现里面，如果直接用 header kv 的，是可以忽略大小写；如果用的map，是不忽略的、
	 *  也就是说，协议和实现，是两回事。然后在 其他语言来看，也是一样的。需要看具体实现逻辑
	 *
	 *  看到用 {@link org.springframework.util.LinkedCaseInsensitiveMap 就有点神奇啊 }
	 */
	@ResponseBody
	@PostMapping("/name/{name}")
	public String includeSpecialName(
			@PathVariable String name
	) {
		return name;
	}

	@ResponseBody
	@PostMapping("/encode")
	public String encode(
			HttpServletRequest request
	) {
		String fileUrl = request.getParameter("fileUrl");
		String decode = URLDecoder.decode(fileUrl);
		return "";
	}
}