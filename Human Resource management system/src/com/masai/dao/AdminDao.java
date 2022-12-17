package com.masai.dao;

import com.masai.exceptions.AdminException;

public interface AdminDao {
	public String loginAdmin(String username,String password) throws AdminException;
}
