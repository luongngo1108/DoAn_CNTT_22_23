package banThuCung.adminService;

import java.util.List;

import banThuCung.Entities.Property;

public interface IPropertyService {
	public List<Property> getAllProperties();
	public int createProperty(Property property);
	public int updateProperty(Property property);
	public Property getPropertyByID(String proper_id);
	public int deleteProperty(String proper_id);
}
