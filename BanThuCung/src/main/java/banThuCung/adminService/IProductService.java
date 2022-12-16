package banThuCung.adminService;

import java.util.List;

import org.springframework.stereotype.Service;

import banThuCung.Dto.ProductsDto;

@Service
public interface IProductService {
	public List<ProductsDto> getAllProducts();
	public List<ProductsDto> getBestSoldPro();
	public int createProduct(ProductsDto productsDto);
	public int updateProduct(ProductsDto productsDto);
	public ProductsDto getProductByID(String pro_id, String proper_id);
	public int deleteProduct(String pro_id,String proper_id);
}
