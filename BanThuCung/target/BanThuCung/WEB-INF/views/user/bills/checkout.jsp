<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Thanh toán</title>
</head>
<body>
	<div class="row">
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Thanh toán</li>
			</ul>
			<h3>Người dùng</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span9">
					<div class="well">
						<br />
						<form:form action="/BanThuCung/checkout" method="POST" modelAttribute="orders" class="form-horizontal">
							<h4 style="color:red">${ errorLogin}</h4>
							<h3>Thanh toán đơn hàng</h3>
							<div class="control-group">
								<label class="control-label">Họ tên người nhận <sup>*</sup></label>
								<div class="controls">
									<form:input type="text" placeholder="Mời nhập họ tên"
										path="name_receiver" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Email <sup>*</sup></label>
								<div class="controls">
									<form:input type="email" class="span3"
										placeholder="Mời nhập email" path="email" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Liên hệ <sup>*</sup></label>
								<div class="controls">
									<form:input type="text" class="span3" placeholder="phone"
										path="phone_receiver" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Địa chỉ giao hàng <sup>*</sup></label>
								<div class="controls">
									<form:textarea path="address_receiver" row="5" col="30" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Hình thức thanh toán <sup>*</sup></label>
								<form:select path="pay_id" class="controls">
									<c:forEach var="pay" items="${payment}">
										<option value="${pay.pay_id}">${pay.name}</option>
									</c:forEach>
								</form:select>
							</div>
							<div class="control-group">
								<label class="control-label">Vận chuyển <sup>*</sup></label>
								<form:select path="deli_ser_id" class="controls">
									<c:forEach var="deli" items="${deli_ser}">
										<option value="${deli.deli_ser_id}">${deli.type}</option>
									</c:forEach>
								</form:select>
							</div>
							<div class="control-group">
								<label class="control-label">Ghi chú <sup>*</sup></label>
								<div class="controls">
									<form:textarea path="note" row="5" col="30" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Đặt hàng"
										class="shopBtn exclusive">
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
			</div>

		</div>
	</div>
</body>
