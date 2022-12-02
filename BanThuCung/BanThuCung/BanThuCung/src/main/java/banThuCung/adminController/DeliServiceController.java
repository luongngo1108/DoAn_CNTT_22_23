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

import banThuCung.Entities.DeliService;
import banThuCung.adminService.DeliCompanyServiceImp;
import banThuCung.adminService.DeliServiceServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/don-hang/dich-vu-van-chuyen")
public class DeliServiceController {
	@Autowired
	DeliServiceServiceImp deliServiceService = new DeliServiceServiceImp();
	
	@Autowired
	DeliCompanyServiceImp deliCompanyService = new DeliCompanyServiceImp();
	
	@RequestMapping("/deliServiceForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("deliService", new DeliService());
		mv.addObject("deliCompanyList", deliCompanyService.getDeliCompanies());
		session.setAttribute("errorDelDeliServiceMessage", null);
        mv.setViewName("admin/DeliServiceForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("deliService") DeliService deliService){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	deliServiceService.updateDeliService(deliService);
        	System.out.println(deliService.getDeli_com_id());
        	System.out.println(deliService.getDeli_ser_id());
        	System.out.println(deliService.getTime());
        	mv.setViewName("redirect:/quan-tri/don-hang/dich-vu-van-chuyen/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.addObject("deliCompanyList", deliCompanyService.getDeliCompanies());
			mv.setViewName("admin/DeliServiceForm");
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
			deliServiceService.deleteDeliService(id);	
			session.setAttribute("errorDelDeliServiceMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelDeliServiceMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/don-hang/dich-vu-van-chuyen/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		List<DeliService> deliServices =  deliServiceService.getDeliServices(); 
		mv.addObject("deliServiceList", deliServices);
		mv.setViewName("admin/DeliServiceList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("deliService") DeliService deliService,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	deliServiceService.createDeliService(deliService);
        	mv.setViewName("redirect:/quan-tri/don-hang/dich-vu-van-chuyen/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			deliService.setDeli_ser_id(null);
			mv.addObject("deliService", deliService);
			mv.addObject("deliCompanyList", deliCompanyService.getDeliCompanies());
			mv.setViewName("admin/DeliServiceForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        DeliService deliService=deliServiceService.getDeliServiceByID(id); 
        session.setAttribute("errorDelDeliServiceMessage", null);
        mv.addObject("deliService", deliService);
        mv.addObject("deliCompanyList", deliCompanyService.getDeliCompanies());
        mv.setViewName("admin/DeliServiceForm");
        return mv;    
    }  
}
