<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Category Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${order.order_id !=null }">
					<h6 class="mb-4">Edit order ${order.order_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/don-hang/cac-don-hang/update" modelAttribute="order" >
						<div class="mb-3">
							<label for="InputOrderID" class="form-label">Order ID</label> 
								<form:input pattern="OR+[0-9]{3,4}" path="order_id" type="text" class="form-control" id="InputOrderID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: OR001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="acc_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="cusAcc" items="${cusAccList}">
									<c:if test="${cusAcc.acc_id == order.acc_id }">
										<option selected value="${cusAcc.acc_id}">${cusAcc.acc_id}</option>
									</c:if>
									<c:if test="${cusAcc.acc_id != order.acc_id }">
										<option value="${cusAcc.acc_id}">${cusAcc.acc_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="pay_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="payment" items="${payList}">
									<c:if test="${payment.pay_id == order.pay_id }">
										<option selected value="${payment.pay_id}">${payment.pay_id}</option>
									</c:if>
									<c:if test="${payment.pay_id != order.pay_id }">
										<option value="${payment.pay_id}">${payment.pay_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="deli_ser_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="deliService" items="${deliServiceList}">
									<c:if test="${deliService.deli_ser_id == order.deli_ser_id }">
										<option selected value="${deliService.deli_ser_id}">${deliService.deli_ser_id}</option>
									</c:if>
									<c:if test="${deliService.deli_ser_id != order.deli_ser_id }">
										<option value="${deliService.deli_ser_id}">${deliService.deli_ser_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="mb-3">
							<label for="InputOrderNameRe" class="form-label">Name Receive</label>
							<form:input path="name_receiver" type="text" class="form-control" id="InputOrderNameRe" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputOrderPhoneRe" class="form-label">Phone Receive</label>
							<form:input pattern="[0-9]{10,10}" path="phone_receiver" type="text" class="form-control" id="InputOrderPhoneRe" required="required"/>
							<div id="phoneHelp" class="form-text">Nhập SDT gồm 10 số</div>
						</div>
						<div class="mb-3">
							<label for="InputOrderAddressRe" class="form-label">Address Receive</label>
							<form:input path="address_receiver" type="text" class="form-control" id="InputOrderAddressRe" required="required"/>
						</div>
						<div class="form-floating">
							<form:textarea path="note" class="form-control"
								placeholder="Note" id="floatingTextarea"
								style="height: 150px;"></form:textarea>
							<label for="floatingTextarea">Note</label>
						</div>
						<div class="mb-3">
							<label for="InputOrderTotal" class="form-label">Total</label>
							<form:input path="total" type="text" class="form-control" id="InputOrderTotal" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputOrderQuantity" class="form-label">Quantity</label>
							<form:input path="quantity" type="text" class="form-control" id="InputOrderQuantity" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputOrderDate" class="form-label">Date</label>
							<form:input path="date" type="date" class="form-control" id="InputOrderDate" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/don-hang/cac-don-hang/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${order.order_id == null }">
					<h6 class="mb-4">Add new order</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/don-hang/cac-don-hang/create" modelAttribute="order" >
						<div class="mb-3">
							<label for="InputOrderID" class="form-label">Order ID</label> 
								<form:input pattern="OR+[0-9]{3,4}" path="order_id" type="text" class="form-control" id="InputOrderID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: OR001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="acc_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="cusAcc" items="${cusAccList}" varStatus="index">
									<c:if test="${index.first}">
										<option selected value="${cusAcc.acc_id}">${cusAcc.acc_id}</option>
									</c:if>
									<c:if test="${not index.first}">
										<option value="${cusAcc.acc_id}">${cusAcc.acc_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="pay_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="payment" items="${payList}">
									<c:if test="${payment.pay_id == order.pay_id }">
										<option selected value="${payment.pay_id}">${payment.pay_id}</option>
									</c:if>
									<c:if test="${payment.pay_id != order.pay_id }">
										<option value="${payment.pay_id}">${payment.pay_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="deli_ser_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="deliService" items="${deliServiceList}">
									<c:if test="${deliService.deli_ser_id == order.deli_ser_id }">
										<option selected value="${deliService.deli_ser_id}">${deliService.deli_ser_id}</option>
									</c:if>
									<c:if test="${deliService.deli_ser_id != order.deli_ser_id }">
										<option value="${deliService.deli_ser_id}">${deliService.deli_ser_id}</option>
									</c:if>
								</c:forEach>
							</form:select>
						</div>
						<div class="mb-3">
							<label for="InputOrderNameRe" class="form-label">Name Receive</label>
							<form:input path="name_receiver" type="text" class="form-control" id="InputOrderNameRe" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputOrderPhoneRe" class="form-label">Phone Receive</label>
							<form:input pattern="[0-9]{10,10}" path="phone_receiver" type="text" class="form-control" id="InputOrderPhoneRe" required="required"/>
							<div id="phoneHelp" class="form-text">Nhập SDT gồm 10 số</div>
						</div>
						<div class="mb-3">
							<label for="InputOrderAddressRe" class="form-label">Address Receive</label>
							<form:input path="address_receiver" type="text" class="form-control" id="InputOrderAddressRe" required="required"/>
						</div>
						<div class="form-floating">
							<form:textarea path="note" class="form-control"
								placeholder="Note" id="floatingTextarea"
								style="height: 150px;"></form:textarea>
							<label for="floatingTextarea">Note</label>
						</div>
						<div class="mb-3">
							<label for="InputOrderTotal" class="form-label">Total</label>
							<form:input path="total" type="text" class="form-control" id="InputOrderTotal" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputOrderQuantity" class="form-label">Quantity</label>
							<form:input path="quantity" type="text" class="form-control" id="InputOrderQuantity" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputOrderDate" class="form-label">Date</label>
							<form:input path="date" type="date" class="form-control" id="InputOrderDate" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/don-hang/cac-don-hang/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>