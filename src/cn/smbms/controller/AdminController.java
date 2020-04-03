package cn.smbms.controller;

import java.awt.ItemSelectable;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.Admin;
import cn.smbms.pojo.Announce;
import cn.smbms.pojo.Item;
import cn.smbms.pojo.ItemClass;
import cn.smbms.pojo.Order;
import cn.smbms.pojo.User;
import cn.smbms.service.user.AdminService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;

@Controller
public class AdminController {
	@Resource
	AdminService adminService;
	@RequestMapping(value = "/login.html")
	public String login() {
		return "AdminLogin";
	}
	@RequestMapping(value = "/addItem.html")
	public String AddItem(Model model,HttpSession session) throws IOException {
		List<ItemClass> itemClasses = adminService.getItemClasses();
		System.out.println(itemClasses);
		model.addAttribute("itemClasses", itemClasses);
		return "ItemAdd";
	}
	
	@RequestMapping(value = "/ItemType_admin.html")
	public String toType(Model model,HttpSession session) throws IOException
	{
		List<ItemClass> itemClasses = adminService.getItemClasses();
		model.addAttribute("itemClasses", itemClasses);
		return "ItemType_admin";
	}
	@RequestMapping(value = "/User_admin.html")
	public String toUser(Model model,HttpSession session) throws IOException
	{
		List<User> users = adminService.getUsers();
		model.addAttribute("users", users);
		return "User_admin";
	}
	@RequestMapping(value = "/order_admin.html")
	public String toOrder(Model model,HttpSession session) throws IOException
	{
		List<Order> orders = adminService.getOrders();
		model.addAttribute("Orders",orders);
		return "order_admin";
	}
	@RequestMapping(value = "/announce_admin.html")
	public String toannounce(Model model,HttpSession session) throws IOException
	{
		List<Announce> announces = adminService.getAnnounces();
		model.addAttribute("announces",announces);
		return "announce_admin";
	}
	
	@RequestMapping(value = "/main_adminnow.html")
	public String backadmin() {
		return "redirect:/main_admin.html";
	}
	
	@RequestMapping(value = "/logout.html")
	public String logout(HttpSession session) {
		session.removeAttribute(Constants.USER_SESSION);
		session.removeAttribute(Constants.USER_ID);
		return "AdminLogin";
	}
	
	@RequestMapping(value = "/itemTypeAdd.html")
	public String toAddItemType(HttpSession session) {
		
		return "ItemTypeAdd";
	}

	@RequestMapping(value = "/AnnounceAdd.html")
	public String toAddAnnounce(HttpSession session) {
		
		return "AddAnnounce";
	}
	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	public String doLogin(@RequestParam String userId, @RequestParam String userPwd, @RequestParam String code,
			HttpServletRequest request, HttpSession session) throws IOException, Exception {
		System.out.println(userId + userPwd);
		Admin admin = new Admin();
		admin.setAdminId(userId);
		admin.setAdminPwd(userPwd);
		boolean ans = adminService.AdminLogin(userId,userPwd);
		System.out.println(ans);
		String randStr = (String) request.getSession().getAttribute("randStr");
		if (!code.equalsIgnoreCase(randStr)) {
			request.setAttribute("error", "(验证码错误)");
			return "AdminLogin";
		}
		if (ans) {
			session.setAttribute(Constants.USER_SESSION, admin);
			return "redirect:/main_admin.html";
		} else {
			request.setAttribute("error", "(密码或者用户名错误)");
			return "AdminLogin";
		}
	}
	
	@RequestMapping(value = "/main_admin.html")
	public String main_user(Model model, 
			@RequestParam(value = "pageIndex", required = false) String pageIndex, HttpServletRequest request,
			HttpSession session) throws IOException, Exception {
		
		int pageSize = Constants.pageSize;
		int currentPageNo = 1;
		
		if (pageIndex != null) {
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				return "redirect:/user/syserror.html";
			}
		}
		Admin admin = null;
		admin = (Admin) session.getAttribute(Constants.USER_SESSION);
		String adminId = admin.getAdminId();
		List<Item> courses1 = adminService.getItems();
		
