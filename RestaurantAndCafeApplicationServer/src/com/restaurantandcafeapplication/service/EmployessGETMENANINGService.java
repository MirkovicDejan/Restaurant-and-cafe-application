package com.restaurantandcafeapplication.service;

import java.sql.SQLException;

import com.restaurantandcafeapplication.broker.Broker;
import com.restaurantandcafeapplication.domainclass.Employees;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class EmployessGETMENANINGService extends GeneralSystemOperation{

	@Override
	public void processSpecificSystemOperation(TransferClass object) throws SQLException {
	
		Broker broker = new Broker();
		object.setResponse(broker.getEMPMenaning());
	     
		
	}
	

	    
	}
	
	


