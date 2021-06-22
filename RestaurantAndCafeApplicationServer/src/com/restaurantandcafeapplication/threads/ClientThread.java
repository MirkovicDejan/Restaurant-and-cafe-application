package com.restaurantandcafeapplication.threads;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.restaurantandcafeapplication.controllerbusinesslogic.CommandBaseTransferObject;
import com.restaurantandcafeapplication.controllerbusinesslogic.ControllerBill;
import com.restaurantandcafeapplication.controllerbusinesslogic.ControllerDrink;
import com.restaurantandcafeapplication.controllerbusinesslogic.ControllerEmploye;
import com.restaurantandcafeapplication.controllerbusinesslogic.ControllerFood;
import com.restaurantandcafeapplication.transfer.TransferClass;

public class ClientThread extends Thread {
	
	private Socket socket;
	
	public ClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			try {
				ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
				TransferClass transferClass = null;
				try {
					 transferClass = (TransferClass) objectInputStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				processClientObject(transferClass);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
			  
		}
	}
	
	private void processClientObject (TransferClass transferClass) {
		CommandBaseTransferObject cb = null;
		
		switch(transferClass.getDirectionOnTheTable()) {
		
		case EMPLOYEES :
		    cb =  new ControllerEmploye();
			break;
		
		case FOOD:
			
			cb = new ControllerFood();
		  break;
		
		case DRINK:
			cb = new ControllerDrink();
			break;
		case BILLS:
			cb = new ControllerBill();
			
		default :
			break;
		}
		
		cb.execute(transferClass);
		sendToUserInterfaceController(transferClass);
	}
	
	public void sendToUserInterfaceController(TransferClass transferClass) {
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(transferClass);;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
}
