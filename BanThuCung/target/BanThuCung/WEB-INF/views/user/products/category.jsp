<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
	<title>Insert title here</title>
	<style>
		.pagination {
		  display: flex;
		  justify-content: center;
		}
		
		.pagination a {
		  color: black;
		  float: left;
		  padding: 8px 16px;
		  text-decoration: none;
		  transition: background-color .3s;
		  border: 1px solid #ddd;
		}
		
		.pagination a.active {
		  background-color: #4CAF50;
		  color: white;
		  border: 1px solid #4CAF50;
		}
		
		.pagination a:hover:not(.active) {background-color: #ddd;}
	</style>
</head>
<body>
	<h1>${products_byCatID.size()}</h1>
	<div class="well well-small">
		<div>
			<!-- <span style="margin-left: 25px;">
				Danh sách sản phẩm
			</span> -->
			<select class="pull-right">
				<option>A - Z</option>
				<option>Cao - Thấp</option>
			</select>
		</div>
		
		<h3>Danh sách sản phẩm</h3>
		
		<c:if test="${productsPaginates.size() > 0}">
			<div class="row-fluid">
				<ul class="thumbnails">
			<c:forEach var="item" items="${productsPaginates}" varStatus="loop">
				<li class="span4">
					<div class="thumbnail">
						<a href="product_details.html" class="overlay"></a> <a
							class="zoomTool" href="<c:url value="/chi-tiet-san-pham/${item.pro_id}"/>" title="view"><span
							class="icon-search"></span> QUICK VIEW</a> <a
							href="<c:url value="/chi-tiet-san-pham/${item.pro_id}"/>"><img src="<c:url value="/assets/user/img/products/${item.img}.jpg"/>"
							alt=""></a>
						<div class="caption cntr">
							<p>${item.pro_name}</p>
							<p>
								<strong><fmt:formatNumber type="number" groupingUsed="true" value="${item.price}" />₫</strong>
							</p>
							<h4>
								<a class="shopBtn" href="<c:url value="/addCart/${item.pro_id}" />" title="add to cart"> Add to cart
								</a>
							</h4>
							<div class="actionList">
								<a class="pull-left" href="#">Add to Wish List </a> <a
									class="pull-left" href="#"> Add to Compare </a>
							</div>
							<br class="clr">
						</div>
					</div>
				</li>
				<c:if test="${(loop.index + 1) % 3 == 0 || (loop.index + 1) == productsPaginates.size()}">
						</ul>
					</div>
					<c:if test="${(loop.index + 1) < productsPaginates.size()}">
						<div class="row-fluid">
							<ul class="thumbnails">
					</c:if>
				</c:if>
			</c:forEach>
		</c:if>
	</div>
	
	<div class="pagination">
		<c:forEach var="item" begin="1" end="${paginatesInfo.totalPage}" varStatus="loop">
		  <c:if test="${(loop.index) == paginatesInfo.currentPage}">
		  	<a href="<c:url value="/san-pham/${cat_id}/${loop.index}"/>" class="active">${loop.index}</a>
		  </c:if>
		  <c:if test="${(loop.index) != paginatesInfo.currentPage}">
		  	<a href="<c:url value="/san-pham/${cat_id}/${loop.index}"/>">${loop.index}</a>
		  </c:if>
	  	</c:forEach>
	</div>
</body>
</html>