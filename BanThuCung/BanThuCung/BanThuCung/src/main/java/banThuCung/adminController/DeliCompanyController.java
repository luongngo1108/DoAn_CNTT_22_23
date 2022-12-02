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

import banThuCung.Entities.DeliCompany;
import banThuCung.adminService.DeliCompanyServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/don-hang/cong-ty-van-chuyen")
public class DeliCompanyController {
	@Autowired
	DeliCompanyServiceImp deliCompanyService = new DeliCompanyServiceImp();
	
	@RequestMapping("/deliCompanyForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("deliCompany", new DeliCompany());
		session.setAttribute("errorDelDeliCompanyMessage", null);
        mv.setViewName("admin/DeliCompanyForm");
        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("deliCompany") DeliCompany deliCompany){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	deliCompanyService.updateDeliCompany(deliCompany);
        	mv.setViewName("redirect:/quan-tri/don-hang/cong-ty-van-chuyen/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.setViewName("admin/DeliCompanyForm");
		}  
        return mv;    
    } 
	
	@RequestMapping(value = "/delete/{id}") 
	public ModelAndView delete(HttpSession session, @PathVariable String id, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
			deliCompanyService.deleteDeliCompany(id);	
			session.setAttribute("errorDelDeliCompanyMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelDeliCompanyMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/don-hang/cong-ty-van-chuyen/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<DeliCompany> deliCompanies =  deliCompanyService.getDeliCompanies(); 
		mv.addObject("deliCompanyList", deliCompanies);
		mv.setViewName("admin/DeliCompanyList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("deliCompany") DeliCompany deliCompany,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	deliCompanyService.createDeliCompany(deliCompany);
        	mv.setViewName("redirect:/quan-tri/don-hang/cong-ty-van-chuyen/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			deliCompany.setDeli_com_id(null);
			mv.addObject("deliCompany", deliCompany);
			mv.setViewName("admin/DeliCompanyForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        DeliCompany deliCompany=deliCompanyService.getDeliCompanyByID(id); 
        session.setAttribute("errorDelDeliCompanyMessage", null);
        mv.addObject("deliCompany", deliCompany);
        mv.setViewName("admin/DeliCompanyForm");
        return mv;    
    }  
}
