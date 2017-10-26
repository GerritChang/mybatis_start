package com.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.po.Orders;
import com.mybatis.po.User;

public class OrdersMapperCustomTest {
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

	// 查询订单关联查询用户，用户信息使用延迟加载
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = mapper.findOrdersUserLazyLoading();
		//遍历上边的订单列表
		for(Orders orders :list) {
			User user = orders.getUser();
			System.out.println(user);
		}
		sqlSession.close();
	}
	//一级缓存测试
	@Test
	public void testCache1() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//下边查询使用一个sqlsession
		//第一次发起请求，查询id为1的用户
		User user1 = userMapper.findUserById(10);
		System.out.println(user1);
		//第二次发起请求，查询id为1的用户
		User user2 = userMapper.findUserById(10);
		System.out.println(user2);
		sqlSession.close();
	}

}
