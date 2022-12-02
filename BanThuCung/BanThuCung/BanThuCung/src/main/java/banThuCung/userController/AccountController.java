package banThuCung.userController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import banThuCung.Entities.Accounts;
import banThuCung.userService.AccountServiceImpl;

@Controller
public class AccountController extends BaseController {

	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = {"/dang-ky"}, method = RequestMethod.GET) 
	public ModelAndView Register() {
		mvShare.setViewName("user/account/register");
		mvShare.addObject("account", new Accounts());
		return mvShare;
	}
	
	@RequestMapping(value = {"/dang-ky"}, method = RequestMethod.POST) 
	public ModelAndView CreateAccount(@ModelAttribute("account") Accounts account) {
		try {
			accountService.addAccount(account);
			mvShare.addObject("status", "Đăng kí tài khoản thành công");
		} catch (Exception e) {
			mvShare.addObject("status", "Email đã tồn tại!!!");
		}
		mvShare.setViewName("user/account/register");
		return mvShare;
	}
	
	@RequestMapping(value = {"/dang-nhap"}, method = RequestMethod.POST) 
	public ModelAndView Login(HttpSession session, @ModelAttribute("account") Accounts account) {
		account = accountService.checkAccount(account);
		
		if(account != null) {
			mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("loginInfo", account);
		}
		else {
			mvShare.addObject("statusLogin", "Đăng nhập thất bại");
		}
		return mvShare;
	}
	
	@RequestMapping(value = {"/dang-xuat"}, method = RequestMethod.GET) 
	public String Login(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		return "redirect:" + request.getHeader("Referer");
	}
}
