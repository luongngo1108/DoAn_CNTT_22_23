<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<title>Quản trị</title>
<!-- Sale & Revenue Start -->
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-4">
			<div
				class="bg-light rounded d-flex align-items-center justify-content-between p-4">
				<i class="fa fa-chart-line fa-3x text-primary"></i>
				<div class="ms-3">
					<p class="mb-2">Số đơn</p>
					<h6 class="mb-0">${total_od}</h6>
				</div>
			</div>
		</div>
		<div class="col-sm-12 col-xl-4">
			<div
				class="bg-light rounded d-flex align-items-center justify-content-between p-4">
				<i class="fa fa-chart-bar fa-3x text-primary"></i>
				<div class="ms-3">
					<p class="mb-2">Số khách hàng</p>
					<h6 class="mb-0">${total_acc}</h6>
				</div>
			</div>
		</div>
		<div class="col-sm-12 col-xl-4">
			<div
				class="bg-light rounded d-flex align-items-center justify-content-between p-4">
				<i class="fa fa-chart-area fa-3x text-primary"></i>
				<div class="ms-3">
					<p class="mb-2">Doanh thu</p>
					<h6 class="mb-0">${total_revenue}</h6>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Sale & Revenue End -->

<!-- Recent Sales Start -->
<div class="container-fluid pt-4 px-4">
	<div class="bg-light text-center rounded p-4">
		<div class="d-flex align-items-center justify-content-between mb-4">
			<h6 class="mb-0">Top sản phẩm bán chạy</h6>
			<a href="/BanThuCung/quan-tri/san-pham/cac-san-pham/list">Show All</a>
		</div>
		<div class="table-responsive">
			<table
				class="table text-start align-middle table-bordered table-hover mb-0">
				<thead>
					<tr class="text-dark">
						<th scope="col">#</th>
						<th scope="col">Product ID</th>
						<th scope="col">Name</th>
						<th scope="col">Price</th>
						<th scope="col">Sold</th>
						<th scope="col">Created at</th>
						<th scope="col">Updated at</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bestSoldL" items="${bestSoldList}" varStatus="theCount">
						<tr>
							<th scope="row">${theCount.count}</th>
							<td>${bestSoldL.pro_id}</td>
							<td>${bestSoldL.pro_name}</td>
							<td>${bestSoldL.price}</td>
							<td>${bestSoldL.quantity}</td>
							<td>${bestSoldL.created_at}</td>
							<td>${bestSoldL.updated_at}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!-- Recent Sales End -->


<!-- Widgets Start -->
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-md-12 col-xl-12">
			<div class="h-100 bg-light rounded p-4">
				<div class="d-flex align-items-center justify-content-between mb-4">
					<h6 class="mb-0">Calender</h6>
				</div>
				<div id="calender"></div>
			</div>
		</div>
	</div>
</div>
<!-- Widgets End -->