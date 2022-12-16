<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta charset="utf-8">
<title><decorator:title default="Master-layout" /></title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="<c:url value="" />img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="<c:url value="https://fonts.googleapis.com" />">
<link rel="preconnect" href="<c:url value="https://fonts.gstatic.com" />" crossorigin>
<link
	href="<c:url value="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" />"
	rel="stylesheet" />

<!-- Icon Font Stylesheet -->
<link
	href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" />"
	rel="stylesheet" />

<!-- Libraries Stylesheet -->
<link href="<c:url value="/assets/admin/lib/owlcarousel/assets/owl.carousel.min.css" />"
	rel="stylesheet" />
<link href="<c:url value="/assets/admin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" />"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="<c:url value="/assets/admin/css/bootstrap.min.css"/>" rel="stylesheet" />

<!-- Template Stylesheet -->
<link href="<c:url value="/assets/admin/css/style.css" />" rel="stylesheet" />
</head>

<body>
	<%@include file="/WEB-INF/views/layouts/admin/spinner.jsp"%>
	
	<decorator:body />
	<!-- JavaScript Libraries -->
	<script src="<c:url value="https://code.jquery.com/jquery-3.4.1.min.js" />"></script>
	<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" />" ></script>
	<script src="<c:url value="/assets/admin/lib/chart/chart.min.js" />"></script>
	<script src="<c:url value="/assets/admin/lib/easing/easing.min.js" />"></script>
	<script src="<c:url value="/assets/admin/lib/waypoints/waypoints.min.js" />"></script>
	<script src="<c:url value="/assets/admin/lib/owlcarousel/owl.carousel.min.js" />"></script>
	<script src="<c:url value="/assets/admin/lib/tempusdominus/js/moment.min.js" />"></script>
	<script src="<c:url value="/assets/admin/lib/tempusdominus/js/moment-timezone.min.js" />"></script>
	<script src="<c:url value="/assets/admin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js" />"></script>

	<!-- Template Javascript -->
	<script src="<c:url value="/assets/admin/js/main.js" />"></script>
</body>

</html>


