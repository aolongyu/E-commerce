package cn.smbms.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Announce;
import cn.smbms.pojo.CartSon;
import cn.smbms.pojo.Item;
import cn.smbms.pojo.Order;
import cn.smbms.pojo.User;

public interface UserDao {

	public User getLoginUser(String userId, String userPwd) throws Exception;
	
	public boolean modifyEmail(String userId, String email) throws Exception;
	
	public boolean modifyPassword(String userId, String pwdNew) throws Exception;

	public int getCartCount(String userId, String name) throws Exception;
	
	public List<CartSon> getCartList(@Param("userId")String userId, @Param("name")String name, @Param("currentPageNo")int currentPageNo, @Param("pageSize")int pageSize, @Param("limitPageNo")int limitPageNo) throws Exception;
	
	public List<Announce> getAnnoList(String title) throws Exception;
	
	public List<Item> getItemList(String type, String name) throws Exception;
	
	public boolean modifyBuyNum(@Param("cartId")String cartId, @Param("num")int num) throws Exception;
	
	public boolean deleteCart(String cartId) throws Exception;
	
	public List<Order> getOrderList(String userId) throws Exception;
	
	public boolean deleteOrder(String orderId) throws Exception;
	
	public boolean addCart(String userId, String itemId, String cartId) throws Exception;
	
	public boolean addOrder(@Param("userId")String userId, @Param("cartId")String cartId, @Param("orderPrice")String orderPrice, @Param("buynum")int buynum) throws Exception;
	
}
