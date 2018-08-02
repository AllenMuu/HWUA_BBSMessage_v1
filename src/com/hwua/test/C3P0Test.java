package com.hwua.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.hwua.dao.impl.UserDaoImpl;
import com.hwua.entity.User;
import com.hwua.util.C3P0Util;

public class C3P0Test {

	@Test
	public void testConnection() {
		C3P0Util.getConnection();
	}
	
	@Test
	public void testSave() {
		UserDaoImpl dao = new UserDaoImpl();
		User user = new User("chenhao", "123456", "chenhao@qq.com");
		try {
			dao.save(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryAll() {
		UserDaoImpl dao = new UserDaoImpl();
		List<User> users=null;
		try {
			users = dao.query();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(User user:users){
			System.out.println(user.toString());
		}
	}

}
