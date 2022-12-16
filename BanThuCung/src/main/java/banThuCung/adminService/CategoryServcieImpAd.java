package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.CategoriesDao;
import banThuCung.Entities.Categories;

@Service
public class CategoryServcieImpAd implements ICategoryServiceAd {
	@Autowired
	CategoriesDao categoriesDao = new CategoriesDao();
	
	@Override
	public List<Categories> getAllCategories() {
		return categoriesDao.GetDataCategories();
	}

	@Override
	public int createCategory(Categories category) {
		return categoriesDao.saveCategory(category);
	}

	@Override
	public int updateCategory(Categories category) {
		return categoriesDao.updateCategory(category);
	}

	@Override
	public Categories getCategoryByID(String cat_id) {
		return categoriesDao.getCategoryByID(cat_id);
	}

	@Override
	public int deleteCategory(String cat_id) {
		return categoriesDao.deleteCategory(cat_id);
	}
	
	
}
