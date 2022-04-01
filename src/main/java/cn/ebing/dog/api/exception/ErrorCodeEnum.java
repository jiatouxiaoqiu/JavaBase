package cn.ebing.dog.api.exception;

/**
 * 1012 最特殊，因为前端根据这个判断登录态并重新登录，不存在和过期都是需要重新登录的
 */
public enum ErrorCodeEnum {
    SERVICE_ERROR("999", "系统错误，联系小邱"),
    EXCEL_LINE_TOO_LESS("1000", "价格文件excel行数太少，无需录入"),
    IMPORT_FILE_NO_FOUND("1001", "文件记录不存在"),
    EXCEL_READ_ERROR("1002", "excel读取异常"),
    GOOD_ID_INDEX_PARSE("1003", "货号转换index数字出错啦"),
    EXCEL_SAVE_NO_FOUND("1004", "上传的excel保存到服务器本地失败了"),
    IMPORT_JD_FILE_NO_FOUND("1005", "京东后台的文件不存在，需要放文件在 /jd_good/里面，文件名是 deleteJdStoreGoodAndInsertExcelJdGood.xlsx"),
    IMPORT_JD_FILE_NUM_TOO_LESS("1006", "京东后台的文件数量太少，不需要这样录入，会有问题"),
    IMPORT_MATCH_PRICE_NO_FOUND("1007", "上传匹配价格的文件不存在，需要放文件在 /jd_good/里面，文件名是 matchPrice.xlsx"),
    DOWN_LOAD_FILE_PATH_ERROR("1008", "下载路径不正确"),


    WISH_STATUS_NOT_MATCH("1059", "许愿池未开放 ~");

    private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *重写toString方法在控制台显示自定义异常信息
     * @return
     */
    @Override
    public String toString() {
        return "[ 异常码(code):"+ this.code +" 异常信息(message):"+ this.message+" ]";
    }
}
