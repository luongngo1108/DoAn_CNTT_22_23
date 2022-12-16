<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><decorator:title default="Master-layout" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value="/assets/user/css/bootstrap.css" />"
	rel="stylesheet" />
<!-- Customize styles -->
<link href="<c:url value="/assets/user/style.css" />" rel="stylesheet" />
<!-- font awesome styles -->
<link
	href="<c:url value="/assets/user/font-awesome/css/font-awesome.css" />"
	rel="stylesheet">

<!-- Favicons -->
<link rel="icon" href= "<c:url value="/assets/user/ico/favicon.ico" />">
<decorator:head/>
</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
							class="icon-facebook"></span></a> <a href="#"><span
							class="icon-youtube"></span></a> <a href="#"><span
							class="icon-tumblr"></span></a>
					</div>
					<a class="active" href="<c:url value="/trang-chu/"/>"> <span class="icon-home"></span>
						Home</a>
					<c:if test="${not empty loginInfo}">
						<a href="#"><span class="icon-user"></span>${loginInfo.name}</a>
						<a href="<c:url value="/dang-xuat"/>"><span class="icon-edit"></span>
							Đăng xuất</a>
					</c:if>
					<c:if test="${empty loginInfo}">
						<a href="<c:url value="/dang-ky/"/>"><span class="icon-edit"></span> 
							Đăng kí/Đăng nhập </a> 
					</c:if>
					<a href="<c:url value="/contact/"/>"><span class="icon-envelope"></span> Contact us </a> 
					<a href="<c:url value="/listcart/"/>"><span
						class="icon-shopping-cart"></span> ${TotalQuantityCart} sản phẩm - <span
						class="badge badge-warning"> <fmt:formatNumber type="number" groupingUsed="true" value="${TotalPriceCart}" />₫</span></a>
				</div>
			</div>
		</div>
	</div>


	<div class="container">
		<div id="gototop"></div>

		<!--Lower Header Section -->
		<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>

		<decorator:body />

		<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>
	</div>


	<%@include file="/WEB-INF/views/layouts/user/copyright.jsp"%>

	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/assets/user/js/jquery.js"/>"></script>
	<script src="<c:url value="/assets/user/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/jquery.easing-1.3.min.js"/>"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.scrollTo-1.4.3.1-min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/shop.js"/>"></script>
	
	<decorator:getProperty property="page.script"></decorator:getProperty>
</body>
</html>

