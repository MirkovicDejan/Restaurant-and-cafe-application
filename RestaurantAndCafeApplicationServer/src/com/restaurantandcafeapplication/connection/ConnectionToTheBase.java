package com.restaurantandcafeapplication.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToTheBase {
	
	private volatile static ConnectionToTheBase connectionToTheBase;
	private Connection connection;
	private static Object mutex = new Object();
	
	
	
	
	public static ConnectionToTheBase getConnectionToTheBase() {
		return connectionToTheBase;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	
	private ConnectionToTheBase() {
		
	}
	
	public static ConnectionToTheBase getInstance() {
		if(connectionToTheBase == null) {
			synchronized (mutex) {
				if(connectionToTheBase == null) {
					connectionToTheBase = new ConnectionToTheBase();
				}
			}
		}
		 return connectionToTheBase;
	}
	
	public void runConnection() {

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_system", "root", "");
			connection.setAutoCommit(false);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void confrimConnection() {

		try {
			connection.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancelConnection() {

		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


