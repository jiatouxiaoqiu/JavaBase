//package cn.ebing.dog.api.controller;
//
//import cn.ebing.dog.api.converter.KeyCustomerConverter;
//import cn.ebing.dog.api.domain.entity.KeyCustomerEntity;
//import cn.ebing.dog.api.mapper.KeyCustomerMapper;
//import cn.ebing.dog.api.utils.AccessExcelUtil;
//import cn.ebing.dog.api.utils.CommonUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Author qhb
// * @Date 2021/6/15 9:38 上午
// * @Version 1.0
// */
//@Controller
//@RequestMapping("/key-customer")
//public class KeyCustomerController {
//
//    @Autowired
//    private KeyCustomerConverter converter;
//
//    @Autowired
//    private KeyCustomerMapper mapper;
//
//    @Transactional
//    @ResponseBody
//    @PostMapping("/buy-chejian")
//    public String insertManyBuysChejian() {
//        String filename = "/Users/mx/Desktop/ancle_key/buy/chejian_jiaoke.xlsx";
//        List<List<String>> buyUnitPriceSheets = AccessExcelUtil.readExcel(filename, 0);
//        List<KeyCustomerEntity> entities = new ArrayList<>();
//        buyUnitPriceSheets.forEach(content -> {
//            /**
//             * @time 2021年06月22日16:54:34
//             *
//             * 噢噢噢，this.converter == converter 啊，this 代表 KeyCustomerController 这个上下文的吧,神奇
//             * this 代表当前对象
//             */
//            KeyCustomerEntity entity = this.converter.toEntityInBuyUnitPrice(content);
//            entities.add(entity);
//        });
//
//        /**
//         * map [modelId, buy_number]
//         */
//        List<List<String>> minBuyNumberSheets = AccessExcelUtil.readExcel(filename, 1);
//        Map<String, String> minBuyNumberMap = new HashMap<>();
//        minBuyNumberSheets.forEach(item -> {
//            minBuyNumberMap.put(item.get(1), item.get(2));
//        });
//
//        for (KeyCustomerEntity entity: entities) {
//            String minBuyNumber = minBuyNumberMap.get(entity.getModelId());
//            if (minBuyNumber == null || minBuyNumber.trim().isEmpty()) {
//                minBuyNumber = "没填写";
//            }
//            entity.setMinBuyNumber(minBuyNumber);
//        }
//
//        mapper.updateMany(entities);
//        return "success";
//    }
//
//    @Transactional
//    @ResponseBody
//    @PostMapping("/buy-dianzi")
//    public String insertManyBuysDianzi() {
//        String filename = "/Users/mx/Desktop/ancle_key/buy/dianzijian13.xls";
//        List<List<String>> buyUnitPriceSheets = AccessExcelUtil.readExcel(filename, 0);
//        List<KeyCustomerEntity> entities = new ArrayList<>();
//        buyUnitPriceSheets.forEach(content -> {
//            KeyCustomerEntity entity = converter.toEntityInBuyUnitPriceDianzi(content);
//            entities.add(entity);
//        });
//
//        /**
//         * map [modelId, buy_number]
//         */
//        List<List<String>> minBuyNumberSheets = AccessExcelUtil.readExcel(filename, 1);
//        Map<String, String> minBuyNumberMap = new HashMap<>();
//        minBuyNumberSheets.forEach(item -> {
//            minBuyNumberMap.put(item.get(1), item.get(3));
//        });
//
//        for (KeyCustomerEntity entity: entities) {
//            String minBuyNumber = minBuyNumberMap.get(entity.getModelId());
//            if (minBuyNumber == null || minBuyNumber.trim().isEmpty()) {
//                minBuyNumber = "没填写";
//            }
//            entity.setMinBuyNumber(minBuyNumber);
//        }
//
//        List<List<KeyCustomerEntity>> list = CommonUtil.partition(entities, 200);
//        list.forEach(li -> {
//            mapper.updateMany(li);
//        });
//        return "success";
//    }
//
//    @Transactional
//    @ResponseBody
//    @PostMapping("/sale")
//    public String insertManySales(
//    ) {
//        List<String> names = Arrays.asList("A", "B", "D", "E", "F", "H", "J", "M", "Z");
//        List<List<String>> contents = new ArrayList<>();
//        names.forEach(name -> {
//            String filename = "/Users/mx/Desktop/ancle_key/sale/" + name + ".xls";
//            List<List<String>> fileResults = AccessExcelUtil.readExcel(filename);
//            contents.addAll(fileResults);
//        });
//
//        List<KeyCustomerEntity> entities = new ArrayList<>();
//        contents.forEach(content -> {
//            KeyCustomerEntity entity = converter.toEntityInSale(content);
//            entities.add(entity);
//        });
//        mapper.insertMany(entities);
//        return "success";
//    }
//}
