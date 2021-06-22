package com.restaurantandcafeapplication.transfer;

import java.io.Serializable;

import com.restaurantandcafeapplication.domainclass.ConstantsControllerBusinessLogic;
import com.restaurantandcafeapplication.domainclass.ConstantsUserInterfaceController;

public class TransferClass implements Serializable {
	
	private ConstantsControllerBusinessLogic operation;
	private Object request;
	private Object response;
	private String message;
	private ConstantsUserInterfaceController directionOnTheTable;
	
	public ConstantsControllerBusinessLogic getOperation() {
		return operation;
	}
	public void setOperation(ConstantsControllerBusinessLogic operation) {
		this.operation = operation;
	}
	public Object getRequest() {
		return request;
	}
	public void setRequest(Object request) {
		this.request = request;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ConstantsUserInterfaceController getDirectionOnTheTable() {
		return directionOnTheTable;
	}
	public void setDirectionOnTheTable(ConstantsUserInterfaceController directionOnTheTable) {
		this.directionOnTheTable = directionOnTheTable;
	}
	
	public static TransferClass createOperation(Object request,ConstantsControllerBusinessLogic operation,ConstantsUserInterfaceController directionOnTheTable) {
		
	TransferClass transferClass = new TransferClass();
	transferClass.request = request;
	transferClass.operation = operation;
	transferClass.directionOnTheTable = directionOnTheTable;
	
	return transferClass;
		
	}
	
	
	
	
	

}
