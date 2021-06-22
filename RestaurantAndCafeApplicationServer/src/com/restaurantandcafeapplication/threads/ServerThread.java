package com.restaurantandcafeapplication.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.restaurantandcafeapplication.domainclass.ConnectionConstants;

public class ServerThread extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		startServer();
	}
	
	public void startServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(ConnectionConstants.PORT.getPort());
			while(true) {
				Socket socket = serverSocket.accept();
				ClientThread clientThread = new ClientThread(socket);
				clientThread.start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
