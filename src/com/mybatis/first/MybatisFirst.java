package com.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.po.User;

public class MybatisFirst {
	// ����id��ѯ�û���Ϣ���õ�һ���û���Ϣ
	@Test
	public void findUserByIdTest() throws IOException {
		// mybatis�������ļ�
		String resource = "SqlMapConfig.xml";
		// ע�⣺�����ļ�Ҫ����Source Folder���ļ�����
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// ͨ��SQLsession�������ݿ�
		// ��һ��������ӳ���ļ�statement��id������namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���,ռλ��
		// ���յĽ������ӳ���ļ�����ƥ���resultType���͵Ķ���
		User user = session.selectOne("test.findUserById", 1);
		System.out.println(user);
		// �ͷŻỰ��Դ
		session.close();
	}

	/**
	 * selectOne:��ʾ��ѯ��һ����¼����ӳ�䣬���ʹ��selectOne����ʵ�֣���ôʹ��selectListҲ����ʵ�֣�ֻ��һ����¼��
	 * selectList:��ʾ��ѯ��һ���б�������¼������ӳ�� ���ʹ��selectList��ѯ������¼������ʹ��selectOne
	 */
	// �����û�����ģ����ѯ�û���Ϣ
	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis�������ļ�
		String resource = "SqlMapConfig.xml";
		// ע�⣺�����ļ�Ҫ����Source Folder���ļ�����
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// ͨ��SQLsession�������ݿ�
		// ��һ��������ӳ���ļ�statement��id������namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���,ռλ��
		// ���յĽ������ӳ���ļ�����ƥ���resultType���͵Ķ���
		// list�е�User��ӳ���ļ��е�resultType��ָ��������һ��
		List<User> list = session.selectList("test.findUserByName", "��");
		// ��ӡ���
		System.out.println(list);
		// �ͷŻỰ��Դ
		session.close();
	}
/**
 * ���롢ɾ��
 * ����Ҫ�ύ����
 * */
	// ����û���Ϣ
	@Test
	public void insertUser() throws IOException {
		// mybatis�������ļ�
		String resource = "SqlMapConfig.xml";
		// ע�⣺�����ļ�Ҫ����Source Folder���ļ�����
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// ͨ��SQLsession�������ݿ�
		// ��һ��������ӳ���ļ�statement��id������namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���,ռλ��
		// ���յĽ������ӳ���ļ�����ƥ���resultType���͵Ķ���
		// list�е�User��ӳ���ļ��е�resultType��ָ��������һ��
		// �����û��Ķ���
		User user = new User();
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("����");
		session.insert("test.insertUser", user);
		// �Զ��ύ
		session.commit();

		// ��ȡ�û���Ϣ������������(���������ķ���)
		int id = user.getId();
		System.out.println(id);

		// �ͷŻỰ��Դ
		session.close();
	}
	//ɾ���û�
	@Test
	public void deleteUser() throws IOException {
		// mybatis�������ļ�
		String resource = "SqlMapConfig.xml";
		// ע�⣺�����ļ�Ҫ����Source Folder���ļ�����
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// ͨ��SQLsession�������ݿ�
		// ��һ��������ӳ���ļ�statement��id������namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���,ռλ��
		// ���յĽ������ӳ���ļ�����ƥ���resultType���͵Ķ���
		//���ݴ����idɾ���û�
		session.delete("test.deleteUser", 3);
		//�ύ����
		session.commit();
		// �ͷŻỰ��Դ
		session.close();
	}
	//����id�����û�
	@Test
	public void updateUser() throws IOException {
		// mybatis�������ļ�
		String resource = "SqlMapConfig.xml";
		// ע�⣺�����ļ�Ҫ����Source Folder���ļ�����
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// ͨ��SQLsession�������ݿ�
		// ��һ��������ӳ���ļ�statement��id������namespace+"."+statement��id
		// �ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���,ռλ��
		// ���յĽ������ӳ���ļ�����ƥ���resultType���͵Ķ���
		// list�е�User��ӳ���ļ��е�resultType��ָ��������һ��
		// �����û��Ķ���
		User user = new User();
		user.setId(2);
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("����");
		session.update("test.updateUser", user);
		// �Զ��ύ
		session.commit();
		// �ͷŻỰ��Դ
		session.close();
	}
}
