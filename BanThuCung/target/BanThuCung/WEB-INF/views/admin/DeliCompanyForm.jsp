<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Category Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${deliCompany.deli_com_id !=null }">
					<h6 class="mb-4">Edit delivery company ${deliCompany.deli_com_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/don-hang/cong-ty-van-chuyen/update" modelAttribute="deliCompany" >
						<div class="mb-3">
							<label for="InputDeliCompanyID" class="form-label">Delivery Company ID</label> 
								<form:input pattern="DC+[0-9]{3,3}" path="deli_com_id" type="text" class="form-control" id="InputDeliCompanyID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: DC001</div>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyName" class="form-label">Name</label>
							<form:input path="name" type="text" class="form-control" id="InputDeliCompanyName" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyAddress" class="form-label">Address</label>
							<form:input path="address" type="text" class="form-control" id="InputDeliCompanyAddress" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputSupPhone" class="form-label">Phone</label>
							<form:input pattern="[0-9]{10,10}" path="phone" type="text" class="form-control" id="InputSupPhone" required="required"/>
							<div id="phoneHelp" class="form-text">Nhập SDT gồm 10 số</div>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyType" class="form-label">email</label>
							<form:input path="email" type="email" class="form-control" id="InputDeliCompanyType" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyType" class="form-label">Name Contact</label>
							<form:input path="name_contact" type="text" class="form-control" id="InputDeliCompanyType" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyType" class="form-label">Name</label>
							<form:input path="web_url" type="text" class="form-control" id="InputDeliCompanyType" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/don-hang/cong-ty-van-chuyen/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${deliCompany.deli_com_id == null }">
					<h6 class="mb-4">Add new delivery company</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/don-hang/cong-ty-van-chuyen/create" modelAttribute="deliCompany" >
						<div class="mb-3">
							<label for="InputDeliCompanyID" class="form-label">Delivery Company ID</label> 
								<form:input pattern="DC+[0-9]{3,3}" path="deli_com_id" type="text" class="form-control" id="InputDeliCompanyID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: DC001</div>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyName" class="form-label">Name</label>
							<form:input path="name" type="text" class="form-control" id="InputDeliCompanyName" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyAddress" class="form-label">Address</label>
							<form:input path="address" type="text" class="form-control" id="InputDeliCompanyAddress" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputSupPhone" class="form-label">Phone</label>
							<form:input pattern="[0-9]{10,10}" path="phone" type="text" class="form-control" id="InputSupPhone" required="required"/>
							<div id="phoneHelp" class="form-text">Nhập SDT gồm 10 số</div>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyType" class="form-label">email</label>
							<form:input path="email" type="email" class="form-control" id="InputDeliCompanyType" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyType" class="form-label">Name Contact</label>
							<form:input path="name_contact" type="text" class="form-control" id="InputDeliCompanyType" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliCompanyType" class="form-label">Name</label>
							<form:input path="web_url" type="text" class="form-control" id="InputDeliCompanyType" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/don-hang/cong-ty-van-chuyen/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>