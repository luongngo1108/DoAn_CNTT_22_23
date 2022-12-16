<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Category Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${deliService.deli_ser_id !=null }">
					<h6 class="mb-4">Edit delivery service ${deliService.deli_ser_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/don-hang/dich-vu-van-chuyen/update" modelAttribute="deliService" >
						<div class="mb-3">
							<label for="InputDeliServiceID" class="form-label">Delivery Service ID</label> 
								<form:input pattern="DS+[0-9]{3,3}" path="deli_ser_id" type="text" class="form-control" id="InputDeliServiceID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: DS001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="deli_com_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="deliCompany" items="${deliCompanyList}">
									<c:if test="${deliCompany.deli_com_id == deliService.deli_com_id }">
										<option selected value="${deliCompany.deli_com_id}">${deliCompany.deli_com_id}</option>
									</c:if>
									<c:if test="${deliCompany.deli_com_id != deliService.deli_com_id }">
										<option value="${deliCompany.deli_com_id}">${deliCompany.deli_com_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="mb-3">
							<label for="InputDeliServiceType" class="form-label">Type</label>
							<form:input path="type" type="text" class="form-control" id="InputDeliServiceType" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliServicePrice" class="form-label">Price</label>
							<form:input path="price" type="text" class="form-control" id="InputDeliServicePrice" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliServiceTime" class="form-label">Time</label>
							<form:input path="time" type="text" class="form-control" id="InputDeliServiceTime" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/don-hang/dich-vu-van-chuyen/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${deliService.deli_ser_id == null }">
					<h6 class="mb-4">Add new delivery service</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/don-hang/dich-vu-van-chuyen/create" modelAttribute="deliService" >
						<div class="mb-3">
							<label for="InputDeliServiceID" class="form-label">Delivery Service ID</label> 
								<form:input pattern="DS+[0-9]{3,3}" path="deli_ser_id" type="text" class="form-control" id="InputDeliServiceID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: DS001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="deli_com_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="deliCompany" items="${deliCompanyList}" varStatus="index">
									<c:if test="${index.first}">
										<option selected value="${deliService.deli_com_id}">${deliService.deli_com_id}</option>
									</c:if>
									<c:if test="${not index.first}">
										<option value="${deliService.deli_com_id}">${deliService.deli_com_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="mb-3">
							<label for="InputDeliServiceType" class="form-label">Type</label>
							<form:input path="type" type="text" class="form-control" id="InputDeliServiceType" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliServicePrice" class="form-label">Price</label>
							<form:input path="price" type="text" class="form-control" id="InputDeliServicePrice" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputDeliServiceTime" class="form-label">Time</label>
							<form:input path="time" type="text" class="form-control" id="InputDeliServiceTime" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/don-hang/dich-vu-van-chuyen/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>