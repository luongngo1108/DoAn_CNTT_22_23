package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.CateColor;

public interface ICateColorService {
	public List<CateColor> getAllCateColors();
	public int createCateColor(CateColor cateColor);
	public int updateCateColor(CateColor cateColor);
	public CateColor getCateColorByID(String color_id);
	public int deleteCateColor(String color_id);
}
