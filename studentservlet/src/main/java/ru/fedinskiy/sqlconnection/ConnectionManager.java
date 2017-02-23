package ru.fedinskiy.sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import  org.postgresql.Driver;
/**
 * Created by fedinskiy on 16.02.17.
 */
public class ConnectionManager {
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException {
		if(null==conn){
			{Driver.getVersion();}
			String url ="jdbc:postgresql://localhost:5432/mfdb?user=test&password=test";
			conn= DriverManager.getConnection(url);
		}
		return conn;
	}
}
