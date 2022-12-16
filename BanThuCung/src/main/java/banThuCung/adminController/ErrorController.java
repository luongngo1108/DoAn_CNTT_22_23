package banThuCung.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	//
	@RequestMapping(value = {"/"}, method = RequestMethod.GET) 
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/404");
		return mv;
	}
}
