package com.restaurantandcafeapplication.systemoperations;

import com.restaurantandcafeapplication.connection.ConnectionToTheBase;
import com.restaurantandcafeapplication.transfer.TransferClass;

public abstract class GeneralSystemOperation {
	
	public void executeSystemOperation(TransferClass object) {
		
		try {
			startTransaction();
			processSpecificSystemOperation(object);
			confrimTransaction();
			} catch (Exception e) {
			
			cancleTransaction();
			object.setMessage(e.getMessage());
			
		
		} finally {
			
			closeTransaction();
		}
			
		}
	
	
	public void startTransaction() {
		ConnectionToTheBase.getInstance().runConnection();
	}
	public void confrimTransaction() {
		ConnectionToTheBase.getInstance().confrimConnection();
	}
	public void cancleTransaction() {
		ConnectionToTheBase.getInstance().cancelConnection();
	}
	public void closeTransaction() {
		ConnectionToTheBase.getInstance().closeConnection();
	}
	
	public abstract void processSpecificSystemOperation(TransferClass object) throws  java.sql.SQLException;
		
	

}
