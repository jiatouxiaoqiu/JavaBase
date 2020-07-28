package cn.ebing.dog.api.controller;

import com.crossoverjie.distributed.annotation.SpringControllerLimit;
import org.springframework.boot.autoconfigure.klock.annotation.Klock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/easy")
public class EasyController {

	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		}
	};

	@ResponseBody
	@GetMapping("/hello")
	public String list() {
		return df.get().format(new Date());
	}

	@Klock(waitTime = Long.MAX_VALUE, name = "klock_name")
	@GetMapping("/klock")
	public String getValue(String param) throws Exception {
		if ("sleep".equals(param)) {
			//线程休眠或者断点阻塞，达到一直占用锁的测试效果
			Thread.sleep(1000 * 50);
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