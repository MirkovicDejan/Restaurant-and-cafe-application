package com.restaurantandcafeapplication.domainclass;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Employees implements Serializable , General{
	
	private int idEmployees;
	private String nameAndSurname;
	private String password;
	private int workRole;
	
	public Employees() {

		
	}

	


	public int getIdEmployees() {
		return idEmployees;
	}




	public void setIdEmployees(int idEmployees) {
		this.idEmployees = idEmployees;
	}




	public String getNameAndSurname() {
		return nameAndSurname;
	}




	public void setNameAndSurname(String nameAndSurname) {
		this.nameAndSurname = nameAndSurname;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getWorkRole() {
		return workRole;
	}




	public void setWorkRole(int workRole) {
		this.workRole = workRole;
	}




	@Override
	public String returnTheTableName() {
		// TODO Auto-generated method stub
		return "employees";
	}

	@Override
	public String returnColumnNames() {
		// TODO Auto-generated method stub
		return "(Name_and_surname, Password, Work_role)";
	}

	@Override
	public PreparedStatement returnInsert(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1,nameAndSurname);
			preparedStatement.setString(2,password);
			preparedStatement.setInt(3,2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}

	@Override
	public String returnCharacters() {
		// TODO Auto-generated method stub
		return "(?,?,?)";
	}

	@Override
	public List<General> selectAll(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnColumnForUpdate() {
		// TODO Auto-generated method stub
		return " Name_and_surname = ? , Password = ? ";
	}

	@Override
	public String returnId() {
		// TODO Auto-generated method stub
		return "Id_employees";
	}

	@Override
	public PreparedStatement returnUpdate(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		try {
			preparedStatement.setString(1, nameAndSurname);
			preparedStatement.setString(2, password);
			preparedStatement.setInt(3, idEmployees);
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
			preparedStatement.setInt(1, idEmployees);
			//preparedStatement.setDouble(2, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	
}
	
	
	
	

}
