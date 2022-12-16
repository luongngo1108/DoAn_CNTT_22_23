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

import banThuCung.Entities.CateFoodFla;
import banThuCung.adminService.CateFoodFlaServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/san-pham/loai-huong-vi")
public class CateFoodFlaController {
	@Autowired
	CateFoodFlaServiceImp cateFoodFlaService = new CateFoodFlaServiceImp();
	
	@RequestMapping("/cateFoodFlaForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("cateFoodFla", new CateFoodFla());
		session.setAttribute("errorDelCateFoodFlaMessage", null);
        mv.setViewName("admin/CateFoodFlaForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("cateFoodFla") CateFoodFla cateFoodFla){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	cateFoodFlaService.updateCateFoodFla(cateFoodFla);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-huong-vi/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.setViewName("admin/CateFoodFlaForm");
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
			cateFoodFlaService.deleteCateFoodFla(id);	
			session.setAttribute("errorDelCateFoodFlavorMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelCateFoodFlaMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/san-pham/loai-huong-vi/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<CateFoodFla> cateFoodFlas =  cateFoodFlaService.getAllCateFoodFlas(); 
		mv.addObject("cateFoodFlaList", cateFoodFlas);
		mv.setViewName("admin/CateFoodFlaList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("cateFoodFla") CateFoodFla cateFoodFla,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	cateFoodFlaService.createCateFoodFla(cateFoodFla);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-huong-vi/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			cateFoodFla.setFoodfla_id(null);
			mv.addObject("cateFoodFla", cateFoodFla);
			mv.setViewName("admin/CateFoodFlaForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        CateFoodFla cateFoodFla=cateFoodFlaService.getCateFoodFlaByID(id);    
        session.setAttribute("errorDelCateFoodFlaMessage", null);
        mv.addObject("cateFoodFla", cateFoodFla);
        mv.setViewName("admin/CateFoodFlaForm");
        return mv;    
    }  
}
