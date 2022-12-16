<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Category Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${catePetWei.petwei_id !=null }">
					<h6 class="mb-4">Edit pet weight ${catePetWei.petwei_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/loai-can-nang-thu-cung/update" modelAttribute="catePetWei" >
						<div class="mb-3">
							<label for="InputCatePetWeiID" class="form-label">Pet Weight ID</label> 
								<form:input pattern="PW+[0-9]{3,3}" path="petwei_id" type="text" class="form-control" id="InputCatePetWeiID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: PW001</div>
						</div>
						<div class="mb-3">
							<label for="InputCatePetWeiType" class="form-label">Type</label>
							<form:input path="type" type="text" class="form-control" id="InputCatePetWeiType" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/loai-can-nang-thu-cung/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${catePetWei.petwei_id == null }">
					<h6 class="mb-4">Add new pet weight</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/loai-can-nang-thu-cung/create" modelAttribute="catePetWei" >
						<div class="mb-3">
							<label for="InputCatePetWeiID" class="form-label">Pet Weight ID</label> 
								<form:input pattern="PW+[0-9]{3,3}" path="petwei_id" type="text" class="form-control" id="InputCatePetWeiID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: PW001</div>
						</div>
						<div class="mb-3">
							<label for="InputCatePetWeiType" class="form-label">Type</label>	
							<form:input path="type" type="text" class="form-control" id="InputCatePetWeiType" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/loai-can-nang-thu-cung/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>