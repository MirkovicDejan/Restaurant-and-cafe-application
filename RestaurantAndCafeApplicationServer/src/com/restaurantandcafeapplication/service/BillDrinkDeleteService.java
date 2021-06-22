package com.restaurantandcafeapplication.service;

import java.sql.SQLException;

import com.restaurantandcafeapplication.broker.Broker;
import com.restaurantandcafeapplication.domainclass.Bill;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class BillDrinkDeleteService extends GeneralSystemOperation {

	@Override
	public void processSpecificSystemOperation(TransferClass object) throws SQLException {
		// TODO Auto-generated method stub
		switch(object.getOperation()) {
		
		case DELETE_DRINK_FROM_BILLS:
			deleteDrinkDromBills(object);
			break;
		
		default :
			break;
		}
		
	}

	private void deleteDrinkDromBills(TransferClass object) {
		// TODO Auto-generated method stub
		Bill deleteDrink = (Bill) object.getRequest();
		Broker deleteDrinkBills = new Broker();
		deleteDrinkBills.deleteDrinkBills(deleteDrink);
		
	}

}
