package com.demo;

import java.io.IOException;
//import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connectivity {

	public static Connection getConnectivity() {
		Connection con=null;
	
		try {
			String f="resources/DbConnection.properties";
			InputStream stream=Connectivity.class.getClassLoader().getResourceAsStream(f);
			Properties props=new Properties();
			props.load(stream);
			String url=props.getProperty("database.url");
			String password=props.getProperty("database.passWord");
			String usr=props.getProperty("database.userName");
			try {
				con=DriverManager.getConnection(url, usr, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
