package com.pawana.util;



import java.util.ArrayList;
import java.util.List;


public class APIResponse<T> {
private Status status;
private T payload;
private List errorInfo=new ArrayList();
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public T getPayload() {
	return payload;
}
public void setPayload(T payload) {
	this.payload = payload;
}
public List getErrorInfo() {
	return errorInfo;
}
public void setErrorInfo(List errorInfo) {
	this.errorInfo = errorInfo;
}


}
