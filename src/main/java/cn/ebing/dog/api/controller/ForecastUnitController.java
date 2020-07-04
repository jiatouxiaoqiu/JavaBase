package cn.ebing.dog.api.controller;

import cn.ebing.dog.api.service.eps.forecastUnit.A0912Y610Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/forecastUnit")
public class ForecastUnitController {

	private static Logger logger = LoggerFactory.getLogger(ForecastUnitController.class);

	@Autowired
	private A0912Y610Service a0912Y610Service;

	@ResponseBody
	@PostMapping("/upload")
	public String upload(
			@RequestParam("name") String name
	) {
		System.out.println("-- upload --");
		a0912Y610Service.batchUploadForecastUnits(name);
		return "success";
	}
}