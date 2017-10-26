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
	// 根据id查询用户信息，得到一条用户信息
	@Test
	public void findUserByIdTest() throws IOException {
		// mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		// 注意：配置文件要放在Source Folder的文件夹下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// 通过SQLsession操作数据库
		// 第一个参数：映射文件statement的id，等于namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数,占位符
		// 最终的结果：与映射文件中所匹配的resultType类型的对象
		User user = session.selectOne("test.findUserById", 1);
		System.out.println(user);
		// 释放会话资源
		session.close();
	}

	/**
	 * selectOne:表示查询出一条记录进行映射，如果使用selectOne可以实现，那么使用selectList也可以实现（只有一条记录）
	 * selectList:表示查询出一个列表（多条记录）进行映射 如果使用selectList查询多条记录，不能使用selectOne
	 */
	// 根据用户名称模糊查询用户信息
	@Test
	public void findUserByNameTest() throws IOException {
		// mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		// 注意：配置文件要放在Source Folder的文件夹下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// 通过SQLsession操作数据库
		// 第一个参数：映射文件statement的id，等于namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数,占位符
		// 最终的结果：与映射文件中所匹配的resultType类型的对象
		// list中的User和映射文件中的resultType所指定的类型一致
		List<User> list = session.selectList("test.findUserByName", "胖");
		// 打印输出
		System.out.println(list);
		// 释放会话资源
		session.close();
	}
/**
 * 插入、删除
 * 都需要提交事务
 * */
	// 添加用户信息
	@Test
	public void insertUser() throws IOException {
		// mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		// 注意：配置文件要放在Source Folder的文件夹下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// 通过SQLsession操作数据库
		// 第一个参数：映射文件statement的id，等于namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数,占位符
		// 最终的结果：与映射文件中所匹配的resultType类型的对象
		// list中的User和映射文件中的resultType所指定的类型一致
		// 插入用户的对象
		User user = new User();
		user.setUsername("二胖");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("火星");
		session.insert("test.insertUser", user);
		// 自动提交
		session.commit();

		// 获取用户信息，新增的主键(自增主键的返回)
		int id = user.getId();
		System.out.println(id);

		// 释放会话资源
		session.close();
	}
	//删除用户
	@Test
	public void deleteUser() throws IOException {
		// mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		// 注意：配置文件要放在Source Folder的文件夹下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// 通过SQLsession操作数据库
		// 第一个参数：映射文件statement的id，等于namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数,占位符
		// 最终的结果：与映射文件中所匹配的resultType类型的对象
		//根据传入的id删除用户
		session.delete("test.deleteUser", 3);
		//提交事务
		session.commit();
		// 释放会话资源
		session.close();
	}
	//根据id更新用户
	@Test
	public void updateUser() throws IOException {
		// mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		// 注意：配置文件要放在Source Folder的文件夹下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SQLsession
		SqlSession session = sqlSessionFactory.openSession();
		// 通过SQLsession操作数据库
		// 第一个参数：映射文件statement的id，等于namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数,占位符
		// 最终的结果：与映射文件中所匹配的resultType类型的对象
		// list中的User和映射文件中的resultType所指定的类型一致
		// 插入用户的对象
		User user = new User();
		user.setId(2);
		user.setUsername("大胖");
		user.setBirthday(new Date());
		user.setSex("男");
		user.setAddress("火星");
		session.update("test.updateUser", user);
		// 自动提交
		session.commit();
		// 释放会话资源
		session.close();
	}
}
