package com.restaurantandcafeapplication.service;

import java.sql.SQLException;
import java.util.List;

import com.restaurantandcafeapplication.broker.Broker;
import com.restaurantandcafeapplication.domainclass.Bill;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class BillFoodService extends GeneralSystemOperation {

	@Override
	public void processSpecificSystemOperation(TransferClass object) throws SQLException {
		// TODO Auto-generated method stub
		
		switch(object.getOperation()) {
		
		case POST_FOOD_BILL:
			insertFoodBill(object);
			break;
		
		
		default:
			break;
		}
		
	}

	private void insertFoodBill(TransferClass object) {
		// TODO Auto-generated method stub
		Bill billFood =  (Bill) object.getRequest();
		Broker br = new Broker();
		br.insertBillFood(billFood);
		
	}
	
	

}
