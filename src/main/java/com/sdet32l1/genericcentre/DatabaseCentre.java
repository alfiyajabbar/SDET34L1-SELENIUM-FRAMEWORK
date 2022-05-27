package com.sdet32l1.genericcentre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

public class DatabaseCentre {
	static Connection connection;
	static Statement statement;
	/**
	 * This method is used to open database connection and initialize the connection statement
	 * @param dBUrl
	 * @param dBUserName
	 * @param dBPassword
	 * @throws SQLException
	 */
	public static void openDBConnection(String dbUrl,String dbUserName,String dbPassword) 
	{
		Driver d = null;
		try {
			d = new Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
/**
 * This method is used to fetch the data from database/to do the DQL actions on database
 * @param query
 * @param columnName
 * @return
 * @throws SQLException
  */
 public static ArrayList<String> getDataFromDataBase(String query,String columnName)
  {
	 ArrayList<String>list=new ArrayList<>();
	 ResultSet result = null;
	try {
		result = statement.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 try {
		while(result.next()) {
			 list.add(result.getString(columnName));
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return list;
  }
	 /**
	  * This method is used to validate the data whether it is present in database or not
	  * @param query
	  * @param columnName
	  * @param expectedData
	  * @return
	  */
	 

public static boolean validateDataInDatabase(String query, String columnName, String expectedData)
{
	ArrayList<String> list= getDataFromDataBase(query,columnName);
			boolean flag=false;
	for(String actualData:list)
	{
		if(actualData.equalsIgnoreCase(expectedData))
		{
			flag=true;
			break;
		}
	}
	return flag;
}
/**
 * This method is used to store/modify/insert/delete the data in database/to do DML and DDL actions on database
 * @param query
 */

public static void setDataInDataBase(String query)
{
	int result = 0;
	try {
		result = statement.executeUpdate(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(result>=1)
	{
		System.out.println("Data entered/modified successfully");
	}
}

public static void closeDBConnection()
{
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
 
 
 
