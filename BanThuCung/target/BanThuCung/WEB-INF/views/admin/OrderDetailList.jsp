<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Categories</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-12">
			<a href="/BanThuCung/quan-tri/don-hang/chi-tiet-don-hang/orderDetailForm"><button type="button" class="btn btn-secondary m-2">Add new order detail</button></a>
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">Danh sách các chi tiết đơn hàng</h6>
				<i>${errorDelOrderDetailMessage}</i>
				<table class="table table-borderDetailed">
					<thead>
						<tr>
							<th scope="col">Order ID</th>
							<th scope="col">Product ID</th>
							<th scope="col">Property ID</th>
							<th scope="col">Quantity</th>
							<th scope="col">Total</th>
							<th scope="col">Paid</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="orderDetail" items="${orderDetailList}">
							<tr>
								<td><c:out value="${orderDetail.order_id}" /></td>
								<td><c:out value="${orderDetail.pro_id}" /></td>
								<td><c:out value="${orderDetail.proper_id}" /></td>
								<td><c:out value="${orderDetail.quantity}" /></td>
								<td><c:out value="${orderDetail.total}" /></td>
								<td><c:out value="${orderDetail.paid}" /></td>
								<td><a href="edit/${orderDetail.order_id} ">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete/${orderDetail.order_id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>