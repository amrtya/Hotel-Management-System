package com.springboot.models;

public class ResponseModel {
	
	public static final String SUCCESS = "SUCCESS", FAILURE = "FAILURE"; 
	
	private String responseType;
	private String resposneMessage;
	
	public ResponseModel(String responseType) {
		this.responseType = responseType;
		this.resposneMessage = "";
	}
	
	public ResponseModel(String responseType, String resposneMessage) {
		this.responseType = responseType;
		this.resposneMessage = resposneMessage;
	}
	
	public String getResponseType() {
		return responseType;
	}
	
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	
	public String getResposneMessage() {
		return resposneMessage;
	}
	
	public void setResposneMessage(String resposneMessage) {
		this.resposneMessage = resposneMessage;
	}
	
}
