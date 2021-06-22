package com.restaurantandcafeapplication.service;

import java.sql.SQLException;

import com.restaurantandcafeapplication.broker.Broker;
import com.restaurantandcafeapplication.domainclass.Food;
import com.restaurantandcafeapplication.domainclass.General;
import com.restaurantandcafeapplication.systemoperations.GeneralSystemOperation;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class FoodService extends GeneralSystemOperation{

	@Override
	public void processSpecificSystemOperation(TransferClass object) throws SQLException {
		// TODO Auto-generated method stub
		switch(object.getOperation()) {
		case POST : 
			insertFood(object);
			break;
		case DELETE: 
			delete(object);
			break;
		case UPDATE :
			update(object);
			break;
		
		
		default :
			break;
		}
	}
	
  private void insertFood(TransferClass object) {
	  Food foodInsert = (Food) object.getRequest();
	  Broker broker = new Broker();
	  broker.save(foodInsert);
	  
  }
  
  private void delete(TransferClass object) {
	  Food deleteFood = (Food) object.getRequest();
	  Broker broker = new Broker();
	  broker.delete(deleteFood);
	  
  }
  
  private void update(TransferClass object) {
	  Food updateFood = (Food) object.getRequest();
	  Broker broker = new Broker();
	  broker.update(updateFood);
	
}
  
 
  }


