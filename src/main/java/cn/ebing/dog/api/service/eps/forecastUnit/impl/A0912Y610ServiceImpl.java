package cn.ebing.dog.api.service.eps.forecastUnit.impl;

import cn.ebing.dog.api.bs.eps.forecastUnit.A0912Y610Bs;
import cn.ebing.dog.api.service.eps.forecastUnit.A0912Y610Service;
import cn.ebing.dog.api.utils.AccessExcelUitl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("A0912Y610Service")
public class A0912Y610ServiceImpl implements A0912Y610Service {

	@Resource
	A0912Y610Bs a0912Y610Bs;

	@Override
	public void batchUploadForecastUnits(String name) {
		String filepath = "/Users/mx/Desktop/" + name + ".xlsx";
		List<List<String>> sheetResults = AccessExcelUitl.readExcel(filepath);
		a0912Y610Bs.batchInsertForecastUnits(sheetResults);
	}

}
