package banThuCung.adminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Dao.PropertyDao;
import banThuCung.Entities.Property;

@Service
public class PropertyServiceImp implements  IPropertyService {
	@Autowired
	PropertyDao propertyDao = new PropertyDao();

	@Override
	public List<Property> getAllProperties() {
		return propertyDao.GetDataProperty();
	}

	@Override
	public int createProperty(Property property) {
		return propertyDao.saveProperty(property);
	}

	@Override
	public int updateProperty(Property property) {
		return propertyDao.updateProperty(property);
	}

	@Override
	public Property getPropertyByID(String proper_id) {
		return propertyDao.getPropertyByID(proper_id);
	}

	@Override
	public int deleteProperty(String proper_id) {
		return propertyDao.deleteProperty(proper_id);
	}
}
