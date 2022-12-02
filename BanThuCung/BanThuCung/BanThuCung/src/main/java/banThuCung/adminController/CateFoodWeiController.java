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

import banThuCung.Entities.CateFoodWei;
import banThuCung.adminService.CateFoodWeiServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/san-pham/loai-can-nang-thuc-an")
public class CateFoodWeiController {
	@Autowired
	CateFoodWeiServiceImp cateFoodWeiService = new CateFoodWeiServiceImp();
	
	@RequestMapping("/cateFoodWeiForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("cateFoodWei", new CateFoodWei());
		session.setAttribute("errorDelCateFoodWeiMessage", null);
        mv.setViewName("admin/CateFoodWeiForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("cateFoodWei") CateFoodWei cateFoodWei){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	cateFoodWeiService.updateCateFoodWei(cateFoodWei);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-can-nang-thuc-an/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.setViewName("admin/CateFoodWeiForm");
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
			cateFoodWeiService.deleteCateFoodWei(id);	
			session.setAttribute("errorDelCateFoodWeiMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelCateFoodWeiMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/san-pham/loai-can-nang-thuc-an/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<CateFoodWei> cateFoodWeis =  cateFoodWeiService.getAllCateFoodWeis(); 
		mv.addObject("cateFoodWeiList", cateFoodWeis);
		mv.setViewName("admin/CateFoodWeiList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("cateFoodWei") CateFoodWei cateFoodWei,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	cateFoodWeiService.createCateFoodWei(cateFoodWei);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-can-nang-thuc-an/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			cateFoodWei.setFoodwei_id(null);
			mv.addObject("cateFoodWei", cateFoodWei);
			mv.setViewName("admin/CateFoodWeiForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        CateFoodWei cateFoodWei=cateFoodWeiService.getCateFoodWeiByID(id);    
        session.setAttribute("errorDelCateFoodWeiMessage", null);
        mv.addObject("cateFoodWei", cateFoodWei);
        mv.setViewName("admin/CateFoodWeiForm");
        return mv;    
    }  
}
