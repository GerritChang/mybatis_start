package com.mybatis.dao;

import java.util.List;

import com.mybatis.po.User;

public interface IUserDao {
	//根据id查询用户的信息 
	//为什么会抛异常
	public User findUserById(int id) throws Exception;
	//根据用户名称查询用户列表
	public List<User> findUserByName(String name) throws Exception;
	//添加用户的信息
	public void insertUser(User user) throws Exception;
	//删除用户的信息
	public void deleteUser(int id) throws Exception;
}
