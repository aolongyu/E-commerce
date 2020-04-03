package cn.smbms.service.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.smbms.dao.user.AdminDao;
import cn.smbms.dao.user.UserDao;
import cn.smbms.pojo.Admin;
import cn.smbms.pojo.Announce;
import cn.smbms.pojo.Item;
import cn.smbms.pojo.ItemClass;
import cn.smbms.pojo.Order;
import cn.smbms.pojo.User;

@Service
public class AdminServicelmp implements AdminService{
	
	private SqlSessionFactory sqlSessionFactory;
	@Override
	public Boolean AdminLogin(String adminId,String adminPwd) throws IOException ///判断能不能登陆
	{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Admin admin = new Admin();
		admin.setAdminId(adminId);
		admin.setAdminPwd(adminPwd);
		int x = adminDao.LoginAdmin(admin);
		System.out.println("1wocoaoasd " + x);
		if(x == 0)
			return false;
		return true;
	}
	@Override
	public List<Item> getItems() throws IOException {
		List<Item> list = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list = adminDao.getItems();
		return list;
	}
	@Override
	public List<ItemClass> getItemClasses() throws IOException {
		List<ItemClass> list = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list  = adminDao.getItemClasses();
		return list;
	}
	@Override
	public List<User> getUsers() throws IOException {
		List<User> list = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list = adminDao.getUsers();
		return list;
	}
	@Override
	public List<Order> getOrders() throws IOException {
		List<Order> list = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list = adminDao.getOrders();
		return list;
	}
	@Override
	public List<Item> getItemBySearch(String search) throws IOException {
		List<Item> list = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list = adminDao.getItemBySearch(search);
		return list;
	}
	@Override
	public List<Announce> getAnnounces() throws IOException {
		List<Announce> list= null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list = adminDao.getAnnounces();
		return list;
	}
	@Override
	public List<User> getUserBySearch(String search) throws IOException {
		List<User> list = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list = adminDao.getUserBySearch(search);
		return list;
	}
	@Override
	public List<Order> getOrderBySearch(String search) throws IOException {
		List<Order> list = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list = adminDao.getOrderBySearch(search);
		return list;
	}
	@Override
	public List<ItemClass> getItemClassesBySearch(String search) throws IOException {
		List<ItemClass> list = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list = adminDao.getItemClassesBySearch(search);
		return list;
	}
	@Override
	public List<Announce> getAnnounceBySearch(String search) throws IOException {
		List<Announce> list = null;
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		list = adminDao.getAnnounceBySearch(search);
		return list;
	}

	@Override
	public Boolean insertItem(Item item) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Boolean ansBoolean  = adminDao.insertItem(item);
		sqlSession.commit();
		return ansBoolean;
	}
	@Override
	public Boolean insertItemType(ItemClass items) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Boolean ansBoolean = adminDao.insertItemType(items);
		sqlSession.commit();
		return ansBoolean;
	}
	@Override
	public Boolean insertAnnounce(Announce announce) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Boolean ansBoolean = adminDao.insertAnnounce(announce);
		sqlSession.commit();
		return ansBoolean;
	}
	/*以下是删除操作*/
	@Override
	public Boolean deldeteUser(String userId) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Boolean ansBoolean = adminDao.deleteUser(userId);
		sqlSession.commit();
		return ansBoolean;
	}
	@Override
	public Boolean deleteAnnounce(String announceId) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Boolean ansBoolean = adminDao.deleteAnnounce(announceId);
		sqlSession.commit();
		return ansBoolean;
	}
	@Override
	public Boolean deleteorder(String orderId) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Boolean ansBoolean = adminDao.deleteorder(orderId);
		sqlSession.commit();
		return null;
	}
	@Override
	public Boolean deleteItemType(String ItemTypeId) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Boolean ansBoolean = adminDao.deleteItemType(ItemTypeId);
		sqlSession.commit();
		return ansBoolean;
	}
	@Override
	public Boolean deleteItem(String ItemId) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Boolean ansBoolean = adminDao.deleteItem(ItemId);
		sqlSession.commit();
		return ansBoolean;
	}
	@Override
	public Boolean updateItem(Item items) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		Boolean ansBoolean = adminDao.updateItem(items);
		sqlSession.commit();
		return ansBoolean;
	}
	@Override
	public List<Item> getItemsById(String itemId) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
		return adminDao.getItemsById(itemId);
	}
}
