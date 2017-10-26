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
		// ����sqlsessionfactory
		// mybatis�������ļ�
		String resource = "SqlMapConfig.xml";
		// ע�⣺�����ļ�Ҫ����Source Folder���ļ�����
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//����UserMapper�ķ���
		User user = mapper.findUserById(1);
		session.close();
		System.out.println(user);
	}
	@Test
	public void testFindUserByIdResultMap() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//����UserMapper�ķ���
		User user = mapper.findUserByIdResultMap(1);
		session.close();
		System.out.println(user);
	}
	@Test
	public void testfindUserByName() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//����UserMapper�ķ���
		List<User> list = mapper.findUserByName("��");
		session.close();
		System.out.println(list);
	}
	@Test
	public void testfindUserList() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//������װ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("��");
		userCustom.setUsername("��");
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		//��ids����statement��
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		//����UserMapper�ķ���
		List<UserCustom> list = mapper.findUserList(userQueryVo);
		session.close();
		System.out.println(list);
	}
	
	@Test
	public void testfindUserCount() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		//����UserMapper����mybatis�Զ�����mapper�������
		UserMapper mapper = session.getMapper(UserMapper.class);
		//������װ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("��");
		userCustom.setUsername("��");
		userQueryVo.setUserCustom(userCustom);
		//����UserMapper�ķ���
		int count = mapper.findUserCount(userQueryVo);
		session.close();
		System.out.println(count);
	}
}
