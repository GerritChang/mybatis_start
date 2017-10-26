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
		// ����sqlsessionfactory
		// mybatis�������ļ�
		String resource = "SqlMapConfig.xml";
		// ע�⣺�����ļ�Ҫ����Source Folder���ļ�����
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	// ��ѯ����������ѯ�û����û���Ϣʹ���ӳټ���
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = mapper.findOrdersUserLazyLoading();
		//�����ϱߵĶ����б�
		for(Orders orders :list) {
			User user = orders.getUser();
			System.out.println(user);
		}
		sqlSession.close();
	}
	//һ���������
	@Test
	public void testCache1() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//�±߲�ѯʹ��һ��sqlsession
		//��һ�η������󣬲�ѯidΪ1���û�
		User user1 = userMapper.findUserById(10);
		System.out.println(user1);
		//�ڶ��η������󣬲�ѯidΪ1���û�
		User user2 = userMapper.findUserById(10);
		System.out.println(user2);
		sqlSession.close();
	}

}