		int totalCount = courses1.size();
		
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		// 鎺у埗棣栭〉鍜屽熬椤�
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		
		List<Item> courses = new LinkedList<>();
		int sum = 0;
		int limitPageNo = (currentPageNo - 1) * pageSize;
		int limitPageEnd = (currentPageNo) * pageSize;
		for(Item items : courses1)
		{
			sum++;
			if(sum >= limitPageNo && sum <= limitPageEnd)
			{
				courses.add(items);
			}
		}
		
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		
		model.addAttribute("items", courses);
		return "main_admin";
	}
	@RequestMapping(value = "/AddItemDo.html", method = RequestMethod.POST)
	public String AddItemDo(@RequestParam String cname5,@RequestParam String cname1,@RequestParam String cname4, @RequestParam String cname2, @RequestParam String cname3,
			HttpServletRequest request, HttpSession session) throws IOException, Exception {
		Item items = new Item();
		items.setItemName(cname1);
		items.setItemType(cname4);
		items.setPeiceNow(Double.valueOf(cname2));
		items.setPriceOld(Double.valueOf(cname2));
		items.setStock(Integer.valueOf(cname3));
		items.setPicture(cname5);
		adminService.insertItem(items);
		System.out.println(items);
		return "redirect:/main_admin.html";
	}
	@RequestMapping(value = "/AddItemTypeAdd.html", method = RequestMethod.POST)
	public String AddItemTypeDo(@RequestParam String cname1,
			HttpServletRequest request, HttpSession session) throws IOException, Exception {
		ItemClass items = new ItemClass();
		items.setItemType(cname1);
		adminService.insertItemType(items);
		return "redirect:/ItemType_admin.html";
	}

	@RequestMapping(value = "/AnnounceAdddo.html", method = RequestMethod.POST)
	public String AddAnnounceDo(@RequestParam String cname1,@RequestParam String cname2,
			HttpServletRequest request, HttpSession session) throws IOException, Exception {
		Announce announce = new Announce();
		announce.setAnnounTitle(cname1);
		announce.setAnnounContent(cname2);
		adminService.insertAnnounce(announce);
		return "redirect:/announce_admin.html";
	}
	@RequestMapping(value = "/FindItem.html", method = RequestMethod.POST)
	public String FindItem(Model model,@RequestParam String search, HttpServletRequest request, HttpSession session) throws IOException, Exception {
		List<Item> items = adminService.getItemBySearch(search);
		model.addAttribute("items",items);
		return "/main_admin";
	}
	@RequestMapping(value = "/Findannounce.html", method = RequestMethod.POST)
	public String Findannounce(Model model,@RequestParam String search, HttpServletRequest request, HttpSession session) throws IOException, Exception {
		List<Announce> items = adminService.getAnnounceBySearch(search);
		model.addAttribute("announces",items);
		return "announce_admin";
	}
	@RequestMapping(value = "/FindItemclass.html", method = RequestMethod.POST)
	public String Finditemclass(Model model,@RequestParam String search, HttpServletRequest request, HttpSession session) throws IOException, Exception {
		List<ItemClass> items = adminService.getItemClassesBySearch(search);
		model.addAttribute("itemClasses", items);
		return "/ItemType_admin";
	}
	@RequestMapping(value = "/FindUser.html", method = RequestMethod.POST)
	public String Finduser(Model model,@RequestParam String search, HttpServletRequest request, HttpSession session) throws IOException, Exception {
		List<User> items = adminService.getUserBySearch(search);
		model.addAttribute("users", items);
		return "/User_admin";
	}
	@RequestMapping(value = "/Findorder.html", method = RequestMethod.POST)
	public String Findorder(Model model,@RequestParam String search, HttpServletRequest request, HttpSession session) throws IOException, Exception {
		List<Order> items = adminService.getOrderBySearch(search);
		model.addAttribute("Orders",items);
		return "/order_admin";
	}
	/*閫氳繃URL浼犲�肩敤鏉ュ垹闄ょ殑*/
	/*鍒犻櫎鐢ㄦ埛*/
	@RequestMapping(value = "DeleteUserId")
	public String showWithParam(
			@RequestParam(value = "UserId", required = false, defaultValue = "默认") String str,HttpSession session,Model model) throws IOException {
		adminService.deldeteUser(str);
		return "redirect:/User_admin.html";
	}
	/*鍒犻櫎鍏憡*/
	@RequestMapping(value = "DeleteAnnounceId")
	public String DeleteAnnounceId(
			@RequestParam(value = "announId", required = false, defaultValue = "默认") String str,HttpSession session,Model model) throws IOException {
		adminService.deleteAnnounce(str);
		return "redirect:/announce_admin.html";
	}
	/*鍒犻櫎璁㈠崟*/
	@RequestMapping(value = "Deleteorder")
	public String DeleteOrderId(
			@RequestParam(value = "orderId", required = false, defaultValue = "默认") String str,HttpSession session,Model model) throws IOException {
		adminService.deleteorder(str);
		return "redirect:/order_admin.html";
	}
	/*鍒犻櫎鍟嗗搧绫诲瀷*/
	@RequestMapping(value = "DeleteItemType")
	public String DeleteItemTypeId(
			@RequestParam(value = "ItemTypeId", required = false, defaultValue = "默认") String str,HttpSession session,Model model) throws IOException {
		adminService.deleteItemType(str);
		return "redirect:/ItemType_admin.html";
	}
	//鍒犻櫎鍟嗗搧
	@RequestMapping(value = "DeleteItem")
	public String DeleteItemId(
			@RequestParam(value = "ItemNo", required = false, defaultValue = "默认") String str,HttpSession session,Model model) throws IOException {
		adminService.deleteItem(str);
		return "redirect:/main_admin.html";
	}
	/*鏇存敼鍟嗗搧*/
	@RequestMapping(value = "toUpdateItem")
	public String UpdateItemId(Model model,
			@RequestParam(value = "ItemNo", required = false, defaultValue = "默认") String str,HttpSession session) throws IOException {
		model.addAttribute("Id",str);
		List<ItemClass> itemClasses = adminService.getItemClasses();
		model.addAttribute("itemClasses", itemClasses);
		return "UpdateItem";
	}
	@RequestMapping(value = "/UpdateItem.html", method = RequestMethod.POST)
	public String UpdateItem(@RequestParam String cnameId,@RequestParam String cname1,@RequestParam String cname2,@RequestParam String cname3,@RequestParam String cname4,@RequestParam String cname5,
			HttpServletRequest request, HttpSession session) throws IOException, Exception {
		Item items = new Item();
		items.setItemId(cnameId);
		items.setItemName(cname1);
		items.setPeiceNow(Double.valueOf( cname2));
		items.setPriceOld(Double.valueOf( cname2));
		items.setStock(Integer.valueOf(cname3) );
		items.setPicture(cname5);
		items.setItemType(cname4);
		adminService.updateItem(items);
		return "redirect:/main_admin.html";
	}
	/*璇︽儏淇℃伅*/
	@RequestMapping(value = "Detail")
	public String Detail(Model model,@RequestParam(value = "itemId", required = false, defaultValue = "默认") String str,HttpSession session) throws IOException {
		List<Item> items = adminService.getItemsById(str);
		model.addAttribute("list",items);
		System.out.println("##########################\n\n");
		System.out.println(items.get(0).getPicture());
		return "DetailItem";
	}
}
