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

import banThuCung.Entities.CateColor;
import banThuCung.adminService.CateColorServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/san-pham/loai-mau")
public class CateColorController {
	@Autowired
	CateColorServiceImp cateColorService = new CateColorServiceImp();
	
	@RequestMapping("/cateColorForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("cateColor", new CateColor());
		session.setAttribute("errorDelCateColorMessage", null);
        mv.setViewName("admin/CateColorForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("cateColor") CateColor cateColor){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	cateColorService.updateCateColor(cateColor);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-mau/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.setViewName("admin/CateColorForm");
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
			cateColorService.deleteCateColor(id);	
			session.setAttribute("errorDelCateColorMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelCateColorMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/san-pham/loai-mau/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<CateColor> cateColors =  cateColorService.getAllCateColors(); 
		mv.addObject("cateColorList", cateColors);
		mv.setViewName("admin/CateColorList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("cateColor") CateColor cateColor,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	cateColorService.createCateColor(cateColor);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-mau/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			cateColor.setColor_id(null);
			mv.addObject("cateColor", cateColor);
			mv.setViewName("admin/CateColorForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        CateColor cateColor=cateColorService.getCateColorByID(id);    
        session.setAttribute("errorDelCateColorMessage", null);
        mv.addObject("cateColor", cateColor);
        mv.setViewName("admin/CateColorForm");
        return mv;    
    }  
}
