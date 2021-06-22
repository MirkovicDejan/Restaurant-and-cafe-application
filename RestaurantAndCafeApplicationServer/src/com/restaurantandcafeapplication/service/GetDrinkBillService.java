package com.restaurantandcafeapplication.service;

import java.sql.SQLException;

import com.restaurantandcafeapplication.broker.Broker;
import com.restaurantandcafeapplication.domainclass.Bill;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class GetDrinkBillService extends GeneralSystemOperation{

	@Override
	public void processSpecificSystemOperation(TransferClass object) throws SQLException {
		// TODO Auto-generated method stub

		Broker broker = new Broker();
	    object.setResponse(broker.getDrinkforBill());
		
		
	}


		
		
		
	

}
