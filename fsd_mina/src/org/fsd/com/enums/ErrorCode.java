package org.fsd.com.enums;

import java.text.MessageFormat;

import org.fsd.com.exception.ApiException;


public enum ErrorCode {
	// =======系统错误=======
	SYS_ERR_CODE(-1, "程序异常", "系统繁忙,请稍后再试..."), 
	
	// =======API签名认证=======
	API_TIME_EXPIRED(13000, "请求过期", "系统繁忙,请稍后再试..."), 
	API_VALIDATE_EXPIRED(13001, "账号过期", "系统繁忙,请稍后再试..."),
	API_PARTENER_KEY(13002, "不合法的partenerkey", "系统繁忙,请稍后再试..."),
	API_API_ID(13003, "不合法的apiid", "系统繁忙,请稍后再试..."), 
	API_SIGN_ERROR(13004, "不合法的secretkey", "系统繁忙,请稍后再试...");

	private final int code;
	private final String codeMessage;
	private String message;

	public int getCode() {
		return code;
	}

	public String getCodeMessage() {
		return codeMessage;
	}

	public String getMessage() {
		return message;
	}

	public ErrorCode setTemplateMsg(String... args) {
		message = MessageFormat.format(getMessage(), args);
		return this;
	}

	private ErrorCode(int code, String codeMessage, String message) {
		this.code = code;
		this.codeMessage = codeMessage;
		this.message = message;
	}

	public static void main(String[] args) throws ApiException {
		System.out.println(ErrorCode.SYS_ERR_CODE.setTemplateMsg("中国人", "北京",
				"22").toJsonString());
	}

	public String toJsonString() {
		return "{\"err_code\":\"" + code + "\",\"err_message\":\""
				+ codeMessage + "\",\"message\":\"" + message + "\"}";
	}

}