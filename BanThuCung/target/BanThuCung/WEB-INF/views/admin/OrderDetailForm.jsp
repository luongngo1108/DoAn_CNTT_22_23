<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Category Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${orderDetail.order_id !=null }">
					<h6 class="mb-4">Edit order detail ${orderDetail.order_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/don-hang/chi-tiet-don-hang/update" modelAttribute="orderDetail" >
						<div class="mb-3">
							<label for="InputOrderDetailID" class="form-label">Order ID</label> 
								<form:input pattern="OR+[0-9]{1,5}" path="order_id" type="text" class="form-control" id="InputOrderDetailID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: OR001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="pro_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="product" items="${productList}">
									<c:if test="${product.pro_id == orderDetail.pro_id }">
										<option selected value="${product.pro_id}">${product.pro_id}</option>
									</c:if>
									<c:if test="${product.pro_id != orderDetail.pro_id }">
										<option value="${product.pro_id}">${product.pro_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="proper_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="property" items="${propertyList}">
									<c:if test="${property.proper_id == orderDetail.proper_id }">
										<option selected value="${property.proper_id}">${property.proper_id}</option>
									</c:if>
									<c:if test="${property.proper_id != orderDetail.proper_id }">
										<option value="${property.proper_id}">${property.proper_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="mb-3">
							<label for="InputOrderDetailQuantity" class="form-label">Quantity</label>
							<form:input path="quantity" type="text" class="form-control" id="InputOrderDetailQuantity" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputOrderDetailTotal" class="form-label">Total</label>
							<form:input path="total" type="text" class="form-control" id="InputOrderDetailTotal" required="required"/>
						</div>
						<div class="form-floating mb-3">
							<form:select path="paid" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<option selected value="${orderDetail.paid}">${orderDetail.paid}</option>
								<c:if test="${orderDetail.paid == true }"><option value="false">false</option></c:if>
								<c:if test="${orderDetail.paid == false }"><option value="true">true</option></c:if>
							</form:select>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/don-hang/chi-tiet-don-hang/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${orderDetail.order_id ==null}">
					<h6 class="mb-4">Add new order detail</h6>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/don-hang/chi-tiet-don-hang/create" modelAttribute="orderDetail" >
						<div class="mb-3">
							<label for="InputOrderDetailID" class="form-label">Order ID</label> 
								<form:input pattern="OR+[0-9]{1,5}" path="order_id" type="text" class="form-control" id="InputOrderDetailID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: OR001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="pro_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="product" items="${productList}">
									<c:if test="${index.first}">
										<option selected value="${product.pro_id}">${product.pro_id}</option>
									</c:if>
									<c:if test="${not index.first}">
										<option value="${product.pro_id}">${product.pro_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="proper_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="property" items="${propertyList}">
									<c:if test="${index.first}">
										<option selected value="${property.proper_id}">${property.proper_id}</option>
									</c:if>
									<c:if test="${not index.first}">
										<option value="${property.proper_id}">${property.proper_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>						
						<div class="mb-3">
							<label for="InputOrderDetailQuantity" class="form-label">Quantity</label>
							<form:input path="quantity" type="text" class="form-control" id="InputOrderDetailQuantity" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputOrderDetailTotal" class="form-label">Total</label>
							<form:input path="total" type="text" class="form-control" id="InputOrderDetailTotal" required="required"/>
						</div>
						<div class="form-floating mb-3">
							<form:select path="paid" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<option value="false">false</option>
								<option selected value="true">true</option>
							</form:select>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/don-hang/chi-tiet-don-hang/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>