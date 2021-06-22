package com.restaurantandcafeapplication.service;

import java.sql.SQLException;

import com.restaurantandcafeapplication.broker.Broker;
import com.restaurantandcafeapplication.domainclass.Drink;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class DrinkService extends GeneralSystemOperation {

	@Override
	public void processSpecificSystemOperation(TransferClass object) throws SQLException {
		// TODO Auto-generated method stub
		switch(object.getOperation()) {
		
		case POST:
			insertDrink(object);
	       break;
		case UPDATE :
			updateDrink(object);
			break;
		case DELETE:
			deleteDrink(object);
			break;
	    
		default:
			break;
		
		}
		
	}

	private void deleteDrink(TransferClass object) {
		// TODO Auto-generated method stub
		Drink deleteDrink = (Drink) object.getRequest();
		Broker broker = new Broker();
		broker.delete(deleteDrink);
		
	}

	private void updateDrink(TransferClass object) {
		// TODO Auto-generated method stub
		Drink updateDrink = (Drink) object.getRequest();
		Broker broker = new Broker();
		broker.update(updateDrink);
	}

	private void insertDrink(TransferClass object) {
		Drink insertDrink = (Drink) object.getRequest();
		Broker broker = new Broker();
		broker.save(insertDrink);
	}

}
