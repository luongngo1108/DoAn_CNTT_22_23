package banThuCung.userService;

import org.springframework.stereotype.Service;

import banThuCung.Dto.PaginatesDto;

@Service
public interface IPaginatesService {
	public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage);
}
