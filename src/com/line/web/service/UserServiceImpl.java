package com.line.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.line.web.model.User;
import com.line.web.model.dao.UserDao;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 功能：检查账户和密码是否符合格式
	 */
	public boolean checkFormat(String account,String password){
		
		if(account == null || password == null){
			return false;
		}
		
		account = account.trim();
		password = password.trim();
		
		if(account.isEmpty() || password.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	/**
	 *	功能：登陆验证
	 */
	public User verification(String account,String password){
		
		User user = userDao.findUser(account, password);
		
		return user;
	}
	
	/**
	 * @param account 账号
	 * 功能：检查账号是否已存在
	 */
	
	public boolean isUserExist(String account){
		
		User user = userDao.findUserByAccount(account);
		
		if(user == null){
			return false;
		}
		
		return true;
	}
	
	public void saveUser(User user){
		
		userDao.saveUser(user);
	}
	
}
