DROP TABLE IF EXISTS `tbl_key_customer`;
CREATE TABLE IF NOT EXISTS `tbl_key_customer`(
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `produceCode` varchar(800) NOT NULL default '' COMMENT '产品代码',
  `produceName` varchar(800) NOT NULL default '' COMMENT '产品名称',
  `buyUnitCode` varchar(800) NOT NULL default '' COMMENT '购货单位代码',
  `buyUnitName` varchar(800) NOT NULL default '' COMMENT '购货单位名称',
  `someInfo` varchar(800) NOT NULL default '' COMMENT '摘要',
  `modelId` varchar(800) NOT NULL default '' COMMENT '规格型号',
  `saleNumber` double NOT NULL default 0 COMMENT '销售数量',
  `saleTotalPrice` double NOT NULL default '0' COMMENT '销售总价',
  `saleUnitPrice` double NOT NULL default '0' COMMENT '销售单价（单价：元）',
  `customerContactInfo` varchar(800) NOT NULL default '' COMMENT '客户联系人信息',
  `customerAddress` varchar(800) NOT NULL default '' COMMENT '客户地址',
  `customerTel` varchar(800) NOT NULL default '' COMMENT '客户电话',
  `buyUnitPrice` double NOT NULL default 0 COMMENT '进价买价价格',
  `minBuyNumber` varchar(800) NOT NULL default '' COMMENT '最小购买数量',
  `buySaleUnitPrice` double NOT NULL default 0 COMMENT '卖价 - 买价 = 差额单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='KeyCustomerEntity';

ALTER TABLE `tbl_key_customer` drop COLUMN `minBuyNumber`;
ALTER TABLE `tbl_key_customer` add COLUMN `minBuyNumber` varchar(800) NOT NULL default '' COMMENT 'minBuyNumber' after buyUnitPrice;

update tbl_key_customer set buySaleUnitPrice = saleUnitPrice - buyUnitPrice;

select * from tbl_key_customer where buyUnitPrice>0 ORDER BY buySaleUnitPrice desc;