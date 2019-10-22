package com.pawana.helper;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawana.bean.Employee;
import com.pawana.service.EmployeeService;
import com.pawana.util.APIResponse;
import com.pawana.util.ErrorInfo;
import com.pawana.util.Status;



@Service
public class EmployeeHelper {
	
		@Autowired
		private EmployeeService service;
		
		public APIResponse<Employee> getEmployee(Integer id) {
			APIResponse<Employee> apiresponse = new APIResponse<>();
			Employee employee=service.getEmployee(id);
			if(employee==null)
			{
				throw new EmployeeNotFoundException("employee id "+id+" not found");
			}
			apiresponse.setPayload(employee);
			apiresponse.setStatus(new Status());
			return apiresponse;
		

}
		//@SuppressWarnings("unchecked")
		public APIResponse<Employee> insertEmployee(Employee employee) throws SQLException
		{
			APIResponse<Employee> apiresponse=new APIResponse<Employee>();
			Employee newEmployee=service.insertEmployee(employee);
		if(employee.getId().length()<3) {
			setErrorInfo(apiresponse,"1000","invalid id");
		}
		if(employee.getName().length()<3)
		{
			setErrorInfo(apiresponse,"1001","invalid name");
		}
		if(!apiresponse.getErrorInfo().isEmpty())
			return apiresponse;
				
		
		  if(newEmployee==null) {
			  throw new EmployeeNotFoundException("employee creation failed");
		  }
			  apiresponse.setPayload(employee);
			  apiresponse.setStatus(new Status());
		  return apiresponse;
		}
		
			
			
			
		
		
			
		private void setErrorInfo(APIResponse<Employee> apiresponse, String errorcode, String errormessage) {
			
				ErrorInfo errorinfo=new ErrorInfo();
				errorinfo.setErrorCode(errorcode);
				errorinfo.setErrorMessage(errormessage);
				
				apiresponse.getStatus().setStatusCode("error");
				apiresponse.getErrorInfo().add(errorinfo);
			
		







		}
		public APIResponse<Employee> updateEmployee(Employee employee) throws SQLException
		{
			APIResponse<Employee> apiresponse=new APIResponse<Employee>();
			Employee employee1=service.updateEmployee(employee);
			if(employee1==null)
			{
				throw new EmployeeNotFoundException("employee updation failed");
			}
			apiresponse.setPayload(employee1);
			apiresponse.setStatus(new Status());
			return apiresponse;
			
		}
		public APIResponse<Employee> deleteEmployee(Integer id) throws SQLException
		{
			APIResponse<Employee> apiresponse=new APIResponse<Employee>();
			String employee2=service.deleteEmployee(id);
			 if(employee2==null)
				 throw new EmployeeNotFoundException("555");
			 apiresponse.setPayload(null);
			 apiresponse.setStatus(new Status());
			return apiresponse;
		}
		 
			
		
			
		
}
