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

import banThuCung.Entities.CatePetWei;
import banThuCung.adminService.CatePetWeiServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/san-pham/loai-can-nang-thu-cung")
public class CatePetWeiController {
	@Autowired
	CatePetWeiServiceImp catePetWeiService = new CatePetWeiServiceImp();
	
	@RequestMapping("/catePetWeiForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("catePetWei", new CatePetWei());
		session.setAttribute("errorDelCatePetWeiMessage", null);
        mv.setViewName("admin/CatePetWeiForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("catePetWei") CatePetWei catePetWei){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	catePetWeiService.updateCatePetWei(catePetWei);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-can-nang-thu-cung/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.setViewName("admin/CatePetWeiForm");
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
			catePetWeiService.deleteCatePetWei(id);	
			session.setAttribute("errorDelCatePetWeiMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelCatePetWeiMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/san-pham/loai-can-nang-thu-cung/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<CatePetWei> catePetWeis =  catePetWeiService.getCatePetWeis(); 
		mv.addObject("catePetWeiList", catePetWeis);
		mv.setViewName("admin/CatePetWeiList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("catePetWei") CatePetWei catePetWei,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	catePetWeiService.createCatePetWei(catePetWei);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-can-nang-thu-cung/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			catePetWei.setPetwei_id(null);
			mv.addObject("catePetWei", catePetWei);
			mv.setViewName("admin/CatePetWeiForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        CatePetWei catePetWei=catePetWeiService.getCatePetWeiByID(id);    
        session.setAttribute("errorDelCatePetWeiMessage", null);
        mv.addObject("catePetWei", catePetWei);
        mv.setViewName("admin/CatePetWeiForm");
        return mv;    
    }  
}
