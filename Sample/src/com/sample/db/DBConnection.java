package com.sample.db;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
	static java.sql.Connection con = null;
	
	private DBConnection(){
	}
	
	public static Connection getConnection(){
		if(con == null)
		{
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				con = DriverManager.getConnection("jdbc:mysql://localhost:3307/sample","root","admin");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return (Connection) con;
	}
}
