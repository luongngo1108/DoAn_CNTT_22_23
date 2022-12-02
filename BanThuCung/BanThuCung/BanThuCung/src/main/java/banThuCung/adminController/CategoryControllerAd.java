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

import banThuCung.Entities.Categories;
import banThuCung.adminService.CategoryServcieImpAd;

@Controller
@RequestMapping(value = "/quan-tri/san-pham/kieu-san-pham")
public class CategoryControllerAd {
	@Autowired
	CategoryServcieImpAd categoryServcie = new CategoryServcieImpAd();
	
	@RequestMapping("/categoryForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("category", new Categories());
		session.setAttribute("errorDelCateMessage", null);
        mv.setViewName("admin/CategoryForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("category") Categories category){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	categoryServcie.updateCategory(category);
        	mv.setViewName("redirect:/quan-tri/san-pham/kieu-san-pham/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.setViewName("admin/CategoryForm");
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
			categoryServcie.deleteCategory(id);	
			session.setAttribute("errorDelCateMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelCateMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/san-pham/kieu-san-pham/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<Categories> categoriesList =  categoryServcie.getAllCategories(); 
		mv.addObject("categoryList", categoriesList);
		mv.setViewName("admin/CategoryList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("category") Categories category,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	categoryServcie.createCategory(category);
        	mv.setViewName("redirect:/quan-tri/san-pham/kieu-san-pham/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			category.setCat_id(null);
			mv.addObject("category", category);
			mv.setViewName("admin/CategoryForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        Categories category=categoryServcie.getCategoryByID(id);   
        session.setAttribute("errorDelCateMessage", null);
        mv.addObject("category", category);
        mv.setViewName("admin/CategoryForm");
        return mv;    
    }  
}
