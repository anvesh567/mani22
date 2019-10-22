package com.pawana.util;

public class ErrorInfo {
	private String errorCode;
	private String errorMessage;
	private String detailsMessage;
	
	public String getDetailsMessage() {
		return detailsMessage;
	}
	public void setDetailsMessage(String detailsMessage) {
		this.detailsMessage = detailsMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
