<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Sidebar Start -->
<div class="sidebar pe-4 pb-3">
	<nav class="navbar bg-light navbar-light">
		<a href="/BanThuCung/quan-tri/trang-chu" class="navbar-brand mx-4 mb-3">
			<h3 class="text-primary">
				<i class="fa fa-hashtag me-2"></i>Trang ADMIN
			</h3>
		</a>
		<div class="d-flex align-items-center ms-4 mb-4">
			<div class="position-relative">
				<img class="rounded-circle" src="<c:url value="/assets/admin/img/user.jpg" />" alt=""
					style="width: 40px; height: 40px;">
				<div
					class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
			</div>
			<div class="ms-3">
				<h6 class="mb-0">${admin_acc.name}</h6>
				<span>Admin</span>
			</div>
		</div>
		<div class="navbar-nav w-100">
			<a href="/BanThuCung/quan-tri/trang-chu" class="nav-item nav-link active"><i
				class="fa fa-tachometer-alt me-2"></i>Thống kê</a>
			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Sản phẩm</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="/BanThuCung/quan-tri/san-pham/nha-phan-phoi/list" class="dropdown-item">Nhà phân phối</a> 
					<a href="/BanThuCung/quan-tri/san-pham/kieu-san-pham/list" class="dropdown-item">Kiểu sản phẩm</a>
					<a href="/BanThuCung/quan-tri/san-pham/loai-mau/list" class="dropdown-item">Loại màu</a>
					<a href="/BanThuCung/quan-tri/san-pham/loai-huong-vi/list" class="dropdown-item">Loại hương vị đồ ăn</a>
					<a href="/BanThuCung/quan-tri/san-pham/loai-can-nang-thu-cung/list" class="dropdown-item">Loại cân nặng thú cưng</a>
					<a href="/BanThuCung/quan-tri/san-pham/loai-nguyen-lieu/list" class="dropdown-item">Loại nguyên liệu</a>
					<a href="/BanThuCung/quan-tri/san-pham/loai-can-nang-thuc-an/list" class="dropdown-item">Loại cân nặng đồ ăn</a>
					<a href="/BanThuCung/quan-tri/san-pham/thuoc-tinh/list" class="dropdown-item">Thuộc tính sản phẩm</a>
					<a href="/BanThuCung/quan-tri/san-pham/cac-san-pham/list" class="dropdown-item">Sản phẩm</a>
				</div>
			</div>
			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Đơn hàng</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="/BanThuCung/quan-tri/don-hang/cong-ty-van-chuyen/list" class="dropdown-item">Công ty vận chuyển</a> 
					<a href="/BanThuCung/quan-tri/don-hang/dich-vu-van-chuyen/list" class="dropdown-item">Dịch vụ vận chuyển</a>
					<a href="/BanThuCung/quan-tri/don-hang/cac-don-hang/list" class="dropdown-item">Các đơn hàng</a>
					<a href="/BanThuCung/quan-tri/don-hang/chi-tiet-don-hang/list" class="dropdown-item">Chi tiết đơn hàng</a>
				</div>
			</div>
			<div class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle"
					data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Tài khoản</a>
				<div class="dropdown-menu bg-transparent border-0">
					<a href="/BanThuCung/quan-tri/tai-khoan/nguoi-dung/list" class="dropdown-item">Người dùng</a> 
					<a href="/BanThuCung/quan-tri/tai-khoan/admin/accountForm" class="dropdown-item">Tài khoản admin</a>
				</div>
			</div>
		</div>
	</nav>
</div>
<!-- Sidebar End -->