package com.restaurantandcafeapplication.domainclass;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Food implements Serializable,General{

	private String name;
	private double price;
	private int id;
	
	
	public Food() {
		
	}
	
	
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
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
		return "food";
	}

	@Override
	public String returnColumnNames() {
		// TODO Auto-generated method stub
		return "(Name, Price)";
	}

	@Override
	public PreparedStatement returnInsert(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	public String returnCharacters() {
		// TODO Auto-generated method stub
		return "(?,?)";
	}

	@Override
	public List<General> selectAll(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnColumnForUpdate() {
		// TODO Auto-generated method stub
		return " Name = ?, Price = ? ";
	}

	@Override
	public String returnId() {
		// TODO Auto-generated method stub
		return "Id_food";
	}

	@Override
	public PreparedStatement returnUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1, name);
			preparedStatement.setDouble(2, price);
			preparedStatement.setInt(3, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	public PreparedStatement returnDelete(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setInt(1, id);
			//preparedStatement.setDouble(2, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}

}
