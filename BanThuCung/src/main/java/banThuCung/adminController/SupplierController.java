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

import banThuCung.Entities.Supplier;
import banThuCung.adminService.SupplierServcieImp;

@Controller
@RequestMapping(value = "/quan-tri/san-pham/nha-phan-phoi")
public class SupplierController {
	@Autowired
	SupplierServcieImp supplierServcie = new SupplierServcieImp();
	
	@RequestMapping("/supplierForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("supplier", new Supplier());
		session.setAttribute("errorDelSupMessage", null);
        mv.setViewName("admin/SupplierForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("supplier") Supplier supplier){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	supplierServcie.updateSupplier(supplier);
        	mv.setViewName("redirect:/quan-tri/san-pham/nha-phan-phoi/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.setViewName("admin/SupplierForm");
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
			supplierServcie.deleteSupplier(id);	
			session.setAttribute("errorDelSupMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelSupMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/san-pham/nha-phan-phoi/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<Supplier> supplierList =  supplierServcie.getAllSuppliers(); 
		mv.addObject("supplierList", supplierList);
		mv.setViewName("admin/SupplierList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("supplier") Supplier supplier,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	supplierServcie.createSupplier(supplier);
        	mv.setViewName("redirect:/quan-tri/san-pham/nha-phan-phoi/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			supplier.setSup_id(null);
			mv.addObject("supplier", supplier);
			mv.setViewName("admin/SupplierForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        Supplier supplier=supplierServcie.getSupplierByID(id); 
        session.setAttribute("errorDelSupMessage", null);
        mv.addObject("supplier", supplier);
        mv.setViewName("admin/SupplierForm");
        return mv;    
    }  
}
