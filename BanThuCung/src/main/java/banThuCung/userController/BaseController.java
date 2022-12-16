package banThuCung.userController;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import banThuCung.userService.HomeServiceImpl;

@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl _HomeService;
	
	public ModelAndView mvShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView Init() {
		mvShare.addObject("menus", _HomeService.GetDataMenus());
		mvShare.addObject("categories", _HomeService.GetDataCategories());
		return mvShare;
	}
}
