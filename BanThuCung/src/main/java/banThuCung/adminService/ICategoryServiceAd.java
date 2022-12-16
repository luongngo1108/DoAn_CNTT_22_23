package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.Categories;

public interface ICategoryServiceAd {
	public List<Categories> getAllCategories();
	public int createCategory(Categories category);
	public int updateCategory(Categories category);
	public Categories getCategoryByID(String cat_id);
	public int deleteCategory(String cat_id);
}
