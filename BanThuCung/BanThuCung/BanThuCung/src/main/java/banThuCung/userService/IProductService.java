package banThuCung.userService;

import java.util.List;

import org.springframework.stereotype.Service;

import banThuCung.Dto.*;

@Service
public interface IProductService {
	public ProductDto GetProductByPro_ID(String pro_id);
	public List<ProductsDto> GetProductsByCat_ID(String cat_id);
}
