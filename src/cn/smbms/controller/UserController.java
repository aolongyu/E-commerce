package cn.smbms.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.smbms.pojo.Announce;
import cn.smbms.pojo.CartSon;
import cn.smbms.pojo.Item;
import cn.smbms.pojo.Order;
import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	UserService userService;

	@RequestMapping(value = "/login.html")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/logout.html")
	public String logout(HttpSession session) {
		session.removeAttribute(Constants.USER_SESSION);
		session.removeAttribute(Constants.USER_ID);
		return "redirect:/user/main_no.html";
	}

	@RequestMapping(value = "/dologin.html", method = RequestMethod.POST)
	public String doLogin(@RequestParam String username, @RequestParam String userpwd, @RequestParam String code,
			HttpServletRequest request, HttpSession session) throws IOException, Exception {
		User user = userService.getLoginUser(username, userpwd);
		String randStr = (String) request.getSession().getAttribute("randStr");
		if (!code.equalsIgnoreCase("123")) {
			request.setAttribute("error", "(验证码错误)");
			return "login";
		}
		if (null != user) {
			session.setAttribute(Constants.USER_SESSION, user);
			return "redirect:/user/main_user.html";
		} else {
			request.setAttribute("error", "(用户名或密码错误)");
			return "login";
		}
	}

	@RequestMapping(value = "/main_user.html")
	public String main_user(Model model, @RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "name_item", required = false) String name_item, HttpServletRequest request,
			HttpSession session) throws IOException, Exception {

		List<Announce> annoList = null;
		List<Item> itemList = null;

		if (title == null) {
			title = "";
		}
		if (type == null) {
			type = "";
		}
		if (name_item == null) {
			name_item = "";
		}

		annoList = userService.getAnnoList(title);
		itemList = userService.getItemList(type, name_item);

		System.out.println("\n\nitemList:" + itemList + "\n\n");

		model.addAttribute("annoList", annoList);
		model.addAttribute("itemList", itemList);

		model.addAttribute("title", title);
		model.addAttribute("type", type);
		model.addAttribute("name_item", name_item);

		return "user/main_user";
	}
	
	@RequestMapping(value = "/main_no.html")
	public String main_no(Model model, @RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "name_item", required = false) String name_item, HttpServletRequest request,
			HttpSession session) throws IOException, Exception {

		List<Announce> annoList = null;
		List<Item> itemList = null;

		if (title == null) {
			title = "";
		}
		if (type == null) {
			type = "";
		}
		if (name_item == null) {
			name_item = "";
		}

		annoList = userService.getAnnoList(title);
		itemList = userService.getItemList(type, name_item);

		System.out.println("\n\nitemList:" + itemList + "\n\n");

		model.addAttribute("annoList", annoList);
		model.addAttribute("itemList", itemList);

		model.addAttribute("title", title);
		model.addAttribute("type", type);
		model.addAttribute("name_item", name_item);

		return "main_no";
	}

	@RequestMapping(value = "/user_center.html")
	public String user_center(HttpSession session) {
		return "user/user_center";
	}

	@RequestMapping(value = "/user_modifyMail.html")
	public String user_modifyMail(@RequestParam String newEmail, HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute(Constants.USER_SESSION);
		try {
			userService.modifyEmail(user.getUserId(), newEmail);
			user.setEmail(newEmail);
			session.setAttribute(Constants.USER_SESSION, user);
		} catch (Exception e) {
			return "redirect:/user/syserror.html";
		}
		return "redirect:/user/user_center.html";
	}

	@RequestMapping(value = "/user_modifyPassword.html")
	public String user_modifyPassword(@RequestParam String pwd1, @RequestParam String pwd2, @RequestParam String pwd3,
			HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute(Constants.USER_SESSION);
		if (pwd2.equals(pwd3) && pwd1.equals(user.getUserPwd())) {
			try {
				userService.modifyPassword(user.getUserId(), pwd2);
			} catch (Exception e) {
				return "redirect:/user/syserror.html";
			}
			return "redirect:/user/user_center.html";
		} else {
			return "redirect:/user/syserror.html";
		}
	}

	@RequestMapping(value = "/syserror.html")
	public String sysError() {
		return "/user/syserror";
	}

	@RequestMapping(value = "/cartList.html")
	public String getUserList(Model model, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "pageIndex", required = false) String pageIndex, HttpServletRequest request,
			HttpSession session) throws Exception {
		List<CartSon> cartList = null;
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;

		if (name == null) {
			name = "";
		}

		if (pageIndex != null) {
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (NumberFormatException e) {
				return "redirect:/user/syserror.html";
			}
		}
		User user = (User) session.getAttribute(Constants.USER_SESSION);
		// 总条数
		int totalCount = userService.getCartCount(user.getUserId(), name);
		System.out
				.println("\n\nuserId:" + user.getUserId() + " # name:" + name + " # totalCount:" + totalCount + "\n\n");
		// 总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		// 控制首页和尾页
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		cartList = userService.getCartList(user.getUserId(), name, currentPageNo, pageSize);

		model.addAttribute("cartList", cartList);
		model.addAttribute("queryCartName", name);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "/user/user_cart";
	}

	@RequestMapping(value = "/modifyBuyNum.html")
	public String modifyBuyNum(@RequestParam(value = "num") int num, @RequestParam(value = "cartId") String cartId)
			throws Exception {

		userService.modifyBuyNum(cartId, num);
		return "redirect:/user/cartList.html";
	}

	@RequestMapping(value = "/deleteCart.html")
	public String deleteCart(@RequestParam(value = "cartId") String cartId) throws Exception {
		userService.deleteCart(cartId);
		return "redirect:/user/cartList.html";
	}

	@RequestMapping(value = "/orderList.html")
	public String orderList(Model model, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "pageIndex", required = false) String pageIndex, HttpServletRequest request,
			HttpSession session) throws Exception {
		User user = (User) session.getAttribute(Constants.USER_SESSION);

		List<Order> orderList = null;
		orderList = userService.getOrderList(user.getUserId());

		model.addAttribute("orderList", orderList);

		return "/user/user_order";
	}

	@RequestMapping(value = "/deleteOrder.html")
	public String deleteOrder(@RequestParam(value = "orderId") String orderId) throws Exception {

		System.out.println("\n\norderID:" + orderId + "\n\n");

		userService.deleteOrder(orderId);
		return "redirect:/user/orderList.html";
	}

	@RequestMapping(value = "/addCart.html")
	public String addCart(@RequestParam(value = "itemId") String itemId, HttpServletRequest request,
			HttpSession session) throws Exception {

		System.out.println("\n\nitemId:" + itemId + "\n\n");

		User user = (User) session.getAttribute(Constants.USER_SESSION);

		userService.addCart(user.getUserId(), itemId, user.getUserId() + itemId);
		return "redirect:/user/main_user.html";
	}

	@RequestMapping(value = "/addOrder.html")
	public String buyItem(@RequestParam(value = "cartId") String cartId,
			@RequestParam(value = "orderPrice") String orderPrice, @RequestParam(value = "buyNum") int buynum,
			HttpServletRequest request, HttpSession session) throws Exception {

		System.out.println("\n\ncartID:" + cartId + "\n\n");

		User user = (User) session.getAttribute(Constants.USER_SESSION);

		userService.addOrder(user.getUserId(), cartId, orderPrice, buynum);
		userService.deleteCart(cartId);
		
		return "redirect:/user/cartList.html";
	}
}
