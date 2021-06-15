package cn.ebing.dog.api.converter;

import cn.ebing.dog.api.domain.entity.KeyCustomerEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author qhb
 * @Date 2021/6/15 1:57 下午
 * @Version 1.0
 */
@Component
public class KeyCustomerConverter {

    public KeyCustomerEntity toEntityInSale(List<String> sheet) {
        KeyCustomerEntity entity = new KeyCustomerEntity();
        entity.setProduceCode(sheet.get(7));
        entity.setProduceName(sheet.get(8));

        entity.setBuyUnitCode(sheet.get(10));
        entity.setBuyUnitName(sheet.get(12));

        entity.setSomeInfo(sheet.get(19));
        entity.setModelId(sheet.get(14));

        entity.setSaleNumber(Double.valueOf(sheet.get(28)));
        entity.setSaleUnitPrice(Double.valueOf(sheet.get(30)));
        entity.setSaleTotalPrice(Double.valueOf(sheet.get(31)));

        entity.setCustomerContactInfo(sheet.get(37));
        entity.setCustomerAddress(sheet.get(39));
        entity.setCustomerTel(sheet.get(40));

        return entity;
    }

    public KeyCustomerEntity toEntityInBuyUnitPrice(List<String> sheet) {
        KeyCustomerEntity entity = new KeyCustomerEntity();
        entity.setModelId(sheet.get(1));
        entity.setBuyUnitPrice(Double.valueOf(sheet.get(2))/1000);
        return entity;
    }

    public KeyCustomerEntity toEntityInBuyUnitPriceDianzi(List<String> sheet) {
        KeyCustomerEntity entity = new KeyCustomerEntity();
        entity.setModelId(sheet.get(0));
        entity.setBuyUnitPrice(Double.valueOf(sheet.get(2))/1000);
        return entity;
    }
}
