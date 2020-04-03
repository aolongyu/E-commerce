package cn.smbms.service.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import cn.smbms.dao.user.UserDao;
import cn.smbms.pojo.Announce;
import cn.smbms.pojo.Cart;
import cn.smbms.pojo.CartSon;
import cn.smbms.pojo.Item;
import cn.smbms.pojo.Order;
import cn.smbms.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	private SqlSessionFactory sqlSessionFactory;

	@Override
	public User getLoginUser(String userId, String passWord) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);

		User user = ud.getLoginUser(userId, passWord);
		sqlSession.commit();
		sqlSession.close();
		return user;
	}

	@Override
	public boolean modifyEmail(String userId, String email) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		boolean bool = ud.modifyEmail(userId, email);
		sqlSession.commit();
		sqlSession.close();
		return bool;
	}

	@Override
	public boolean modifyPassword(String userId, String pwdNew) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		boolean bool = ud.modifyPassword(userId, pwdNew);
		sqlSession.commit();
		sqlSession.close();
		return bool;
	}

	@Override
	public int getCartCount(String userId, String name) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		int num = ud.getCartCount(userId, name);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}

	@Override
	public List<CartSon> getCartList(String userId, String name, int currentPageNo, int pageSize) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		
		int limitPageNo = (currentPageNo - 1) * pageSize;

		List<CartSon> cartList = ud.getCartList(userId, name, currentPageNo, pageSize, limitPageNo);
	
		return cartList;
	}

	@Override
	public List<Announce> getAnnoList(String title) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		
		List<Announce> annoList = ud.getAnnoList(title);
		sqlSession.commit();
		sqlSession.close();
		return annoList;
	}

	@Override
	public List<Item> getItemList(String type, String name) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		
		List<Item> itemList = ud.getItemList(type, name);
		
		sqlSession.commit();
		sqlSession.close();
		return itemList;
	}

	@Override
	public boolean modifyBuyNum(String cartId, int num) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		
		boolean bool = ud.modifyBuyNum(cartId, num);
		
		sqlSession.commit();
		sqlSession.close();
		return bool;
	}

	@Override
	public boolean deleteCart(String cartId) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		
		boolean bool = ud.deleteCart(cartId);
		
		sqlSession.commit();
		sqlSession.close();
		return bool;
	}

	@Override
	public List<Order> getOrderList(String userId) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		
		List<Order> orderList = ud.getOrderList(userId);
		
		sqlSession.commit();
		sqlSession.close();
		return orderList;
	}

	@Override
	public boolean deleteOrder(String orderId) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		
		boolean bool = ud.deleteOrder(orderId);
		
		sqlSession.commit();
		sqlSession.close();
		return bool;
	}

	@Override
	public boolean addCart(String userId, String itemId, String cartId) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		
		boolean bool = ud.addCart(userId, itemId, cartId);
		
		sqlSession.commit();
		sqlSession.close();
		return bool;
	}

	@Override
	public boolean addOrder(String userId, String cartId, String orderPrice, int buynum) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao ud = sqlSession.getMapper(UserDao.class);
		
		boolean bool = ud.addOrder(userId, cartId, orderPrice, buynum);
		
		sqlSession.commit();
		sqlSession.close();
		return bool;
	}
}
