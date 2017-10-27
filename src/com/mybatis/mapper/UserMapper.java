package com.mybatis.mapper;

import java.util.List;

import com.mybatis.po.User;
import com.mybatis.po.UserCustom;
import com.mybatis.po.UserQueryVo;

//mapper接口
public interface UserMapper {

	// 根据id查询用户的信息
	public User findUserById(int id) throws Exception;

	// 插入用户
	public void insertUser(User user) throws Exception;

	// 删除用户
	public void deleteUser(int id) throws Exception;

	// 根据用户名称查询用户列表
	public List<User> findUserByName(String name) throws Exception;

	// 用户信息的综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

	// 用户信息的综合查询总数
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;

	// 根据id查询用户信息，使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;

	// 更新用户信息
	public void updateUser(User user) throws Exception;
}
