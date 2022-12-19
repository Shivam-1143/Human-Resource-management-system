package com.masai.Dao;

import com.masai.Exceptions.AdminException;

public interface AdminDao {
	public String loginAdmin(String username,String password) throws AdminException;
}
