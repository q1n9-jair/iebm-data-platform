package com.iebm.util;

public class CommonRetrunUtil {
	public   final static String  RETRUN_SUCCESS_MESSAGE="请求处理成功";
	public   final static int  RETRUN_SUCCESS_CODE=1;
	public   final static String  RETRUN_FAILURE_MESSAGE="请求处理失败";
	public   final static int  RETRUN_FAILURE_CODE=0;
	private  String commonReturnMessage;
	private int commonReturnCode;
	private  Object commonReturnObject;
	public String getCommonReturnMessage() {
		return commonReturnMessage;
	}
	public void setCommonReturnMessage(String commonReturnMessage) {
		this.commonReturnMessage = commonReturnMessage;
	}
	public int getCommonReturnCode() {
		return commonReturnCode;
	}
	public void setCommonReturnCode(int commonReturnCode) {
		this.commonReturnCode = commonReturnCode;
	}
	public Object getCommonReturnObject() {
		return commonReturnObject;
	}
	public void setCommonReturnObject(Object commonReturnObject) {
		this.commonReturnObject = commonReturnObject;
	}
	public static String getRetrunSuccessMessage() {
		return RETRUN_SUCCESS_MESSAGE;
	}
	public static int getRetrunSuccessCode() {
		return RETRUN_SUCCESS_CODE;
	}
	public static String getRetrunFailureMessage() {
		return RETRUN_FAILURE_MESSAGE;
	}
	public static int getRetrunFailureCode() {
		return RETRUN_FAILURE_CODE;
	}

}
