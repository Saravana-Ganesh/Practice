package com.practice.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import com.practice.constants.DBConstants;
/*
 * author Saravana Ganesh
 * created on 11-June-2021
 */
public class DBUtils {
	private  static Connection connection = null;
	private static  DBUtils db = null;
	private DBUtils(){			
		try{  			
			//load the driver class  
			Class.forName(DBConstants.DRIVER_NAME);  
			//create  the connection object  
			connection = DriverManager.getConnection(DBConstants.URL,DBConstants.USERNAME,DBConstants.PASSWORD);
		}
		catch(Exception e){
			e.printStackTrace();
		}		 
	}  
	public static Connection getDbConnection() {
		if(db==null) {
			new DBUtils();
		}
		return connection;
	}
} 