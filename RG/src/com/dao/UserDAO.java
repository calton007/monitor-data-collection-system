package com.dao;

import com.file.TSystemuser;

public interface UserDAO 
{
	public TSystemuser login(String userName, String password);

}
