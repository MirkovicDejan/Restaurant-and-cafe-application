package com.restaurantandcafeapplication.communication;
// IN THIS CLASS WE ARE COMING FROM UserInterfaceController
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;



import com.restaurantandcafeapplication.domainclass.ConnectionConstants;
import com.restaurantandcafeapplication.transfer.TransferClass;


public class Communication {
	
	private static Communication instance;
	private Socket socket;
	
	private Communication(){
		
		try {
			socket = new Socket(ConnectionConstants.ADRESS.getAdress(),ConnectionConstants.PORT.getPort());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Communication getCommunication() {
		if(instance == null) {
			instance =new Communication();
		}
		return  instance;
	}
	
	public void send (TransferClass transferClass ) {
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(transferClass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TransferClass read() throws IOException, ClassNotFoundException {
		
		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
		return (TransferClass) objectInputStream.readObject();
		
	}

}
