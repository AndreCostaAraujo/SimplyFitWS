package com.ad4cbr.andre.simplyfit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySql {
	
	private static final String URL = "jdbc:mysql://simplyfit-mysql:3306/simplyfit";
	private static final String USER = "SFAdmin";
	private static final String PASS = "123qwer@";
	
	public static Connection obtemConexao() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
