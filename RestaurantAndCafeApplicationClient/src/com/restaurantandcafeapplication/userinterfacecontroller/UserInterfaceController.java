package com.restaurantandcafeapplication.userinterfacecontroller;

import java.io.IOException;

import com.restaurantandcafeapplication.communication.Communication;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class UserInterfaceController {
	
	private static UserInterfaceController userInterfaceController;
	
	private UserInterfaceController() {
		
		
	}
	
	public static UserInterfaceController getUserInterfaceController() {
		if(userInterfaceController == null) {
			userInterfaceController = new UserInterfaceController();
		}
		return userInterfaceController;
	}
	
	public TransferClass execute(TransferClass transferClass) throws ClassNotFoundException, IOException {
		Communication.getCommunication().send(transferClass);
		return Communication.getCommunication().read();
		
	}

}
