package com.service;

import java.util.List;
import com.domain.User;

public interface UserService
{
	/*
	 * 显示所有用户的信息息
	 */	
	public List<User> listUser();
	 /*
		 * 用户的登录
		 * */
	public int loginUser(User user);
	/*
	 * 用户的注册
	 * */
	public int registerUser(User user);
	/*
	 * 用户的删除
	 * */
	public int delete(String id);
	/*
	 * 用户的信息修改
	 * */
	public int update(User user);
}