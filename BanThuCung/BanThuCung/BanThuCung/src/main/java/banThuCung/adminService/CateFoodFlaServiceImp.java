package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.CateFoodFlaDao;
import banThuCung.Entities.CateFoodFla;

@Service
public class CateFoodFlaServiceImp implements ICateFoodFlaService {
	@Autowired
	CateFoodFlaDao cateFoodFlaDao = new CateFoodFlaDao();

	@Override
	public List<CateFoodFla> getAllCateFoodFlas() {
		return cateFoodFlaDao.GetAllFoodFlaCategories();
	}

	@Override
	public int createCateFoodFla(CateFoodFla cateFoodFla) {
		return cateFoodFlaDao.saveCateFoodFla(cateFoodFla);
	}

	@Override
	public int updateCateFoodFla(CateFoodFla cateFoodFla) {
		return cateFoodFlaDao.updateCateFoodFla(cateFoodFla);
	}

	@Override
	public CateFoodFla getCateFoodFlaByID(String foofla_id) {
		return cateFoodFlaDao.getCateFoodFlaByID(foofla_id);
	}

	@Override
	public int deleteCateFoodFla(String FoodFla_id) {
		return cateFoodFlaDao.deleteCateFoodFla(FoodFla_id);
	}

	
}
