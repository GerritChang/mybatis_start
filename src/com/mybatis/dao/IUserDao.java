package com.mybatis.dao;

import java.util.List;

import com.mybatis.po.User;

public interface IUserDao {
	//����id��ѯ�û�����Ϣ 
	//Ϊʲô�����쳣
	public User findUserById(int id) throws Exception;
	//�����û����Ʋ�ѯ�û��б�
	public List<User> findUserByName(String name) throws Exception;
	//����û�����Ϣ
	public void insertUser(User user) throws Exception;
	//ɾ���û�����Ϣ
	public void deleteUser(int id) throws Exception;
}
