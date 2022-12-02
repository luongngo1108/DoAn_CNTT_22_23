<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Categories</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-12">
			<a href="/BanThuCung/quan-tri/don-hang/cong-ty-van-chuyen/deliCompanyForm"><button type="button" class="btn btn-secondary m-2">Add new delivery company</button></a>
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">Danh sách các công ty vận chuyển</h6>
				<i>${errorDelDeliCompanyMessage}</i>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Address</th>
							<th scope="col">Phone</th>
							<th scope="col">Email</th>
							<th scope="col">Name Contact</th>
							<th scope="col">Web URL</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="deliCompany" items="${deliCompanyList}">
							<tr>
								<td><c:out value="${deliCompany.deli_com_id}" /></td>
								<td><c:out value="${deliCompany.name}" /></td>
								<td><c:out value="${deliCompany.address}" /></td>
								<td><c:out value="${deliCompany.phone}" /></td>
								<td><c:out value="${deliCompany.email}" /></td>
								<td><c:out value="${deliCompany.name_contact}" /></td>
								<td><a href="https://${deliCompany.web_url}/"><c:out value="${deliCompany.web_url}" /></a></td>
								<td><a href="edit/${deliCompany.deli_com_id} ">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete/${deliCompany.deli_com_id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>