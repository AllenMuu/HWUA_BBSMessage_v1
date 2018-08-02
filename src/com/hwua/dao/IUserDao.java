package com.hwua.dao;

import java.sql.SQLException;
import java.util.List;

import com.hwua.entity.User;

public interface IUserDao {
	public int save(User user) throws SQLException;
	public List<User> query() throws SQLException;
	public User query(User user) throws SQLException;
	public User query(String name) throws SQLException;
	public int update(User user) throws SQLException;
	public int delete(int id) throws SQLException;
}
