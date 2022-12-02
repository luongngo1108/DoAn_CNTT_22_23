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

import banThuCung.Entities.CateMaterial;
import banThuCung.adminService.CateMaterialServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/san-pham/loai-nguyen-lieu")
public class CateMaterialController {
	@Autowired
	CateMaterialServiceImp cateMaterialService = new CateMaterialServiceImp();
	
	@RequestMapping("/cateMaterialForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("cateMaterial", new CateMaterial());
		session.setAttribute("errorDelCateMaterialMessage", null);
        mv.setViewName("admin/CateMaterialForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("cateMaterial") CateMaterial cateMaterial){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	cateMaterialService.updateCateMaterial(cateMaterial);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-nguyen-lieu/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.setViewName("admin/CateMaterialForm");
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
			cateMaterialService.deleteCateMaterial(id);	
			session.setAttribute("errorDelCateMaterialMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelCateMaterialMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/san-pham/loai-nguyen-lieu/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<CateMaterial> cateMaterials =  cateMaterialService.getCateMaterials(); 
		mv.addObject("cateMaterialList", cateMaterials);
		mv.setViewName("admin/CateMaterialList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("cateMaterial") CateMaterial cateMaterial,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
        	cateMaterialService.createCateMaterial(cateMaterial);
        	mv.setViewName("redirect:/quan-tri/san-pham/loai-nguyen-lieu/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			cateMaterial.setMaterial_id(null);
			mv.addObject("cateMaterial", cateMaterial);
			mv.setViewName("admin/CateMaterialForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        CateMaterial cateMaterial=cateMaterialService.getCateMaterialByID(id);    
        session.setAttribute("errorDelCateMaterialMessage", null);
        mv.addObject("cateMaterial", cateMaterial);
        mv.setViewName("admin/CateMaterialForm");
        return mv;    
    }  
}
