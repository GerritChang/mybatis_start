package com.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.dao.IUserDao;
import com.mybatis.po.User;

public class UserDaoImpl implements IUserDao {
	// ��daoʵ������ע��sqlsessionfactory
	// ����ͨ�����캯��ע��
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById", id);
		// �ͷ���Դ
		session.close();
		return user;
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		// �����û�����ѯ�û���Ϣ�б�
		List<User> list = session.selectOne("test.findUserById", name);
		// �ͷ���Դ
		session.close();
		// �����û���Ϣ�б�
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		// ִ�в�������
		session.insert("test.insertUser", user);
		// �Զ��ύ
		session.commit();
		// �ͷ���Դ
		session.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		// ִ�в�������
		session.delete("test.deleteUser", id);
		// �Զ��ύ
		session.commit();
		// �ͷ���Դ
		session.close();
	}

}
