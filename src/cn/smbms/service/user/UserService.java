package cn.smbms.service.user;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Announce;
import cn.smbms.pojo.Cart;
import cn.smbms.pojo.CartSon;
import cn.smbms.pojo.Item;
import cn.smbms.pojo.Order;
import cn.smbms.pojo.User;

public interface UserService {

	public User getLoginUser(String userId, String userpwd) throws IOException, Exception;
	
	public boolean modifyEmail(String userId, String email) throws Exception;
	
	public boolean modifyPassword(String userId, String pwdNew) throws Exception;

	public int getCartCount(String userId, String name) throws IOException, Exception;

	public List<CartSon> getCartList(String userId, String name, int currentPageNo, int pageSize) throws IOException, Exception;

	public List<Announce> getAnnoList(String title) throws IOException, Exception;
	
	public List<Item> getItemList(String type, String name) throws Exception;
	
	public boolean modifyBuyNum(String cartId, int num) throws Exception;
	
	public boolean deleteCart(String cartId) throws Exception;
	
	public List<Order> getOrderList(String userId) throws Exception;
	
	public boolean deleteOrder(String orderId) throws Exception;
	
	public boolean addCart(String userId, String itemId, String cartId) throws Exception;
	
	public boolean addOrder(String userId, String cartId, String orderPrice, int buynum) throws Exception;
}
