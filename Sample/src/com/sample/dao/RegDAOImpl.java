package com.sample.dao;

import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.sample.app.RegBean;
import com.sample.db.DBConnection;


public class RegDAOImpl {


	public int saveUserDetails(RegBean bean){
		
		int saveUpdateCount = 0;
		
		try {
		
			System.out.println("::::::::::::::"+bean.getInsertType());
			
			if(bean.getInsertType().equalsIgnoreCase("insert")){
				
				java.sql.PreparedStatement ps = DBConnection.getConnection().prepareStatement(" insert into tbl_user (user_name,gender,age,address,email) values (?,?,?,?,?) ");
				
				ps.setString(1, bean.getUserName());
				ps.setString(2, bean.getUserGender());
				ps.setInt(3, bean.getUserAge());
				ps.setString(4, bean.getUserAddr());
				ps.setString(5, bean.getUserEmail());
				
				saveUpdateCount = ps.executeUpdate();
				
			}else if(bean.getInsertType().equalsIgnoreCase("StoredProcedure")){
				
				java.sql.PreparedStatement ps = DBConnection.getConnection().prepareStatement(" {call InsertRegister(?,?,?,?,?)} ");
				
				ps.setString(1, bean.getUserName());
				ps.setString(2, bean.getUserGender());
				ps.setInt(3, bean.getUserAge());
				ps.setString(4, bean.getUserAddr());
				ps.setString(5, bean.getUserEmail());
				
				saveUpdateCount = ps.executeUpdate();
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return saveUpdateCount;
	}
}
