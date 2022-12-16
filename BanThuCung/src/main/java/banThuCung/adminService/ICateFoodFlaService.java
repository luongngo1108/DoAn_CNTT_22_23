package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.CateFoodFla;

public interface ICateFoodFlaService {
	public List<CateFoodFla> getAllCateFoodFlas();
	public int createCateFoodFla(CateFoodFla cateFoodFla);
	public int updateCateFoodFla(CateFoodFla cateFoodFla);
	public CateFoodFla getCateFoodFlaByID(String foofla_id);
	public int deleteCateFoodFla(String FoodFla_id);
}
