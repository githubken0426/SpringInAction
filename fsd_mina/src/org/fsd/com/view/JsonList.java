package org.fsd.com.view;

import java.util.List;

public class JsonList<T> {
	private List<T> result;
	private String err_code = "0";
	private String err_message = "OK";
	
	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String errCode) {
		err_code = errCode;
	}

	public String getErr_message() {
		return err_message;
	}

	public void setErr_message(String errMessage) {
		err_message = errMessage;
	}
}
