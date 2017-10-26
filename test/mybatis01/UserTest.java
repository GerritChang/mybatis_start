package mybatis01;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.IUserDao;
import com.mybatis.dao.impl.UserDaoImpl;
import com.mybatis.po.User;

public class UserTest {
	private SqlSessionFactory sqlSessionFactory;

	// 此方法在执行Test之前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlsessionfactory
		// mybatis的配置文件
		String resource = "SqlMapConfig.xml";
		// 注意：配置文件要放在Source Folder的文件夹下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testfindUserById() throws Exception {
		IUserDao userdao = new UserDaoImpl(sqlSessionFactory);
		User user = userdao.findUserById(1);
		System.out.println(user);
	}

}
