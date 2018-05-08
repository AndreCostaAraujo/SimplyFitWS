package com.ad4cbr.andre.simplyfit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySql {
	private static final String URL = "jdbc:mysql://localhost/simplyfit";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection obtemConexao() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
