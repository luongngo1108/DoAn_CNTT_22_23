package banThuCung.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banThuCung.Entities.DeliService;

@Service
public interface IDeliveryService {
	@Autowired
	public List<DeliService> getDataDeliService();
}
