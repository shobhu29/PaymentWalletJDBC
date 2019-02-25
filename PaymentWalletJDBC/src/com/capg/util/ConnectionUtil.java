package com.capg.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	
public static Connection getConnection()
	{
				
	try
	{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Capgemini123");
	return  conn;
	}
	catch(Exception e)
	{
		System.out.println(" Connection not established ");
	}
	
return null;

	}
}
