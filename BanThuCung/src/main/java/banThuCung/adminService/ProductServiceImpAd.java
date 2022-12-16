package banThuCung.adminService;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.ProductsDao;
import banThuCung.Dto.ProductsDto;

@Service
public class ProductServiceImpAd implements IProductService {

	@Autowired
	private ProductsDao productsDao = new ProductsDao();

	@Override
	public List<ProductsDto> getAllProducts() {
		return productsDao.getAllProducts();
	}

	@Override
	public List<ProductsDto> getBestSoldPro() {
		List<ProductsDto> productList = productsDao.getBestSold();
		Collections.sort(productList, (o1, o2) -> o2.getQuantity() - o1.getQuantity());
		return productList;
	}

	@Override
	public int createProduct(ProductsDto productsDto) {
		return productsDao.saveProduct(productsDto);
	}

	@Override
	public int updateProduct(ProductsDto productsDto) {
		return productsDao.updateProduct(productsDto);
	}

	@Override
	public ProductsDto getProductByID(String pro_id, String proper_id) {
		return productsDao.getProductsDtoByID(pro_id, proper_id);
	}

	@Override
	public int deleteProduct(String pro_id, String proper_id) {
		return productsDao.deleteProduct(pro_id, proper_id);
	}
}
