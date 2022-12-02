package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.CateColorDao;
import banThuCung.Entities.CateColor;

@Service
public class CateColorServiceImp implements ICateColorService {
	@Autowired
	CateColorDao cateColorDao = new CateColorDao();

	@Override
	public List<CateColor> getAllCateColors() {
		return cateColorDao.GetAllColorCategories();
	}

	@Override
	public int createCateColor(CateColor cateColor) {
		return cateColorDao.saveCateColor(cateColor);
	}

	@Override
	public int updateCateColor(CateColor cateColor) {
		return cateColorDao.updateCateColor(cateColor);
	}

	@Override
	public CateColor getCateColorByID(String color_id) {
		return cateColorDao.getCateColorByID(color_id);
	}

	@Override
	public int deleteCateColor(String color_id) {
		return cateColorDao.deleteCateColor(color_id);
	}
}
