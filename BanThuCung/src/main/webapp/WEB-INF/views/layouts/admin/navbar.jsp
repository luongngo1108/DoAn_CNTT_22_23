<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navbar Start -->
<nav
	class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
	<a href="#" class="navbar-brand d-flex d-lg-none me-4">
		<h2 class="text-primary mb-0">
			<i class="fa fa-hashtag"></i>
		</h2>
	</a> <a href="#" class="sidebar-toggler flex-shrink-0"> <i
		class="fa fa-bars"></i>
	</a>
	<div class="navbar-nav align-items-center ms-auto">
		<div class="nav-item dropdown">
			<a href="#" class="nav-link dropdown-toggle"
				data-bs-toggle="dropdown"> <img class="rounded-circle me-lg-2"
				src="<c:url value="/assets/admin/img/user.jpg/" />" alt="" style="width: 40px; height: 40px;">
				<span class="d-none d-lg-inline-flex">${admin_acc.name}</span>
			</a>
			<div
				class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
				<a href="/BanThuCung/quan-tri/tai-khoan/admin/accountForm" class="dropdown-item">My Profile</a>
				<a href="/BanThuCung/quan-tri/logout" class="dropdown-item">Log Out</a>
			</div>
		</div>
	</div>
</nav>
<!-- Navbar End -->
