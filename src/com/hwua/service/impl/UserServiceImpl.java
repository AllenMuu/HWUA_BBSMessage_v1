package com.hwua.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hwua.dao.IUserDao;
import com.hwua.dao.impl.UserDaoImpl;
import com.hwua.entity.User;
import com.hwua.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao = null;

	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public User login(User user) {
		User u = null;
		try {
			u = userDao.query(user);
		} catch (SQLException e) {
			throw new RuntimeException("登陆失败");
		}
		return u;
	}

	@Override
	public boolean registerUser(User user) {
		int res = 0;
		try {
			res = userDao.save(user);
		} catch (SQLException e) {
			throw new RuntimeException("注册失败");
		}
		return res == 0 ? false : true;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> uList = null;
		try {
			uList=userDao.query();
		} catch (SQLException e) {
			throw new RuntimeException("查询用户失败");
		}
		return uList;
	}

	@Override
	public User findUserByName(String name) {
		User user = null;
		try {
			user=userDao.query(name);
		} catch (SQLException e) {
			throw new RuntimeException("查询用户失败");
		}
		return user;
	}

}
