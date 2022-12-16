package banThuCung.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.ProductsDao;
import banThuCung.Dto.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ProductsDao productsDao;
	
	public List<ProductsDto> GetDataProductsByCat_ID(String cat_id) {
		List<ProductsDto> products = productsDao.GetDataProductsByCat_ID(cat_id);
		return products;
	}
	
	public List<ProductsDto> GetDataProductsPaginates(String cat_id, int start, int totalPage) {
		List<ProductsDto> products = productsDao.GetProductsPaginates(cat_id, start, totalPage);
		return products;
	}
}
