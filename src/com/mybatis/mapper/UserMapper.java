package com.mybatis.mapper;

import java.util.List;

import com.mybatis.po.User;
import com.mybatis.po.UserCustom;
import com.mybatis.po.UserQueryVo;

//mapper�ӿ�
public interface UserMapper {

	// ����id��ѯ�û�����Ϣ
	public User findUserById(int id) throws Exception;

	// �����û�
	public void insertUser(User user) throws Exception;

	// ɾ���û�
	public void deleteUser(int id) throws Exception;

	// �����û����Ʋ�ѯ�û��б�
	public List<User> findUserByName(String name) throws Exception;

	// �û���Ϣ���ۺϲ�ѯ
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

	// �û���Ϣ���ۺϲ�ѯ����
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;

	// ����id��ѯ�û���Ϣ��ʹ��resultMap���
	public User findUserByIdResultMap(int id) throws Exception;

	// �����û���Ϣ
	public void updateUser(User user) throws Exception;
}
