package banThuCung.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.*;
import banThuCung.Entities.*;
import banThuCung.Dto.*;

@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategoriesDao categoriesDao;
	@Autowired
	private MenusDao menusDao;
	@Autowired
	private ProductsDao productsDao;
	
	public List<Slides> GetDataSlides() {
		return slidesDao.GetDataSlides();
	}
	public List<Categories> GetDataCategories() {
		return categoriesDao.GetDataCategories();
	}
	public List<Menus> GetDataMenus() {
		return menusDao.GetDataMenus();
	}
	public List<ProductsDto> GetNewProducts() {
		List<ProductsDto> listProducts = productsDao.GetNewProducts();
		return listProducts;
	}
	public List<ProductsDto> GetHighLightProducts() {
		List<ProductsDto> listProducts = productsDao.GetHighLightProducts();
		return listProducts;
	}

}
