package com.hwua.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;

public class UserSevlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String param = req.getParameter("param");
		// 创建业务层对象
		IUserService userService = new UserServiceImpl();
		if (param.equals("login")) {
			// 获取视图层提交过来的表单数据
			String username = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			// 封装成User对象
			User user = new User(username, pwd);
			
			// 调用业务层的方法进行处理
			user = userService.login(user);
			// 根据业务层返回的结果选择试图进行跳转
			if (user != null) {
				resp.sendRedirect(req.getContextPath() + "/main.html");
			} else {
				resp.sendRedirect(req.getContextPath() + "/register.html");
			}
		}else if(param.equals("register")){
			//获取表单数据
			String username = req.getParameter("name");
			String pwd = req.getParameter("pwd");
			String email = req.getParameter("email");
			User user = new User(username, pwd, email);
			//调用业务层方法
			boolean flag = userService.registerUser(user);
			if(flag){
				resp.sendRedirect(req.getContextPath() + "/index.html");
			}else{
				resp.sendRedirect(req.getContextPath() + "/register.html");
			}
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
