package com.hwua.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.IUserDao;
import com.hwua.entity.User;
import com.hwua.util.C3P0Util;

public class UserDaoImpl implements IUserDao {

	@Override
	public int save(User user) throws SQLException {
		String sql = "insert into users values(null,?,?,?)";
		Object [] params = {user.getName(),user.getPwd(),user.getEmail()};
		QueryRunner qr = new QueryRunner(C3P0Util.getCpds());
		return qr.update(sql, params);
	}

	@Override
	public List<User> query() throws SQLException {
		String sql = "select id,name,pwd,email from users";
		Object [] params = null;
		QueryRunner qr = new QueryRunner(C3P0Util.getCpds());
		List<User> users = qr.query(sql, new BeanListHandler<>(User.class), params);
		return users;
	}

	@Override
	public User query(User user) throws SQLException {
		String sql = "select id,name,pwd,email from users where name = ? and pwd = ?";
		Object [] params ={user.getName(),user.getPwd()};
		QueryRunner qr = new QueryRunner(C3P0Util.getCpds());
		user = qr.query(sql, new BeanHandler<>(User.class), params);
		return user;
	}

	@Override
	public User query(String name) throws SQLException {
		String sql = "select id,name,pwd,email from users where name = ?";
		Object [] params ={name};
		QueryRunner qr = new QueryRunner(C3P0Util.getCpds());
		User user = qr.query(sql, new BeanHandler<>(User.class), params);
		return user;
	}

	@Override
	public int update(User user) throws SQLException {
		String sql = "update users set name= ?,pwd=?,email=? where id= ?";
		Object [] params = {user.getName(),user.getPwd(),user.getEmail(),user.getId()};
		QueryRunner qr = new QueryRunner(C3P0Util.getCpds());
		//加入QueryRunner对象，给定一个数据源参数，那么连接当执行完后会自动释放（返回连接池）
		return qr.update(sql, params);
	}

	@Override
	public int delete(int id) throws SQLException {
		String sql = "delete from users where id = ?";
		Object [] params = {id};
		QueryRunner qr = new QueryRunner(C3P0Util.getCpds());
		return qr.update(sql, params);
	}

}
