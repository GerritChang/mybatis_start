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

	// �˷�����ִ��Test֮ǰִ��
	@Before
	public void setUp() throws Exception {
		// ����sqlsessionfactory
		// mybatis�������ļ�
		String resource = "SqlMapConfig.xml";
		// ע�⣺�����ļ�Ҫ����Source Folder���ļ�����
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testfindUserById() throws Exception {
		IUserDao userdao = new UserDaoImpl(sqlSessionFactory);
		User user = userdao.findUserById(1);
		System.out.println(user);
	}

}
