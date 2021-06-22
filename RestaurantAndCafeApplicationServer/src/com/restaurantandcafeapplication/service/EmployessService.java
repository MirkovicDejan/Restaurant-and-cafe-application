package com.restaurantandcafeapplication.service;

import java.sql.SQLException;

import com.restaurantandcafeapplication.broker.Broker;
import com.restaurantandcafeapplication.domainclass.Employees;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class EmployessService extends GeneralSystemOperation{

	@Override
	public void processSpecificSystemOperation(TransferClass object) throws SQLException {
		
		switch (object.getOperation()) {
		case POST: 
			insertEmployees(object);
			
		break;
		
		case GET_EMPLOYEES : 
			getEmployees(object);
			
		break;
		
		case UPDATE :
			updateEmployees(object);
			break;
			
		case DELETE:
			deleteEmployees(object);
			break;
		
		
		default:
		break;
		
		}
	}
	
	private void deleteEmployees(TransferClass object) {
		// TODO Auto-generated method stub
		Employees deleteEmployees = (Employees) object.getRequest();
		Broker broker = new Broker();
		broker.delete(deleteEmployees);
	}

	private void updateEmployees(TransferClass object) {
	Employees employeesUpdate = (Employees) object.getRequest();
	Broker broker = new Broker();
	broker.update(employeesUpdate);
		
	}

	private void insertEmployees(TransferClass object) {
		Employees employesInsert =  (Employees) object.getRequest();
		Broker broker = new Broker();
		broker.save(employesInsert);
		
}
	private void getEmployees(TransferClass object) {
		
		Employees employeesGet = (Employees) object.getRequest();
		Broker broker = new Broker();
		Employees response = broker.getEmployees(employeesGet);
		object.setResponse(response);
		
		
	}

}
