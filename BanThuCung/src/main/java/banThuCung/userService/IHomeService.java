package banThuCung.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Entities.*;
import banThuCung.Dto.*;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlides();
	public List<Categories> GetDataCategories();
	public List<Menus> GetDataMenus();
	public List<ProductsDto> GetNewProducts();
	public List<ProductsDto> GetHighLightProducts();
}
