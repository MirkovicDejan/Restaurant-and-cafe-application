package com.restaurantandcafeapplication.domainclass;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Bill implements Serializable,General{
	
	private int id;
	private String food;
	private String drink;
	private String employyes;
	private int idE;
	private int idF;
	private int idD;
	private String name;
	private String serialNumber;
	private double price;
	private double total;
	
	
    
	
	
	public Bill() {
		
		
	}
	
	
	
	
	
	






	


	public String getName() {
		return name;
	}















	public void setName(String name) {
		this.name = name;
	}















	public double getTotal() {
		return total;
	}















	public void setTotal(double total) {
		this.total = total;
	}















	public int getIdF() {
		return idF;
	}















	public void setIdF(int idF) {
		this.idF = idF;
	}















	public int getIdD() {
		return idD;
	}















	public void setIdD(int idD) {
		this.idD = idD;
	}















	public int getIdE() {
		return idE;
	}















	public void setIdE(int idE) {
		this.idE = idE;
	}















	public String getSerialNumber() {
		return serialNumber;
	}













	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}













	public String getFood() {
		return food;
	}










	public void setFood(String food) {
		this.food = food;
	}










	public String getDrink() {
		return drink;
	}










	public void setDrink(String drink) {
		this.drink = drink;
	}










	public String getEmployyes() {
		return employyes;
	}










	public void setEmployyes(String employyes) {
		this.employyes = employyes;
	}










	public int getId() {
		return id;
	}






	

	public void setId(int id) {
		this.id = id;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String returnTheTableName() {
		// TODO Auto-generated method stub
		return "bills";
	}

	@Override
	public String returnColumnNames() {
		// TODO Auto-generated method stub
		return "(Id_food, Id_drink, Id_employees, Price)";
	}

	@Override
	public PreparedStatement returnInsert(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1,food);
			preparedStatement.setString(2, drink);
			preparedStatement.setString(3,employyes);
			preparedStatement.setDouble(4, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	public String returnCharacters() {
		// TODO Auto-generated method stub
		return "(?,?,?,?)";
	}

	@Override
	public List<General> selectAll(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnColumnForUpdate() {
		// TODO Auto-generated method stub
		return "Id_food = ?, Id_drink = ?, Id_employees = ?, Price = ?";
	}

	@Override
	public String returnId() {
		// TODO Auto-generated method stub
		return "Id_bills";
	}

	@Override
	public PreparedStatement returnUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1,food);
			preparedStatement.setString(2, drink);
			preparedStatement.setString(3,employyes);
			preparedStatement.setDouble(4, price);
			preparedStatement.setInt(5, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return preparedStatement;
	}

	@Override
	public PreparedStatement returnDelete(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setInt(1, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}

}
