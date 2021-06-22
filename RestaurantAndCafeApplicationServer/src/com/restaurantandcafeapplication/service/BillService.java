package com.restaurantandcafeapplication.service;

import java.sql.SQLException;
import java.util.List;

import com.restaurantandcafeapplication.broker.Broker;
import com.restaurantandcafeapplication.domainclass.Bill;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class BillService extends GeneralSystemOperation {

	@Override
	public void processSpecificSystemOperation(TransferClass object) throws SQLException {
		// TODO Auto-generated method stub
		switch(object.getOperation()) {
		
		case DELETE:
		deleteBill(object);
		break;
		
		case POST_DRINK_BILL:
		insertBill(object);
		break;
		default : 
	    	break;
		
		}
		
	}

	private void insertBill(TransferClass object) {
		// TODO Auto-generated method stub
	    Bill billDrink = (Bill) object.getRequest();
		Broker broker = new Broker();
		broker.insertBillDrink(billDrink);
	}



	private void deleteBill(TransferClass object) {
		// TODO Auto-generated method stub
		Bill deleteBill = (Bill) object.getRequest();
		Broker broker = new Broker();
		broker.delete(deleteBill);
	
		
		
	}

}
