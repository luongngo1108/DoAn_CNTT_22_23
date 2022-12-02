<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Suppliers</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-12">
			<a href="/BanThuCung/quan-tri/san-pham/nha-phan-phoi/supplierForm"><button type="button" class="btn btn-secondary m-2">Add new supplier</button></a>
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">Danh sách nhà cung cấp sản phẩm</h6>
				<i>${errorDelSupMessage}</i>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Address</th>
							<th scope="col">Phone</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="supList" items="${supplierList}">
							<tr>
								<td><c:out value="${supList.sup_id}" /></td>
								<td><c:out value="${supList.name}" /></td>
								<td><c:out value="${supList.address}" /></td>
								<td><c:out value="${supList.phone}" /></td>
								<td><a href="edit/${supList.sup_id} ">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete/${supList.sup_id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>