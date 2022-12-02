package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.CateFoodWeiDao;
import banThuCung.Entities.CateFoodWei;

@Service
public class CateFoodWeiServiceImp implements ICateFoodWeiService {
	@Autowired
	CateFoodWeiDao cateFoodWeiDao = new CateFoodWeiDao();

	@Override
	public List<CateFoodWei> getAllCateFoodWeis() {
		return cateFoodWeiDao.GetAllFoodWeiCategories();
	}

	@Override
	public int createCateFoodWei(CateFoodWei cateFoodWei) {
		return cateFoodWeiDao.saveCateFoodWei(cateFoodWei);
	}

	@Override
	public int updateCateFoodWei(CateFoodWei cateFoodWei) {
		return cateFoodWeiDao.updateCateFoodWei(cateFoodWei);
	}

	@Override
	public CateFoodWei getCateFoodWeiByID(String foowei_id) {
		return cateFoodWeiDao.getCateFoodWeiByID(foowei_id);
	}

	@Override
	public int deleteCateFoodWei(String FoodWei_id) {
		return cateFoodWeiDao.deleteCateFoodWei(FoodWei_id);
	}

	
}
