package com.service.imp;

import com.dao.UserDAO;
import com.dao.imp.UserDAOImpl;
import com.file.TSystemuser;
import com.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public TSystemuser login(String userName, String password) 
	{
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.login(userName, password);
	}

}
