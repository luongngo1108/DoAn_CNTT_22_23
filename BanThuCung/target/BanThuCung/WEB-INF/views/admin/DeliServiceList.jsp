<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Categories</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-12">
			<a href="/BanThuCung/quan-tri/don-hang/dich-vu-van-chuyen/deliServiceForm"><button type="button" class="btn btn-secondary m-2">Add new delivery service</button></a>
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">Danh sách các dịch vụ vận chuyển</h6>
				<i>${errorDelDeliServiceMessage}</i>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Delivery Company ID</th>
							<th scope="col">Type</th>
							<th scope="col">Price</th>
							<th scope="col">Time</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="deliService" items="${deliServiceList}">
							<tr>
								<td><c:out value="${deliService.deli_ser_id}" /></td>
								<td><c:out value="${deliService.deli_com_id}" /></td>
								<td><c:out value="${deliService.type}" /></td>
								<td><c:out value="${deliService.price}" /></td>
								<td><c:out value="${deliService.time}" /></td>
								<td><a href="edit/${deliService.deli_ser_id} ">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete/${deliService.deli_ser_id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>