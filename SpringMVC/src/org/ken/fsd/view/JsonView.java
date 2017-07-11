package org.ken.fsd.view;

import java.util.HashMap;
import java.util.Map;


public class JsonView {
	private String resultCode = "0";
	private String resultDecription = "OK";
	private Map<String,Object> result;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDecription() {
		return resultDecription;
	}
	public void setResultDecription(String resultDecription) {
		this.resultDecription = resultDecription;
	}
	public Map<String, Object> getResult() {
		result =(result==null) ? new HashMap<String,Object>():result;
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	
	public String toString(){
		return "resultCode:"+resultCode+",resultDecription:"+resultDecription;
	}
}
