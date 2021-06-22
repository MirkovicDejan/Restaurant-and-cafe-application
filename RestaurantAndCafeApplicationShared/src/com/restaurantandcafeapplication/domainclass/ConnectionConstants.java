package com.restaurantandcafeapplication.domainclass;

public enum ConnectionConstants {
	ADRESS("127.0.0.1"),PORT(9000);
	
	private String adress;
	private int port;
	
	private ConnectionConstants(String adress) {
		this.adress = adress;
	}

	private ConnectionConstants(int port) {
		this.port = port;
	}

	public String getAdress() {
		return adress;
	}

	public int getPort() {
		return port;
	}
	
	
	
	
 
	
	
	
  
	
	

}
