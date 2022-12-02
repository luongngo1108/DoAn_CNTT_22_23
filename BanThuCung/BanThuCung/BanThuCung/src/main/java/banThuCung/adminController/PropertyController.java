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

import banThuCung.Entities.Property;
import banThuCung.adminService.CateColorServiceImp;
import banThuCung.adminService.CateFoodFlaServiceImp;
import banThuCung.adminService.CateFoodWeiServiceImp;
import banThuCung.adminService.CateMaterialServiceImp;
import banThuCung.adminService.CatePetWeiServiceImp;
import banThuCung.adminService.PropertyServiceImp;

@Controller
@RequestMapping(value = "/quan-tri/san-pham/thuoc-tinh")
public class PropertyController {
	@Autowired
	PropertyServiceImp propertyService = new PropertyServiceImp();
	
	@Autowired
	CatePetWeiServiceImp catePetWeiService = new CatePetWeiServiceImp();
	
	@Autowired
	CateColorServiceImp cateColorService = new CateColorServiceImp();
	
	@Autowired
	CateFoodWeiServiceImp cateFoodWeiService = new CateFoodWeiServiceImp();
	
	@Autowired
	CateFoodFlaServiceImp cateFoodFlaService  = new CateFoodFlaServiceImp();
	
	@Autowired
	CateMaterialServiceImp cateMaterialService = new CateMaterialServiceImp();
	
	@RequestMapping("/propertyForm")    
    public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		mv.addObject("property", new Property());
		mv.addObject("petweiList", catePetWeiService.getCatePetWeis());
		mv.addObject("colorList", cateColorService.getAllCateColors());
		mv.addObject("foodweiList",cateFoodWeiService.getAllCateFoodWeis());
		mv.addObject("foodflaList",cateFoodFlaService.getAllCateFoodFlas());
		mv.addObject("materialList",cateMaterialService.getCateMaterials());
		session.setAttribute("errorDelPropertyMessage", null);
        mv.setViewName("admin/PropertyForm");

        return mv;   
    } 
	
	@RequestMapping( value="/update",method = RequestMethod.POST)    
    public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("property") Property property){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        try {
        	if(property.getColor_id().equals("null")) property.setColor_id(null);
        	if(property.getFoodfla_id().equals("null")) property.setFoodfla_id(null);
        	if(property.getFoodwei_id().equals("null")) property.setFoodwei_id(null);
        	if(property.getPetwei_id().equals("null")) property.setPetwei_id(null);
        	if(property.getMaterial_id().equals("null")) property.setMaterial_id(null);
        	propertyService.updateProperty(property);
        	mv.setViewName("redirect:/quan-tri/san-pham/thuoc-tinh/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.setViewName("admin/PropertyForm");
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
			propertyService.deleteProperty(id);	
			session.setAttribute("errorDelPropertyMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa " + id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelPropertyMessage", errorString);
		}
		
		mv.setViewName("redirect:/quan-tri/san-pham/thuoc-tinh/list");
		return mv;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<Property> propertyList =  propertyService.getAllProperties(); 
		mv.addObject("propertyList", propertyList);
		mv.addObject("petweiList", catePetWeiService.getCatePetWeis());
		mv.addObject("colorList", cateColorService.getAllCateColors());
		mv.addObject("foodweiList",cateFoodWeiService.getAllCateFoodWeis());
		mv.addObject("foodflaList",cateFoodFlaService.getAllCateFoodFlas());
		mv.addObject("materialList",cateMaterialService.getCateMaterials());
		mv.setViewName("admin/PropertyList");
		return mv;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("property") Property property,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		try {
			if(property.getColor_id().equals("null")) property.setColor_id(null);
        	if(property.getFoodfla_id().equals("null")) property.setFoodfla_id(null);
        	if(property.getFoodwei_id().equals("null")) property.setFoodwei_id(null);
        	if(property.getPetwei_id().equals("null")) property.setPetwei_id(null);
        	if(property.getMaterial_id().equals("null")) property.setMaterial_id(null);
        	propertyService.createProperty(property);
        	mv.setViewName("redirect:/quan-tri/san-pham/thuoc-tinh/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			property.setProper_id(null);
			mv.addObject("property", property);
			mv.addObject("petweiList", catePetWeiService.getCatePetWeis());
			mv.addObject("colorList", cateColorService.getAllCateColors());
			mv.addObject("foodweiList",cateFoodWeiService.getAllCateFoodWeis());
			mv.addObject("foodflaList",cateFoodFlaService.getAllCateFoodFlas());
			mv.addObject("materialList",cateMaterialService.getCateMaterials());
			mv.setViewName("admin/PropertyForm");
		}  
		return mv;
	}
	
	@RequestMapping(value="/edit/{id}")    
    public ModelAndView edit(HttpSession session, @PathVariable String id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
        Property property=propertyService.getPropertyByID(id); 
        session.setAttribute("errorDelPropertyMessage", null);
        mv.addObject("property", property);
        mv.addObject("petweiList", catePetWeiService.getCatePetWeis());
		mv.addObject("colorList", cateColorService.getAllCateColors());
		mv.addObject("foodweiList",cateFoodWeiService.getAllCateFoodWeis());
		mv.addObject("foodflaList",cateFoodFlaService.getAllCateFoodFlas());
		mv.addObject("materialList",cateMaterialService.getCateMaterials());
        mv.setViewName("admin/PropertyForm");
        return mv;    
    }  
}
