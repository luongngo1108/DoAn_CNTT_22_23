package banThuCung.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{

	@RequestMapping(value = {"/trang-chu"}) 
	public ModelAndView Index() {
		mvShare.setViewName("user/index");
		mvShare.addObject("slides", _HomeService.GetDataSlides());
		mvShare.addObject("new_products", _HomeService.GetNewProducts());
		mvShare.addObject("highlight_products", _HomeService.GetHighLightProducts());
		return mvShare;
	}
	
	@RequestMapping(value = {"/product"})
	public ModelAndView Product() {
		mvShare.setViewName("user/product");
		return mvShare;
	}
}
