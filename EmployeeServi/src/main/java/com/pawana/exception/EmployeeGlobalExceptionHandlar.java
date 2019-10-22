package com.pawana.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pawana.bean.Employee;
import com.pawana.helper.EmployeeNotFoundException;
import com.pawana.util.APIResponse;
import com.pawana.util.ErrorInfo;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandlar {
	

	@ExceptionHandler(EmployeeNotFoundException.class)
	public APIResponse<Employee> handleUserNotFoundException(EmployeeNotFoundException ex){
		APIResponse<Employee> apiresponse=new APIResponse();
		ErrorInfo errorinfo=new ErrorInfo();
		errorinfo.setErrorCode(ex.getMessage());
		errorinfo.setErrorMessage(ex.getMessage());
		apiresponse.getErrorInfo().add(errorinfo);
		return apiresponse;
		
	}
	@ExceptionHandler(Exception.class)
     public APIResponse<Employee> handleException(Exception ex)
     {
		APIResponse<Employee> apiresponse=new APIResponse();
		ErrorInfo errorinfo=new ErrorInfo();
		errorinfo.setErrorCode("222");
		errorinfo.setErrorMessage(ex.getMessage());
		apiresponse.getErrorInfo().add(errorinfo);
		return apiresponse;
		
     }
}
