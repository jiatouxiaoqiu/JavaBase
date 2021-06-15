package cn.ebing.dog.api.domain.entity;

/**
 * @Author qhb
 * @Date 2021/6/15 9:05 上午
 * @Version 1.0
 */
public class KeyCustomerEntity {
    /**
     * 产品代码
     */
    String produceCode;
    /**
     * 产品名称
     */
    String produceName;
    /**
     * 购货单位代码
     */
    String buyUnitCode;
    /**
     * 购货单位名称
     */
    String buyUnitName;
    /**
     * 摘要
     */
    String someInfo = "";
    /**
     * 规格型号
     */
    String modelId;
    /**
     * 销售数量
     */
    Double saleNumber;
    /**
     * 销售总价
     */
    Double saleTotalPrice;
    /**
     * 销售单价
     */
    Double saleUnitPrice;
    /**
     * 客户联系人信息
     */
    String customerContactInfo;
    /**
     * 客户地址
     */
    String customerAddress;
    /**
     * 客户电话
     */
    String customerTel;
    /**
     * 进价买价价格
     */
    Double buyUnitPrice = 0.0;
    /**
     * 最小购买数量
     */
    String minBuyNumber = "";
    /**
     * 卖价 - 买价 = 差额单价 = saleUnitPrice - buyUnitPrice
     */
    Double buySaleUnitPrice = 0.0;

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

    public Double getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Double saleNumber) {
        this.saleNumber = saleNumber;
    }

    public Double getSaleTotalPrice() {
        return saleTotalPrice;
    }

    public void setSaleTotalPrice(Double saleTotalPrice) {
        this.saleTotalPrice = saleTotalPrice;
    }

    public Double getSaleUnitPrice() {
        return saleUnitPrice;
    }

    public void setSaleUnitPrice(Double saleUnitPrice) {
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

    public Double getBuyUnitPrice() {
        return buyUnitPrice;
    }

    public void setBuyUnitPrice(Double buyUnitPrice) {
        this.buyUnitPrice = buyUnitPrice;
    }

    public String getMinBuyNumber() {
        return minBuyNumber;
    }

    public void setMinBuyNumber(String minBuyNumber) {
        this.minBuyNumber = minBuyNumber;
    }

    public Double getBuySaleUnitPrice() {
        return buySaleUnitPrice;
    }

    public void setBuySaleUnitPrice(Double buySaleUnitPrice) {
        this.buySaleUnitPrice = buySaleUnitPrice;
    }
}
