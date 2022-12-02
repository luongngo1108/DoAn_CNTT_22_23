package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.CateFoodWei;

public interface ICateFoodWeiService {
	public List<CateFoodWei> getAllCateFoodWeis();
	public int createCateFoodWei(CateFoodWei cateFoodWei);
	public int updateCateFoodWei(CateFoodWei cateFoodWei);
	public CateFoodWei getCateFoodWeiByID(String foowei_id);
	public int deleteCateFoodWei(String foodwei_id);
}
