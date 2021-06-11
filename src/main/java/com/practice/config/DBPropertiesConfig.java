package com.practice.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
 * author Saravana Ganesh
 * created on 11-June-2021
 */
public final class DBPropertiesConfig {	
	private static final String RESOURCE_NAME = "resources//DBConnection.properties";	
	private static Properties properties = new Properties();
	private DBPropertiesConfig() {
		//For Singleton configuration
	}
	static {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();		
		try(InputStream resourceStream = loader.getResourceAsStream(DBPropertiesConfig.RESOURCE_NAME)) {
			properties.load(resourceStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Properties getProperties() {
		return properties;
	}
}