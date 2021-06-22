package com.restaurantandcafeapplication.domainclass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;



public interface General {
	
	String returnTheTableName();
	String returnColumnNames();
	PreparedStatement returnInsert(PreparedStatement preparedStatement);
    String returnCharacters();
	List<General> selectAll(ResultSet resultSet);
	String returnColumnForUpdate();
	String returnId();
	PreparedStatement returnUpdate(PreparedStatement preparedStatement);
	PreparedStatement returnDelete(PreparedStatement preparedStatement);
    
	 
	 
	
	

}
