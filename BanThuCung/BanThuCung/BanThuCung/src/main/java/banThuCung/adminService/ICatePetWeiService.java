package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.CatePetWei;

public interface ICatePetWeiService {
	public List<CatePetWei> getCatePetWeis();
	public int createCatePetWei(CatePetWei catePetWei);
	public int updateCatePetWei(CatePetWei catePetWei);
	public CatePetWei getCatePetWeiByID(String petwei_id);
	public int deleteCatePetWei(String petwei_id);
}
