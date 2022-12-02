package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.CatePetWeiDao;
import banThuCung.Entities.CatePetWei;

@Service
public class CatePetWeiServiceImp implements ICatePetWeiService {

	@Autowired
	CatePetWeiDao catePetWeiDao = new CatePetWeiDao();
	
	@Override
	public List<CatePetWei> getCatePetWeis() {
		return catePetWeiDao.GetAllFoodFlaCategories();
	}

	@Override
	public int createCatePetWei(CatePetWei catePetWei) {
		return catePetWeiDao.saveCatePetWei(catePetWei);
	}

	@Override
	public int updateCatePetWei(CatePetWei catePetWei) {
		return catePetWeiDao.updateCatePetWei(catePetWei);
	}

	@Override
	public CatePetWei getCatePetWeiByID(String petwei_id) {
		return catePetWeiDao.getCatePetWeiByID(petwei_id);
	}

	@Override
	public int deleteCatePetWei(String petwei_id) {
		return catePetWeiDao.deleteCatePetWei(petwei_id);
	}

}
