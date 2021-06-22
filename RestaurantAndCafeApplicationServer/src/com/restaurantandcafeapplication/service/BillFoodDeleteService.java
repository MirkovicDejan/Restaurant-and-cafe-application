package com.restaurantandcafeapplication.service;

import java.sql.SQLException;

import com.restaurantandcafeapplication.broker.Broker;
import com.restaurantandcafeapplication.domainclass.Bill;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class BillFoodDeleteService extends GeneralSystemOperation {

	@Override
	public void processSpecificSystemOperation(TransferClass object) throws SQLException {
		// TODO Auto-generated method stub
		
		switch(object.getOperation()) {
		
		case DELETE_FOOD_FROM_BILLS : 
			deleteFoodFromBills(object);
			break;
			
		default:
			break;
		
		}
		
	}

	private void deleteFoodFromBills(TransferClass object) {
		// TODO Auto-generated method stub
	   Bill deleteFood = (Bill) object.getRequest();
	   Broker deleteFoodBill = new Broker();
	   deleteFoodBill.deleteFoodBill(deleteFood);
		
	}

}
