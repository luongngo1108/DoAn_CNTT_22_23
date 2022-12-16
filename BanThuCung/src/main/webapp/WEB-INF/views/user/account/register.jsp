<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<title>Đăng kí tài khoản</title>
</head>
<body>
	<div class="row">
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="<c:url value="/trang-chu/"/>">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Đăng kí</li>
			</ul>
			<h3>Người dùng</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>Đăng kí tài khoản</h5>
						<i><h5 style="color:red">${status }</h5></i>
						<br />
						<form:form action="/BanThuCung/dang-ky" method="POST" modelAttribute="account">
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail</label>
								<div class="controls">
									<form:input class="span3" type="email" placeholder="Mời nhập email" path="email" />  
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="inputName">Họ và tên</label>
								<div class="controls">
									<form:input class="span3" type="text" placeholder="Mời nhập họ và tên" path="name" />  
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="inputPassword">Mật khẩu</label>
								<div class="controls">
									<form:input class="span3" type="password" placeholder="Mời nhập mật khẩu" path="password" />  
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="inputPhone">Số điện thoại</label>
								<div class="controls">
									<form:input class="span3" type="text" placeholder="Mời nhập số điện thoại" path="phone" />  
								</div>
							</div>
							
							<div class="control-group">
								<label class="control-label" for="inputAddress">Địa chỉ</label>
								<div class="controls">
									<form:input class="span3" type="text" placeholder="Mời nhập địa chỉ" path="address" />  
								</div>
							</div>
							
							<div class="controls">
								<button type="submit" class="btn block">Đăng kí</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>Đăng nhập hệ thống</h5>
						<form:form action="/BanThuCung/dang-nhap" method="POST" modelAttribute="account">
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls">
									<form:input class="span3" type="email" placeholder="Mời nhập email" path="email" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Mật khẩu</label>
								<div class="controls">
									<form:input class="span3" type="password" placeholder="Mời nhập mật khẩu" path="password" />
								</div>
							</div>
							<h3>${statusLogin}</h3>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn">Đăng nhập</button>
									<a href="#">Quên mật khẩu?</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
