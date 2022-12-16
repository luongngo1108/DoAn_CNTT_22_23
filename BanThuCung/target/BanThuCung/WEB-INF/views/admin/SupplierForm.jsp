<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Supplier Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${supplier.sup_id !=null }">
					<h6 class="mb-4">Edit Supplier ${supplier.sup_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/nha-phan-phoi/update" modelAttribute="supplier" >
						<div class="mb-3">
							<label for="InputSupID" class="form-label">Supplier ID</label> 
								<form:input pattern="SU+[0-9]{3,3}" path="sup_id" type="text" class="form-control" id="InputSupID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: SU001</div>
						</div>
						<div class="mb-3">
							<label for="InputSupName" class="form-label">Name</label>
							<form:input path="name" type="text" class="form-control" id="InputSupName" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputSupAddress" class="form-label">Address</label>
							<form:input path="address" type="text" class="form-control" id="InputSupAddress" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputSupPhone" class="form-label">Phone</label>
							<form:input pattern="[0-9]{10,10}" path="phone" type="text" class="form-control" id="InputSupPhone" required="required"/>
							<div id="phoneHelp" class="form-text">Nhập SDT gồm 10 số</div>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/nha-phan-phoi/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${supplier.sup_id == null }">
					<h6 class="mb-4">Add new Supplier</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/nha-phan-phoi/create" modelAttribute="supplier" >
						<div class="mb-3">
							<label for="InputSupID" class="form-label">Supplier ID</label> 
								<form:input  pattern="SU+[0-9]{3,3}" path="sup_id" type="text" class="form-control" id="InputSupID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: SU001</div>
						</div>
						<div class="mb-3">
							<label for="InputSupName" class="form-label">Name</label>
							<form:input path="name" type="text" class="form-control" id="InputSupName" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputSupAddress" class="form-label">Address</label>
							<form:input path="address" type="text" class="form-control" id="InputSupAddress" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputSupPhone" class="form-label">Phone</label>
							<form:input pattern="[0-9]{10,10}" path="phone" type="text" class="form-control" id="InputSupPhone" required="required"/>
							<div id="phoneHelp" class="form-text">Nhập SDT gồm 10 số</div>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/nha-phan-phoi/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>