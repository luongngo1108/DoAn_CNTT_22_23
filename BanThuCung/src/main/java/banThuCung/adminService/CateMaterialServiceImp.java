package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.CateMaterialDao;
import banThuCung.Entities.CateMaterial;

@Service
public class CateMaterialServiceImp implements ICateMaterialService {

	@Autowired
	CateMaterialDao cateMaterialDao = new CateMaterialDao();
	
	@Override
	public List<CateMaterial> getCateMaterials() {
		return cateMaterialDao.GetAllFoodFlaCategories();
	}

	@Override
	public int createCateMaterial(CateMaterial cateMaterial) {
		return cateMaterialDao.saveCateMaterial(cateMaterial);
	}

	@Override
	public int updateCateMaterial(CateMaterial cateMaterial) {
		return cateMaterialDao.updateCateMaterial(cateMaterial);
	}

	@Override
	public CateMaterial getCateMaterialByID(String material_id) {
		return cateMaterialDao.getCateMaterialByID(material_id);
	}

	@Override
	public int deleteCateMaterial(String material_id) {
		return cateMaterialDao.deleteCateMaterial(material_id);
	}

}
