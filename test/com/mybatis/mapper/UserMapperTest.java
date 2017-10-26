package com.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.po.User;
import com.mybatis.po.UserCustom;
import com.mybatis.po.UserQueryVo;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 创建sqlsessionfactory
		// mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		// 注意：配置文件要放在Source Folder的文件夹下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//调用UserMapper的方法
		User user = mapper.findUserById(1);
		session.close();
		System.out.println(user);
	}
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//调用UserMapper的方法
		User user = mapper.findUserByIdResultMap(1);
		session.close();
		System.out.println(user);
	}
	@Test
	public void testfindUserByName() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//调用UserMapper的方法
		List<User> list = mapper.findUserByName("胖");
		session.close();
		System.out.println(list);
	}
	@Test
	public void testfindUserList() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//构建包装对象
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("男");
		userCustom.setUsername("胖");
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		//将ids传入statement中
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		//调用UserMapper的方法
		List<UserCustom> list = mapper.findUserList(userQueryVo);
		session.close();
		System.out.println(list);
	}
	
	@Test
	public void testfindUserCount() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//创建UserMapper对象，mybatis自动生成mapper代理对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//构建包装对象
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("男");
		userCustom.setUsername("胖");
		userQueryVo.setUserCustom(userCustom);
		//调用UserMapper的方法
		int count = mapper.findUserCount(userQueryVo);
		session.close();
		System.out.println(count);
	}
}
