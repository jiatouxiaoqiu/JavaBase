package cn.ebing.dog.api.bs.eps.forecastUnit.impl;

import cn.ebing.dog.api.bs.eps.forecastUnit.A0912Y610Bs;
import cn.ebing.dog.api.converter.ForecastUnitConverter;
import cn.ebing.dog.api.domain.entity.ForecastUnitEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("A0912Y610Impl")
public class A0912Y610BsImpl implements A0912Y610Bs {

	@Autowired
	private ForecastUnitConverter forecastUnitConverter;

	@Override
	public void batchInsertForecastUnits(List<List<String>> sheetResults) {
		if (sheetResults.isEmpty()) {
			return;
		}
		List<ForecastUnitEntity> entities = new ArrayList<ForecastUnitEntity>();

		for (int i = 0; i < sheetResults.size(); i++) {
			entities.add(forecastUnitConverter.toEntity(sheetResults.get(i)));
		}

		entities.size();
	}
}
