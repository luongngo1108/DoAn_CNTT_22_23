<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Categories</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-12">
			<a href="/BanThuCung/quan-tri/san-pham/loai-huong-vi/cateFoodFlaForm"><button type="button" class="btn btn-secondary m-2">Add new food flavor</button></a>
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">Danh sách các hương vị</h6>
				<i>${errorDelCateFoodFlaMessage}</i>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Type</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cateFoodFla" items="${cateFoodFlaList}">
							<tr>
								<td><c:out value="${cateFoodFla.foodfla_id}" /></td>
								<td><c:out value="${cateFoodFla.type}" /></td>
								<td><a href="edit/${cateFoodFla.foodfla_id} ">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete/${cateFoodFla.foodfla_id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>