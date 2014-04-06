package com.line.web.service;

import com.line.web.model.User;

public interface UserService {
	
	boolean checkFormat(String account,String password);
	
	User verification(String account,String password);
	
	boolean isUserExist(String account);
	
	User saveUser(String account,String password);
	
	User findUserById(String userId);
	
	

}
