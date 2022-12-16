<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<title>Admin-Đăng nhập</title>
<div class="container-fluid position-relative bg-white d-flex p-0">
	<!-- Sign In Start -->
	<div class="container-fluid">
		<div class="row h-100 align-items-center justify-content-center"
			style="min-height: 100vh;">
			<div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
				<spring:form action="/BanThuCung/quan-tri/dang-nhap" method="POST" modelAttribute="admin_acc" class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
					<div class="d-flex align-items-center justify-content-between mb-3">
						<a href="#" class=""><h3 class="text-primary">ADMIN</h3></a>
						<h3>Sign In</h3>
					</div>
					<i>${AdChangeSuccess}</i>
					<div class="form-floating mb-3">
						<spring:input type="email" class="form-control" id="floatingInput"
							placeholder="Email Address" path="email" />
					</div>
					<div class="form-floating mb-4">
						<spring:input type="password" class="form-control" id="password-field"
							placeholder="Password" path="password" name="password"/>
					</div>
					<div class="d-flex align-items-center justify-content-between mb-4">
						<!-- <div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">Check me out</label>
						</div> -->
						<!-- <a href="">Forgot Password</a> -->
					</div>
					<button type="submit" class="btn btn-primary py-3 w-100 mb-4">SignIn</button>
					<!-- <p class="text-center mb-0">
						Don't have an Account? <a href="">Sign Up</a>
					</p> -->
				</spring:form>
			</div>
		</div>
	</div>
	<!-- Sign In End -->
</div>
