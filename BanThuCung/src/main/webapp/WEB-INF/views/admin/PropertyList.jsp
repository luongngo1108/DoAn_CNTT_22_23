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
							<th scope="col">Pet weight</th>
							<th scope="col">Color</th>
							<th scope="col">Food weight</th>
							<th scope="col">Food flavor</th>
							<th scope="col">Material</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="property" items="${propertyList}">
							<tr>
								<td><c:out value="${property.proper_id}" /></td>
								<c:choose>
									<c:when test="${property.petwei_id != null}">
										<c:forEach var="petwei" items="${petweiList}">
											<c:if test="${property.petwei_id == petwei.petwei_id}">
												<td><c:out value="${petwei.type}" /></td>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td><c:out value=" " /></td>
   									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${property.color_id != null}">
										<c:forEach var="color" items="${colorList}">
											<c:if test="${property.color_id == color.color_id}">
												<td><c:out value="${color.type}" /></td>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td><c:out value=" " /></td>
   									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${property.foodwei_id != null}">
										<c:forEach var="foodwei" items="${foodweiList}">
											<c:if test="${property.foodwei_id == foodwei.foodwei_id}">
												<td><c:out value="${foodwei.type}" /></td>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td><c:out value=" " /></td>
   									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${property.foodfla_id != null}">
										<c:forEach var="foodfla" items="${foodflaList}">
											<c:if test="${property.foodfla_id == foodfla.foodfla_id}">
												<td><c:out value="${foodfla.type}" /></td>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td><c:out value=" " /></td>
   									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${property.material_id != null}">
										<c:forEach var="material" items="${materialList}">
											<c:if test="${property.material_id == material.material_id}">
												<td><c:out value="${material.type}" /></td>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td><c:out value=" " /></td>
   									</c:otherwise>
								</c:choose>
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