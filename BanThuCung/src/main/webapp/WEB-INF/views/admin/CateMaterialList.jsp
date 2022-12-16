<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Categories</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-12">
			<a href="/BanThuCung/quan-tri/san-pham/loai-nguyen-lieu/cateMaterialForm"><button type="button" class="btn btn-secondary m-2">Add new material</button></a>
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">Danh sách các nguyên liệu đồ dùng</h6>
				<i>${errorDelCateMaterialMessage}</i>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Type</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cateMaterial" items="${cateMaterialList}">
							<tr>
								<td><c:out value="${cateMaterial.material_id}" /></td>
								<td><c:out value="${cateMaterial.type}" /></td>
								<td><a href="edit/${cateMaterial.material_id} ">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete/${cateMaterial.material_id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>