<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Category Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${category.cat_id !=null }">
					<h6 class="mb-4">Edit Category ${category.name}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/kieu-san-pham/update" modelAttribute="category" >
						<form:input  path="cat_id" type="hidden"/>
						<div class="mb-3">
							<label for="InputCatName" class="form-label">Name</label>
							<form:input path="name" type="text" class="form-control" id="InputCatName" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/kieu-san-pham/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${category.cat_id == null }">
					<h6 class="mb-4">Add new category</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/kieu-san-pham/create" modelAttribute="category" >
						<div class="mb-3">
							<label for="InputCatName" class="form-label">Name</label>
							<form:input path="name" type="text" class="form-control" id="InputCatName" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/kieu-san-pham/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>