package com.line.web.model.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.line.web.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sf;
	
	/**
	 * @param account 用户账号
	 * @param password 密码
	 * 功能：通过用户的账号和密码查找用户。
	 */
	@Override
	public User findUser(String account,String password){
		
		User user = (User) sf.getCurrentSession()
					.createQuery("from User u where u.accout = ? and u.password = ?")
					.setParameter(0,account)
					.setParameter(1,password)
					.uniqueResult();
		return user;
	}
	
	/**
	 * 功能：通过用户的账号查找用户
	 * @param account 用户的账号
	 */
	@Override
	public User findUserByAccount(String account) {
		
		User user = (User) sf.getCurrentSession()
				.createQuery("from User u where u.accout = ? and u.password = ?")
				.setParameter(0,account)
				.uniqueResult();
		return user;
	}
	
	/**
	 * @param user 要添加的用户
	 */
	@Override
	public void addUser(User user) {
		
		sf.getCurrentSession().save(user);
	}
	
	/**
	 * 查询所有的用户
	 */
	@Override
	public List<User> allUser() {
		
		List<User> users =  sf.getCurrentSession()
							.createQuery("from User")
							.list();
		
		return users;
	}
	
	/**
	 * 更新用户的信息
	 */
	@Override
	public void updataUserImfo(User user) {
		sf.getCurrentSession().update(user);
	}
	
}
