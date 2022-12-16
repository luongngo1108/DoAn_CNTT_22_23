<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Supplier Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${user.acc_id !=null }">
					<h6 class="mb-4">Edit user account ${user.acc_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/tai-khoan/nguoi-dung/update" modelAttribute="user" >
						<div class="mb-3">
							<label for="InputSupID" class="form-label">Supplier ID</label> 
								<form:input pattern="CU+[0-9]{1,3}" path="acc_id" type="text" class="form-control" id="InputSupID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: CU001</div>
						</div>
						<div class="mb-3">
							<label for="InputSupName" class="form-label">Name</label>
							<form:input path="name" type="text" class="form-control" id="InputSupName" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputUserEmail" class="form-label">email</label>
							<form:input path="email" type="email" class="form-control" id="InputUserEmail" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputSupPhone" class="form-label">Phone</label>
							<form:input pattern="[0-9]{10,10}" path="phone" type="text" class="form-control" id="InputSupPhone" required="required"/>
							<div id="phoneHelp" class="form-text">Nhập SDT gồm 10 số</div>
						</div>
						<div class="mb-3">
							<label for="InputSupAddress" class="form-label">Address</label>
							<form:input path="address" type="text" class="form-control" id="InputSupAddress" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputPassword" class="form-label">Password</label>
							<form:input path="password" type="text" class="form-control" id="InputPassword" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/tai-khoan/nguoi-dung/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${admin.acc_id != null }">
					<h6 class="mb-4">Edit admin account ${admin.acc_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/tai-khoan/admin/update" modelAttribute="admin" >
						<div class="mb-3">
							<label for="InputSupID" class="form-label">Supplier ID</label> 
								<form:input pattern="AD+[0-9]{1,3}" path="acc_id" type="text" class="form-control" id="InputSupID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: AD001</div>
						</div>
						<div class="mb-3">
							<label for="InputSupName" class="form-label">Name</label>
							<form:input path="name" type="text" class="form-control" id="InputSupName" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputUserEmail" class="form-label">email</label>
							<form:input path="email" type="email" class="form-control" id="InputUserEmail" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputSupPhone" class="form-label">Phone</label>
							<form:input pattern="[0-9]{10,10}" path="phone" type="text" class="form-control" id="InputSupPhone" required="required"/>
							<div id="phoneHelp" class="form-text">Nhập SDT gồm 10 số</div>
						</div>
						<div class="mb-3">
							<label for="InputSupAddress" class="form-label">Address</label>
							<form:input path="address" type="text" class="form-control" id="InputSupAddress" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputPassword" class="form-label">Password</label>
							<form:input path="password" type="text" class="form-control" id="InputPassword" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/trang-chu"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>