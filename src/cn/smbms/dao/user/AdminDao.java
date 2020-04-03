package cn.smbms.dao.user;

import java.util.List;

import cn.smbms.pojo.Admin;
import cn.smbms.pojo.Announce;
import cn.smbms.pojo.Item;
import cn.smbms.pojo.ItemClass;
import cn.smbms.pojo.Order;
import cn.smbms.pojo.User;

public interface AdminDao {
	public int LoginAdmin(Admin admin);
	public List<Item> getItems();
	public List<ItemClass> getItemClasses();
	public List<User> getUsers();
	public List<Order> getOrders();
	public List<Item> getItemBySearch(String search);
	public List<Announce> getAnnounces();
	public List<User> getUserBySearch(String search);
	public List<Order> getOrderBySearch(String search);
	public List<ItemClass> getItemClassesBySearch(String search);
	public List<Announce> getAnnounceBySearch(String search);
	public List<Item> getItemsById(String itemId);
	public Boolean insertItem(Item item);
	public Boolean insertItemType(ItemClass items);
	public Boolean insertAnnounce(Announce announce);
	public Boolean deleteUser(String userId);
	public Boolean deleteAnnounce(String announceId);
	public Boolean deleteorder(String orderId);
	public Boolean deleteItemType(String ItemTypeId);
	public Boolean deleteItem(String ItemId);
	public Boolean updateItem(Item items);
}