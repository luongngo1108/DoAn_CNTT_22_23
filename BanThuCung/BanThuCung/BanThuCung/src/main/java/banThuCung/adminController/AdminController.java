package banThuCung.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import banThuCung.Dto.ProductsDto;
import banThuCung.Entities.Accounts;
import banThuCung.adminService.AccountServiceImpAd;
import banThuCung.adminService.OrderServiceImp;
import banThuCung.adminService.ProductServiceImpAd;

@Controller
@RequestMapping(value = "/quan-tri")
public class AdminController {
	@Autowired
	AccountServiceImpAd accountService = new AccountServiceImpAd();
	
	@Autowired
	OrderServiceImp orderService = new OrderServiceImp();
	
	@Autowired
	ProductServiceImpAd productService = new ProductServiceImpAd();
	
	@RequestMapping(value = {""}, method = RequestMethod.GET) 
	public ModelAndView CatchLogin1(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") == "yes")  {
			mv.setViewName("redirect:/quan-tri/trang-chu");
			return mv;
		}
		mv.setViewName("redirect:quan-tri/dang-nhap");
		return mv;
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET) 
	public ModelAndView CatchLogin2(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") == "yes")  {
			mv.setViewName("redirect:/quan-tri/trang-chu");
			return mv;
		}
		mv.setViewName("redirect:dang-nhap");
		return mv;
	}
	
	@RequestMapping(value = {"/dang-nhap"}, method = RequestMethod.GET) 
	public ModelAndView NoLoginFirst(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("admin_acc", new Accounts());
		session.setAttribute("errorDelSupMessage", null);
		session.setAttribute("errorDelCateMessage", null);
		session.setAttribute("errorDelCateColorMessage", null);
		session.setAttribute("errorDelCateFoodFlaMessage", null);
		session.setAttribute("errorDelCatePetWeiMessage", null);
		session.setAttribute("errorDelCateFoodWeiMessage", null);
		session.setAttribute("errorDelPropertyMessage", null);
		session.setAttribute("errorDelProductMessage", null);
		session.setAttribute("errorDelDeliCompanyMessage", null);
		session.setAttribute("errorDelDeliServiceMessage", null);
		session.setAttribute("errorDelOrderMessage", null);
		session.setAttribute("errorDelOrderDetailMessage", null);
		mv.setViewName("admin/signin");
		return mv;
	}
	
	@RequestMapping(value = {"/dang-nhap"}, method = RequestMethod.POST) 
	public ModelAndView Login(HttpSession session, @ModelAttribute("admin_acc") Accounts admin_acc) {
		ModelAndView mv = new ModelAndView();
		//
		boolean check = accountService.checkAccount(admin_acc);
		Accounts LoggedInAdminAcc = accountService.getAdminAcc(admin_acc);
		int order_num = orderService.totalOrder();
		int acc_num = accountService.countAccount();
		int total_revenue = orderService.totalRevenue();
		List<ProductsDto> bestSoldList = productService.getBestSoldPro().subList(0, 5);
		if(check) { 
			mv.addObject("status", "Đăng nhập thành công!");
			session.setAttribute("status", admin_acc);
			session.setAttribute("admin_acc", LoggedInAdminAcc);
			session.setAttribute("trueLogin", "yes");
			session.setAttribute("total_od", order_num);
			session.setAttribute("total_acc", acc_num);
			session.setAttribute("total_revenue", total_revenue);
			session.setAttribute("bestSoldList", bestSoldList);
			mv.setViewName("redirect:trang-chu");
		}
		else { 
			mv.addObject("status", "Đăng nhập thất bại!");
			mv.setViewName("admin/signin");
		}
		return mv;
	}
	
	@RequestMapping(value = {"/trang-chu"}, method = RequestMethod.GET) 
	public ModelAndView Index1(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String check = (String)session.getAttribute("trueLogin");
		int order_num = orderService.totalOrder();
		int acc_num = accountService.countAccount();
		int total_revenue = orderService.totalRevenue();
		List<ProductsDto> bestSoldList = productService.getBestSoldPro().subList(0, 5);
		if(check == "yes") {
			mv.setViewName("admin/index");
			session.setAttribute("total_od", order_num);
			session.setAttribute("total_acc", acc_num);
			session.setAttribute("total_revenue", total_revenue);
			session.setAttribute("bestSoldList", bestSoldList);
		}
		else {
			mv.setViewName("redirect:dang-nhap");
		}
		return mv;
	}
	
	@RequestMapping(value = {"/trang-chu/"}, method = RequestMethod.GET) 
	public ModelAndView Index2(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String check = (String)session.getAttribute("trueLogin");
		int order_num = orderService.totalOrder();
		int acc_num = accountService.countAccount();
		int total_revenue = orderService.totalRevenue();
		List<ProductsDto> bestSoldList = productService.getBestSoldPro().subList(0, 5);
		if(check == "yes") {
			mv.setViewName("admin/index");
			session.setAttribute("total_od", order_num);
			session.setAttribute("total_acc", acc_num);
			session.setAttribute("total_revenue", total_revenue);
			session.setAttribute("bestSoldList", bestSoldList);
		}
		else {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
		}
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
	    if (session != null) {
	        session.invalidate();
	    }
	    return "redirect:/quan-tri/dang-nhap"; 
	}
}
