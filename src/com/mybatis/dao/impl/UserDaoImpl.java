package com.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.dao.IUserDao;
import com.mybatis.po.User;

public class UserDaoImpl implements IUserDao {
	// 向dao实现类中注入sqlsessionfactory
	// 这里通过构造函数注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById", id);
		// 释放资源
		session.close();
		return user;
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		// 根据用户名查询用户信息列表
		List<User> list = session.selectOne("test.findUserById", name);
		// 释放资源
		session.close();
		// 返回用户信息列表
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		// 执行插入事务
		session.insert("test.insertUser", user);
		// 自动提交
		session.commit();
		// 释放资源
		session.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		// 执行插入事务
		session.delete("test.deleteUser", id);
		// 自动提交
		session.commit();
		// 释放资源
		session.close();
	}

}
