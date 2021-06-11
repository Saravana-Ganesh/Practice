package com.practice.constants;

import com.practice.config.DBPropertiesConfig;
/*
 * author Saravana Ganesh
 * created on 11-June-2021
 */
public final class DBConstants {
	static {
		System.out.println(DBPropertiesConfig.getProperties().getProperty("url"));
	}
	public static final String URL = DBPropertiesConfig.getProperties().getProperty("url").trim();   
	public static final String DRIVER_NAME = DBPropertiesConfig.getProperties().getProperty("driverName").trim(); 
	public static final String USERNAME = DBPropertiesConfig.getProperties().getProperty("userName").trim();
	public static final String PASSWORD = DBPropertiesConfig.getProperties().getProperty("password").trim();
}
