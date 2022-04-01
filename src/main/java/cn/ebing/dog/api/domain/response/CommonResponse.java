package cn.ebing.dog.api.domain.response;

import io.swagger.annotations.ApiModelProperty;

public class CommonResponse<T> {

	@ApiModelProperty("code")
	private Integer code;

	@ApiModelProperty("消息体")
	private String message;

	@ApiModelProperty("返回体")
	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public CommonResponse(T data) {
		this.code = 0;
		this.message = "success";
		this.data = data;
	}

	public CommonResponse(String message) {
		this.code = 0;
		this.message = message;
	}

	public CommonResponse() {
	}

	public static CommonResponse getSuccessEmptyResponse() {
		return new CommonResponse<>("");
	}

	public static CommonResponse getSuccessResponse(String message) {
		return new CommonResponse<>(message);
	}
}
