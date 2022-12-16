package banThuCung.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import banThuCung.Dto.PaginatesDto;
import banThuCung.userService.CategoryServiceImpl;
import banThuCung.userService.PaginatesServiceImpl;

@Controller
public class CategoryController extends BaseController{
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired
	private PaginatesServiceImpl paginatesService;
	
	private int totalPage = 9;
	
	@RequestMapping(value = {"/san-pham/{id}"}) 
	public ModelAndView Product(@PathVariable String id) {
		
		mvShare.setViewName("user/products/category");
		//mvShare.addObject("products_byCatID", categoryService.GetDataProductsByCat_ID(id));
		
		int totalData = categoryService.GetDataProductsByCat_ID(id).size();
		PaginatesDto paginatesInfo = paginatesService.GetInfoPaginates(totalData, totalPage, 1);
		mvShare.addObject("cat_id", id);
		mvShare.addObject("paginatesInfo", paginatesInfo);
		mvShare.addObject("productsPaginates", categoryService.GetDataProductsPaginates(id, paginatesInfo.getStart(), totalPage));
		
		return mvShare;
	}
	
	@RequestMapping(value = {"/san-pham/{id}/{currentPage}"}) 
	public ModelAndView Product(@PathVariable String id, @PathVariable String currentPage) {
		mvShare.setViewName("user/products/category");
		//mvShare.addObject("products_byCatID", categoryService.GetDataProductsByCat_ID(id));
		
		int totalData = categoryService.GetDataProductsByCat_ID(id).size();
		PaginatesDto paginatesInfo = paginatesService.GetInfoPaginates(totalData, totalPage, Integer.parseInt(currentPage));
		mvShare.addObject("cat_id", id);
		mvShare.addObject("paginatesInfo", paginatesInfo);
		mvShare.addObject("productsPaginates", categoryService.GetDataProductsPaginates(id, paginatesInfo.getStart(), totalPage));
		
		return mvShare;
	}
}

