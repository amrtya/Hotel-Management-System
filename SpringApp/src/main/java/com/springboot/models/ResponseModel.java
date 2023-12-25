package com.springboot.models;

public class ResponseModel {
	
	public static final String SUCCESS = "SUCCESS", FAILURE = "FAILURE"; 
	
	private String responseType;
	private String responseMessage;
	
	public ResponseModel(String responseType) {
		this.responseType = responseType;
		this.responseMessage = "";
	}
	
	public ResponseModel(String responseType, String responseMessage) {
		this.responseType = responseType;
		this.responseMessage = responseMessage;
	}
	
	public String getResponseType() {
		return responseType;
	}
	
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
