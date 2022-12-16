package banThuCung.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import banThuCung.adminService.CateColorServiceImp;
import banThuCung.adminService.CateFoodFlaServiceImp;
import banThuCung.adminService.CateFoodWeiServiceImp;
import banThuCung.adminService.CateMaterialServiceImp;
import banThuCung.adminService.CatePetWeiServiceImp;
import banThuCung.userService.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {
	
	@Autowired
	private ProductServiceImpl _productService;
	
	@Autowired
	private CateColorServiceImp colorService;
	
	@Autowired
	private CateFoodWeiServiceImp foodweiService;
	
	@Autowired
	private CatePetWeiServiceImp petweiService;
	
	@Autowired
	private CateFoodFlaServiceImp foodflaService;
	
	@Autowired
	private CateMaterialServiceImp materialsService;
	
	@RequestMapping(value = {"chi-tiet-san-pham/{pro_id}"}) 
	public ModelAndView Index(@PathVariable String pro_id) {
		
		mvShare.setViewName("user/products/product");
		mvShare.addObject("product", _productService.GetProductByPro_ID(pro_id));
		
		String cat_id = _productService.GetProductByPro_ID(pro_id).getCat_id();
		mvShare.addObject("productsByCat_ID", _productService.GetProductsByCat_ID(cat_id));
		
		mvShare.addObject("color_type", colorService.getAllCateColors());
		mvShare.addObject("foodwei_type", foodweiService.getAllCateFoodWeis());
		mvShare.addObject("foodfla_type", foodflaService.getAllCateFoodFlas());
		mvShare.addObject("petwei_type", petweiService.getCatePetWeis());
		mvShare.addObject("materials_type", materialsService.getCateMaterials());
		
		return mvShare;
	}
}
