package cn.smbms.service.user;

import java.io.IOException;
import java.util.List;

import cn.smbms.pojo.Admin;
import cn.smbms.pojo.Announce;
import cn.smbms.pojo.Item;
import cn.smbms.pojo.ItemClass;
import cn.smbms.pojo.Order;
import cn.smbms.pojo.User;

public interface AdminService {
	public Boolean AdminLogin(String adminId,String adminPwd) throws IOException;
	public List<Item> getItems() throws IOException;
	public List<ItemClass> getItemClasses() throws IOException;
	public List<User> getUsers() throws IOException;
	public List<Order> getOrders() throws IOException;
	public List<Item>getItemBySearch(String search) throws IOException;
	public List<Announce> getAnnounces() throws IOException;
	public List<User> getUserBySearch(String search) throws IOException;
	public List<Order> getOrderBySearch(String search) throws IOException;
	public List<ItemClass> getItemClassesBySearch(String search)throws IOException;
	public List<Announce> getAnnounceBySearch(String search)throws IOException;
	public Boolean insertItem(Item item) throws IOException;
	public Boolean insertItemType(ItemClass items) throws IOException;
	public Boolean insertAnnounce(Announce announce) throws IOException;
	public Boolean deldeteUser(String userId) throws IOException;
	public Boolean deleteAnnounce(String announceId) throws IOException;
	public Boolean deleteorder(String orderId) throws IOException;
	public Boolean deleteItemType(String ItemTypeId) throws IOException;
	public Boolean deleteItem(String ItemId) throws IOException;
	public Boolean updateItem(Item items) throws IOException;
	public List<Item> getItemsById(String itemId) throws IOException;
}
