package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.CateMaterial;

public interface ICateMaterialService {
	public List<CateMaterial> getCateMaterials();
	public int createCateMaterial(CateMaterial cateMaterial);
	public int updateCateMaterial(CateMaterial cateMaterial);
	public CateMaterial getCateMaterialByID(String material_id);
	public int deleteCateMaterial(String material_id);
}
