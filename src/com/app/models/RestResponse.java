package com.app.models;

public class RestResponse<T> {
	private int status;
	private String message;
	private T data;
	public RestResponse(int status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public RestResponse() {
		super();
		this.status = -999;
		this.message = "Failed";
		this.data = null;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
}
