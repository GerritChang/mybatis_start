package com.mybatis.mapper;

import java.util.List;

import com.mybatis.po.Orders;

public interface OrdersMapperCustom {
	//��ѯ����������ѯ�û����û���Ϣ�ӳټ���
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
