package com.springboot.models;

import java.util.List;

public class ResponseModelListPayload<T> extends ResponseModel {
	
	private List<T> result;
	
	public ResponseModelListPayload(String responseType, List<T> result) {
		super(responseType);
		this.result = result;
	}
	
	public ResponseModelListPayload(String responseType, String message, List<T> result) {
		super(responseType, message);
		this.result = result;
	}
	
	public List<T> getResult() {
		return result;
	}
	
	public void setResult(List<T> result) {
		this.result = result;
	}
}
