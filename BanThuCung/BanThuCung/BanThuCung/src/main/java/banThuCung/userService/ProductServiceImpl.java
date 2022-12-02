package banThuCung.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.ProductsDao;
import banThuCung.Dto.ProductDto;
import banThuCung.Dto.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductsDao productsDao = new ProductsDao();
	
	public ProductDto GetProductByPro_ID(String pro_id) {
		List<ProductDto> listProducts = productsDao.GetProductByPro_ID(pro_id);
		return listProducts.get(0);
	}

	public List<ProductsDto> GetProductsByCat_ID(String cat_id) {
		return productsDao.GetDataProductsByCat_ID(cat_id);

	}

}
