package banThuCung.userService;

import java.util.List;

import org.springframework.stereotype.Service;

import banThuCung.Dto.ProductsDto;

@Service
public interface ICategoryService {
	public List<ProductsDto> GetDataProductsByCat_ID(String cat_id);
	public List<ProductsDto> GetDataProductsPaginates(String cat_id, int start, int totalPage);
}
