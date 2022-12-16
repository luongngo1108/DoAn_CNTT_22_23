package banThuCung.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
	//
	@RequestMapping(value = {"/contact"}) 
	public ModelAndView Product() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/contact");
		return mv;
	}
}
