<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Categories</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-12">
			<a href="/BanThuCung/quan-tri/san-pham/thuoc-tinh/propertyForm"><button type="button" class="btn btn-secondary m-2">Add new property</button></a>
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">Danh sách các thuộc tính</h6>
				<i>${errorDelPropertyMessage}</i>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Property ID</th>
							<th scope="col">Pet weight ID</th>
							<th scope="col">Color ID</th>
							<th scope="col">Food weight ID</th>
							<th scope="col">Food flavor ID</th>
							<th scope="col">Material ID</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="property" items="${propertyList}">
							<tr>
								<td><c:out value="${property.proper_id}" /></td>
								<td><c:out value="${property.petwei_id}" /></td>
								<td><c:out value="${property.color_id}" /></td>
								<td><c:out value="${property.foodwei_id}" /></td>
								<td><c:out value="${property.foodfla_id}" /></td>
								<td><c:out value="${property.material_id}" /></td>
								<td><a href="edit/${property.proper_id} ">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete/${property.proper_id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>