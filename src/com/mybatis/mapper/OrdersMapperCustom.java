package com.mybatis.mapper;

import java.util.List;

import com.mybatis.po.Orders;

public interface OrdersMapperCustom {
	//查询订单关联查询用户，用户信息延迟加载
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
