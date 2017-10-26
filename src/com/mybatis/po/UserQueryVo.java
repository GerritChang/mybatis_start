package com.mybatis.po;

import java.util.List;

//包装类型
public class UserQueryVo {
	//传入多个id
	private List<Integer> ids;
	
	//包装需要的查询条件
	private UserCustom userCustom;
	//包装其他的查询条件

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
