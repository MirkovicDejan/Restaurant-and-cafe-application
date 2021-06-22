package com.restaurantandcafeapplication.broker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.restaurantandcafeapplication.connection.ConnectionToTheBase;
import com.restaurantandcafeapplication.domainclass.Bill;
import com.restaurantandcafeapplication.domainclass.Drink;
import com.restaurantandcafeapplication.domainclass.Employees;
import com.restaurantandcafeapplication.domainclass.Food;
import com.restaurantandcafeapplication.domainclass.General;

public class Broker {
	
public void save(General general) {
	
String sql ="insert into "+general.returnTheTableName()+general.returnColumnNames()+" values "+general.returnCharacters();
	
try {
	PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
	preparedStatement = general.returnInsert(preparedStatement);
	preparedStatement.execute();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	
		
}

public Employees getEmployees(Employees getEmployees) {
	
String sql ="SELECT Id_employees, Name_and_surname, Password, Work_role FROM employees WHERE Name_and_surname = ? AND Password = ?";

try {
	PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
	preparedStatement.setString(1, getEmployees.getNameAndSurname());
	preparedStatement.setString(2, getEmployees.getPassword());
	ResultSet resultSet = preparedStatement.executeQuery();
	
	while(resultSet.next()) {
		getEmployees.setIdEmployees(resultSet.getInt("Id_employees"));
		getEmployees.setNameAndSurname(resultSet.getString("Name_and_surname"));
		getEmployees.setPassword(resultSet.getString("Password"));
		getEmployees.setWorkRole(resultSet.getInt("Work_role"));
		
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
	return getEmployees;
	
}

public List<Food> getFood() {
	// TODO Auto-generated method stub
	String sql ="select * from food";
	List<Food>list = new ArrayList<Food>();
	
	try {
		PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			Food food = new Food();
			food.setId(rs.getInt("Id_food"));
			food.setName(rs.getString("Name"));
			food.setPrice(rs.getDouble("Price"));
			list.add(food);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}

public void delete(General general) {
	
	String sql ="delete from "+general.returnTheTableName()+" where "+general.returnId()+" = ?";
	
	try {
		PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		preparedStatement = general.returnDelete(preparedStatement);
		preparedStatement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void update(General general) {
	
	String sql ="update "+general.returnTheTableName()+" SET "+general.returnColumnForUpdate()+" where "+general.returnId()+" = ?";
	
	try {
		PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		preparedStatement = general.returnUpdate(preparedStatement);
		preparedStatement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}

public List<Drink> getDrink() {
	// TODO Auto-generated method stub
	String sql = "select * from drink";
	
	List<Drink>listDrink = new ArrayList<>();
	
	try {
		PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			Drink drink = new Drink();
			drink.setId(rs.getInt("Id_drink"));
			drink.setName(rs.getString("Name_Drink"));
			drink.setPrice(rs.getDouble("Price"));
			
			listDrink.add(drink);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return listDrink;
}

public List<Employees>getEMPMenaning() {
	// TODO Auto-generated method stub
	String sql = "SELECT Id_employees, Name_and_surname, Password, Work_role FROM employees ";
	
	List<Employees>list = new ArrayList<Employees>();
	
	try {
		PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			Employees getEMPMenaning = new Employees();
			getEMPMenaning.setIdEmployees(resultSet.getInt("Id_employees"));
		    getEMPMenaning.setNameAndSurname(resultSet.getString("Name_and_surname"));
		    getEMPMenaning.setPassword(resultSet.getString("Password"));
		    getEMPMenaning.setWorkRole(resultSet.getInt("Work_role"));
		    
			list.add(getEMPMenaning);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;


	
}

public List<Bill> getBill() {
	// TODO Auto-generated method stub
	String sql ="SELECT * FROM bills JOIN employees e on bills.Id_employees = e.Id_employees JOIN food f on bills.Id_food = f.Id_food";
	List<Bill> list = new ArrayList<Bill>();
	try {
		PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			Bill getBill = new Bill();
			getBill.setId(resultSet.getInt("Id_bills"));
			getBill.setFood(resultSet.getString("Name"));
			getBill.setEmployyes(resultSet.getString("Name_and_surname"));
			getBill.setPrice(resultSet.getDouble("Price"));
			getBill.setSerialNumber(resultSet.getString("Serial_Number_Bill"));
			getBill.setTotal(resultSet.getDouble("TOTAL"));
			list.add(getBill);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}

public void insertBillFood(Bill billFood) {
	// TODO Auto-generated method stub
String sql = "INSERT INTO bills ( Id_food, Id_drink, Id_employees, Price, Serial_Number_Bill, TOTAL ) VALUES (?,?,?,?,?,?)";
   
try {
	PreparedStatement ps = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
	    
	
		ps.setInt(1, billFood.getIdF());
		ps.setString(2,null);
	    ps.setInt(3, billFood.getIdE());
		ps.setDouble(4, billFood.getPrice());
		ps.setString(5, billFood.getSerialNumber());
		ps.setDouble(6, billFood.getTotal());
		ps.execute();
		
	
	   
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
	
}

public void insertBillDrink(Bill billDrink) {
	// TODO Auto-generated method stub
	String sql = "INSERT INTO bills ( Id_food, Id_drink, Id_employees, Price, Serial_Number_Bill, TOTAL ) VALUES (?,?,?,?,?,?)";

	try {
		PreparedStatement ps = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
			ps.setString(1, null);
			ps.setInt(2, billDrink.getIdD());
		    ps.setInt(3, billDrink.getIdE());
			ps.setDouble(4, billDrink.getPrice());
			ps.setString(5, billDrink.getSerialNumber());
			ps.setDouble(6, billDrink.getTotal());
			ps.execute();
		  
		  
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
}
	
}

public void deleteDrinkBills(Bill deleteDrink) {
	// TODO Auto-generated method stub
	String sql ="DELETE FROM bills WHERE Id_drink = ?";
	
	try {
		PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, deleteDrink.getId());
		preparedStatement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public void deleteFoodBill(Bill deleteFood) {
	// TODO Auto-generated method stub
String sql ="DELETE FROM bills WHERE Id_food = ?";
	
	try {
		PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		preparedStatement.setInt(1, deleteFood.getId());
		preparedStatement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public List<Bill> getDrinkforBill() {
	// TODO Auto-generated method stub
	
	String sql = "SELECT * FROM bills join employees e on bills.Id_employees = e.Id_employees join drink d on bills.Id_drink = d.Id_drink";
	
	List<Bill>getDrinkForBill = new ArrayList<Bill>();
	
	try {
		PreparedStatement ps = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Bill drinkBill = new Bill();
			drinkBill.setId(rs.getInt("Id_bills"));
			drinkBill.setDrink(rs.getString("Name_Drink"));
			drinkBill.setEmployyes(rs.getString("Name_and_surname"));
			drinkBill.setPrice(rs.getDouble("Price"));
			drinkBill.setSerialNumber(rs.getString("Serial_Number_Bill"));
			drinkBill.setTotal(rs.getDouble("TOTAL"));
			
			getDrinkForBill.add(drinkBill);
			
			
		}
		
		
		
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return getDrinkForBill;
}






	
	
	
	
		
		
		


/*public void updateBill(Bill updateBill) {
	String sql ="UPDATE bills JOIN food f ON bills.Id_bills = f.Id_food JOIN drink d ON bills.Id_bills = d.Id_drink JOIN employees e \r\n"
			+ "ON bills.Id_bills = e.Id_employees "
			+ "SET f.Name = ?, d.Name_Drink = ?, e.Name_and_surname = ?, bills.Price = ? "
			+ "WHERE bills.Id_bills = ? AND f.Id_food = ? AND d.Id_drink = ? AND e.Id_employees = ? ";

	
	try {
		PreparedStatement preparedStatement = ConnectionToTheBase.getConnectionToTheBase().getConnection().prepareStatement(sql);
		preparedStatement.setString(1, updateBill.getFood());
		preparedStatement.setString(2, updateBill.getDrink());
		preparedStatement.setString(3, updateBill.getEmployyes());
		preparedStatement.setDouble(4, updateBill.getPrice());
		preparedStatement.setInt(5, updateBill.getId());
		preparedStatement.setInt(6, updateBill.getId());
		preparedStatement.setInt(7, updateBill.getId());
		preparedStatement.setInt(8, updateBill.getId());
		preparedStatement.execute();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	

}


