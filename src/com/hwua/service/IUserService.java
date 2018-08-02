package com.hwua.service;

import java.util.List;

import com.hwua.entity.User;

public interface IUserService {
   //业务方法的名字要见名知意
	public User login(User user);//登陆
	public boolean registerUser(User user);//注册
	public List<User> findAllUsers();
	public User findUserByName(String name);
}
