package banThuCung.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import banThuCung.Entities.Accounts;
import banThuCung.adminService.AccountServiceImpAd;

@Controller
@RequestMapping(value = "/quan-tri/tai-khoan")
public class AccountControllerAd {
	@Autowired
	AccountServiceImpAd accountService = new AccountServiceImpAd();
	
	@RequestMapping("admin/accountForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		session.setAttribute("errorDelUserMessage", null);
		Accounts admin = (Accounts)session.getAttribute("admin_acc");
		mv.addObject("admin", admin);
        mv.setViewName("admin/AccountForm");
        return mv;   
    } 
	
	@RequestMapping( value="/admin/update",method = RequestMethod.POST)    
    public ModelAndView saveAdmin(HttpSession session, ModelAndView mv, @ModelAttribute("admin") Accounts account){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	accountService.updateAccount(account);
        	String change = "Đã thay đổi thành công! Xin vui lòng đăng nhập lại!";
        	session.setAttribute("AdChangeSuccess", change);
        	mv.setViewName("redirect:/quan-tri/dang-nhap");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			Accounts admin = (Accounts)session.getAttribute("admin_acc");
			mv.addObject("admin", admin);
			mv.setViewName("admin/AccountForm");
		}  
        return mv;    
    } 
	
	@RequestMapping(value = "/nguoi-dung/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<Accounts> accounts =  accountService.getCusAccounts(); 
		mv.addObject("accountList", accounts);
		mv.setViewName("admin/AccountList");
		return mv;
	}
	
	@RequestMapping(value="/nguoi-dung/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        Accounts account=accountService.getAccountsByID(id);    
        session.setAttribute("errorDelUserMessage", null);
        mv.addObject("user", account);
        mv.setViewName("admin/AccountForm");
        return mv;    
    }
	
	@RequestMapping(value="/nguoi-dung/update",method = RequestMethod.POST)    
    public ModelAndView saveUser(HttpSession session, ModelAndView mv, @ModelAttribute("account") Accounts account){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	accountService.updateAccount(account);
        	mv.setViewName("redirect:/quan-tri/tai-khoan/nguoi-dung/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.addObject("user",account);
			mv.setViewName("admin/AccountForm");
		}  
        return mv;    
    }
	
	@RequestMapping(value = "/nguoi-dung/delete/{id}") 
	public ModelAndView delete(HttpSession session, @PathVariable String id, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
			accountService.deleteAccount(id);	
			session.setAttribute("errorDelUserMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelUserMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/tai-khoan/nguoi-dung/list");
		return mv;
	}
}
