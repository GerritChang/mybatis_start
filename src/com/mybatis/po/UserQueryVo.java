package com.mybatis.po;

import java.util.List;

//��װ����
public class UserQueryVo {
	//������id
	private List<Integer> ids;
	
	//��װ��Ҫ�Ĳ�ѯ����
	private UserCustom userCustom;
	//��װ�����Ĳ�ѯ����

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "UserQueryVo [ids=" + ids + ", userCustom=" + userCustom + "]";
	}
	
}
