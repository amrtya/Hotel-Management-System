package com.springboot.models;

public class ResponseModelSinglePayload<T> extends ResponseModel {
	
	private T result;
	
	public ResponseModelSinglePayload(String responseType, T result) {
		super(responseType);
		this.result = result;
	}
	
	public ResponseModelSinglePayload(String responseType, String message, T result) {
		super(responseType, message);
		this.result = result;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	} 
}
