package cn.ebing.dog.api.domain.request;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Author qhb
 * @Date 2021/6/15 10:04 上午
 * @Version 1.0
 */
public class KeyCustomerSaleRequest {
    /**
     * 产品代码
     */
    @ExcelProperty(index = 7)
    String produceCode;
    /**
     * 产品名称
     */
    @ExcelProperty(index = 8)
    String produceName;
    /**
     * 购货单位代码
     */
    @ExcelProperty(index = 10)
    String buyUnitCode;
    /**
     * 购货单位名称
     */
    @ExcelProperty(index = 12)
    String buyUnitName;
    /**
     * 摘要
     */
    @ExcelProperty(index = 13)
    String someInfo;
    /**
     * 规格型号
     */
    @ExcelProperty(index = 14)
    String modelId;
    /**
     * 销售数量
     */
    @ExcelProperty(index = 28)
    String saleNumber;
    /**
     * 销售总价
     */
    @ExcelProperty(index = 30)
    String saleTotalPrice;
    /**
     * 销售单价
     */
    @ExcelProperty(index = 31)
    String saleUnitPrice;
    /**
     * 客户联系人信息
     */
    @ExcelProperty(index = 37)
    String customerContactInfo;
    /**
     * 客户地址
     */
    @ExcelProperty(index = 39)
    String customerAddress;
    /**
     * 客户电话
     */
    @ExcelProperty(index = 40)
    String customerTel;

    public String getProduceCode() {
        return produceCode;
    }

    public void setProduceCode(String produceCode) {
        this.produceCode = produceCode;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getBuyUnitCode() {
        return buyUnitCode;
    }

    public void setBuyUnitCode(String buyUnitCode) {
        this.buyUnitCode = buyUnitCode;
    }

    public String getBuyUnitName() {
        return buyUnitName;
    }

    public void setBuyUnitName(String buyUnitName) {
        this.buyUnitName = buyUnitName;
    }

    public String getSomeInfo() {
        return someInfo;
    }

    public void setSomeInfo(String someInfo) {
        this.someInfo = someInfo;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public String getSaleTotalPrice() {
        return saleTotalPrice;
    }

    public void setSaleTotalPrice(String saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }

    public String getSaleUnitPrice() {
        return saleUnitPrice;
    }

    public void setSaleUnitPrice(String saleUnitPrice) {
        this.saleUnitPrice = saleUnitPrice;
    }

    public String getCustomerContactInfo() {
        return customerContactInfo;
    }

    public void setCustomerContactInfo(String customerContactInfo) {
        this.customerContactInfo = customerContactInfo;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }
}
