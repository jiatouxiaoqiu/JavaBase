package cn.ebing.dog.api.converter;

import cn.ebing.dog.api.common.constant.Constants;
import cn.ebing.dog.api.domain.entity.ForecastUnitEntity;
import cn.ebing.dog.api.utils.CommonUtil;
import cn.ebing.dog.api.utils.DateUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author qiuhengbin
 */
@Component
public class ForecastUnitConverter {

	public ForecastUnitEntity toEntity(List<String> sheetResult) {
		ForecastUnitEntity entity = new ForecastUnitEntity();

		String unitId = CommonUtil.create32Key();
		entity.setUnitId(unitId);

		String unitName = sheetResult.get(0);
		entity.setUnitName(unitName);

		String now = String.valueOf(DateUtil.getSecondTimestamp());
		entity.setCrtDt(now);

		entity.setCalculationMethod(sheetResult.get(7));

		String[] interestSubclass = sheetResult.get(2).split(Constants.SPLIT);
		entity.setInterestSubclass(interestSubclass[0]);
		entity.setInterestSubclass(interestSubclass[1]);

		return entity;
	}
}
