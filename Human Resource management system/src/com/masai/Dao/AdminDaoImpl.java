package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Exceptions.AdminException;
import com.masai.Utility.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String loginAdmin(String username, String password) throws AdminException {
		String message = "";
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from AdminDetail where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
						
				message = "Login successfully";
			
			}else {
				throw new AdminException("Invalid credential details");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}

		
		return message;
	}
	
}
