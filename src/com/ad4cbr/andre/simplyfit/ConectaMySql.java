package com.ad4cbr.andre.simplyfit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.InvalidFileFormatException;

public class ConectaMySql {
	
	private static String URL = "jdbc:mysql://simplyfit-mysql/simplyfit";
	private static String USER = "SFAdmin";
	private static String PASS = "123qwer@";
	
	public static Connection obtemConexao() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
