<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Category Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${property.proper_id !=null }">
					<h6 class="mb-4">Edit Property ${property.proper_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/thuoc-tinh/update" modelAttribute="property" >
						<div class="mb-3">
							<label for="InputPropertyID" class="form-label">property ID</label> 
								<form:input pattern="PP+[0-9]{3,3}" path="proper_id" type="text" class="form-control" id="InputPropertyID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: PP001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="petwei_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="petwei" items="${petweiList}">
									<c:if test="${petwei.petwei_id == property.petwei_id }">
										<option selected value="${petwei.petwei_id}">${petwei.petwei_id}</option>
									</c:if>
									<c:if test="${petwei.petwei_id != property.petwei_id }">
										<option value="${petwei.petwei_id}">${petwei.petwei_id}</option>
									</c:if>
								</c:forEach>
								<c:if test="${property.petwei_id == null}">
									<option selected value="null">null</option>
								</c:if>
								<c:if test="${property.petwei_id != null}">
									<option value="null">null</option>
								</c:if>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="color_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="color" items="${colorList}">
									<c:if test="${color.color_id == property.color_id }">
										<option selected value="${color.color_id}">${color.color_id}</option>
									</c:if>
									<c:if test="${color.color_id != property.color_id }">
										<option value="${color.color_id}">${color.color_id}</option>
									</c:if>
								</c:forEach>
								<c:if test="${property.color_id == null}">
									<option selected value="null">null</option>
								</c:if>
								<c:if test="${property.color_id != null}">
									<option value="null">null</option>
								</c:if>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="foodwei_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="foodwei" items="${foodweiList}">
									<c:if test="${foodwei.foodwei_id == property.foodwei_id }">
										<option selected value="${foodwei.foodwei_id}">${foodwei.foodwei_id}</option>
									</c:if>
									<c:if test="${foodwei.foodwei_id != property.foodwei_id}">
										<option value="${foodwei.foodwei_id}">${foodwei.foodwei_id}</option>
									</c:if>		
								</c:forEach>
								<c:if test="${property.foodwei_id == null}">
									<option selected value="null">null</option>
								</c:if>
								<c:if test="${property.foodwei_id != null}">
									<option value="null">null</option>
								</c:if>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="foodfla_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="foodfla" items="${foodflaList}">
									<c:if test="${foodfla.foodfla_id == property.foodfla_id }">
										<option selected value="${foodfla.foodfla_id}">${foodfla.foodfla_id}</option>
									</c:if>
									<c:if test="${foodfla.foodfla_id != property.foodfla_id }">
										<option value="${foodfla.foodfla_id}">${foodfla.foodfla_id}</option>
									</c:if>		
								</c:forEach>
								<c:if test="${property.foodfla_id == null}">
									<option selected value="null">null</option>
								</c:if>
								<c:if test="${property.foodfla_id != null}">
									<option value="null">null</option>
								</c:if>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="material_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="material" items="${materialList}">
									<c:if test="${material.material_id == property.material_id }">
										<option selected value="${material.material_id}">${material.material_id}</option>
									</c:if>
									<c:if test="${material.material_id != property.material_id }">
										<option value="${material.material_id}">${material.material_id}</option>
									</c:if>					
								</c:forEach>
								<c:if test="${property.material_id == null}">
									<option selected value="null">null</option>
								</c:if>
								<c:if test="${property.material_id != null}">
									<option value="null">null</option>
								</c:if>
							</form:select>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/thuoc-tinh/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${property.proper_id == null }">
					<h6 class="mb-4">Add new property</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/thuoc-tinh/create" modelAttribute="property" >
						<div class="mb-3">
							<label for="InputPropertyID" class="form-label">property ID</label> 
								<form:input pattern="PP+[0-9]{3,3}" path="proper_id" type="text" class="form-control" id="InputPropertyID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: PP001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="petwei_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="petwei" items="${petweiList}">
									<option value="${petwei.petwei_id}">${petwei.petwei_id}</option>
								</c:forEach>
								<option selected value="null">null</option>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="color_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="color" items="${colorList}">
									<option value="${color.color_id}">${color.color_id}</option>
								</c:forEach>
								<option selected value="null">null</option>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="foodwei_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="foodwei" items="${foodweiList}">
									<option value="${foodwei.foodwei_id}">${foodwei.foodwei_id}</option>
								</c:forEach>
								<option selected value="null">null</option>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="foodfla_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="foodfla" items="${foodflaList}">
									<option value="${foodfla.foodfla_id}">${foodfla.foodfla_id}</option>
								</c:forEach>
								<option selected value="null">null</option>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="material_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="material" items="${materialList}">
									<option value="${material.material_id}">${material.material_id}</option>
								</c:forEach>
								<option selected value="null">null</option>
							</form:select>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/thuoc-tinh/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>