<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style type="text/css">
	.product-content {
		overflow-x: hidden;
	}
</style>
</head>
<body>
<!-- Body Section -->
	<div class="row product-content">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${categories}" varStatus="index">
						<li><a href='<c:url value="/san-pham/${item.cat_id}"/>'><span
								class="icon-chevron-right"></span>${item.name}</a></li>
					</c:forEach>
					<li style="border: 0">&nbsp;</li>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br>
					<br>
					<a class="defaultBtn" href="#">Click here </a>
				</p>
			</div>
			<div class="well well-small">
				<a href="#"><img src="assets/img/paypal.jpg"
					alt="payment method paypal"></a>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
			<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="<c:url value="/assets/user/img/products/3.jpg"/>"
							alt="bootstrap ecommerce templates">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> 
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="<c:url value="/assets/user/img/products/18.jpg"/>"
							alt="shopping cart template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> 
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool" href="product_details.html"
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img src="<c:url value="/assets/user/img/products/32.jpg"/>"
							alt="bootstrap template">
						<div class="caption">
							<h4>
								<a class="defaultBtn" href="product_details.html">VIEW</a> 
							</h4>
						</div>
					</div>
				</li>
			</ul>

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="<c:url value="/trang-chu/"/>">Trang chủ</a> <span class="divider">/</span></li>
				<li><a href="#">Sản phẩm</a> <span class="divider">/</span></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
			<div class="well well-small">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img src="<c:url value="/assets/user/img/products/${product.img}.jpg"/>" alt=""
										style="width: 100%"></a>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">›</a>
						</div>
					</div>
					<div class="span7">
						<h3>${product.pro_name}</h3>
						<hr class="soft" />

						<form class="form-horizontal qtyFrm" method="get" action='<c:url value="/addCart/${product.pro_id}" />'>
							<div class="control-group">
								<label class="control-label"><span><fmt:formatNumber type="number" groupingUsed="true" value="${product.price}" />₫</span></label>
								<div class="controls">
									<input type="number" min="1" value="1" class="span6">
								</div>
							</div>
							<c:if test="${product.color_id != null}">
								<div class="control-group">
									<label class="control-label"><span>Color</span></label>
									<div class="controls">
										<form:select path="product.color_id">
											<c:forEach var="color" items="${color_type}">
												<option value="${color.color_id}">${color.type}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</c:if>
							
							<c:if test="${product.petwei_id != null}">
								<div class="control-group">
									<label class="control-label"><span>Pet Weight</span></label>
									<div class="controls">
										<form:select path="product.petwei_id">
											<c:forEach var="petwei" items="${petwei_type}">
												<option value="${petwei.petwei_id}">${petwei.type}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</c:if>
							
							<c:if test="${product.foodwei_id != null}">
								<div class="control-group">
									<label class="control-label"><span>Food Weight</span></label>
									<div class="controls">
										<form:select path="product.foodwei_id">
											<c:forEach var="foodwei" items="${foodwei_type}">
												<option value="${foodwei.foodwei_id}">${foodwei.type}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</c:if>
							
							<c:if test="${product.foodfla_id != null}">
								<div class="control-group">
									<label class="control-label"><span>Food Flavorings</span></label>
									<div class="controls">
										<form:select path="product.foodfla_id">
											<c:forEach var="foodfla" items="${foodfla_type}">
												<option value="${foodfla.foodfla_id}">${foodfla.type}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</c:if>
							
							<c:if test="${product.materials_id != null}">
								<div class="control-group">
									<label class="control-label"><span>Materials</span></label>
									<div class="controls">
										<form:select path="product.petwei_id">
											<c:forEach var="petwei" items="${petwei_type}">
												<option value="${petwei.petwei_id}">${petwei.type}</option>
											</c:forEach>
										</form:select>
									</div>
								</div>
							</c:if>
							
							<h4>${product.quantity} sản phẩm có sẵn trong kho</h4>
							<p>${product.detail}</p>
								<button type="submit" class="shopBtn">
									<span class=" icon-shopping-cart"></span> Thêm giỏ hàng
								</button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />


				<ul id="productDetail" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
					<li class=""><a href="#profile" data-toggle="tab">Sản phẩm liên quan </a></li>
				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					<div class="tab-pane fade active in" id="home">
						<h4>Product Information</h4>
						<table class="table table-striped">
							<tbody>
								<c:if test="${product.color_id != null}">
									<tr class="techSpecRow">
										<td class="techSpecTD1">Color:</td>
										<td class="techSpecTD2">${product.cl_type}</td>
									</tr>
								</c:if>
								<c:if test="${product.petwei_id != null}">
									<tr class="techSpecRow">
										<td class="techSpecTD1">Pet Weight:</td>
										<td class="techSpecTD2">${product.pw_type}</td>
									</tr>
								</c:if>
								<c:if test="${product.foodwei_id != null}">
									<tr class="techSpecRow">
										<td class="techSpecTD1">Food Weight:</td>
										<td class="techSpecTD2">${product.fw_type}</td>
									</tr>
								</c:if>
								<c:if test="${product.foodfla_id != null}">
									<tr class="techSpecRow">
										<td class="techSpecTD1">Food Flavorings:</td>
										<td class="techSpecTD2">${product.ff_type}</td>
									</tr>
								</c:if>
								<c:if test="${product.materials_id != null}">
									<tr class="techSpecRow">
										<td class="techSpecTD1">Materials:</td>
										<td class="techSpecTD2">${product.ma_type}</td>
									</tr>
								</c:if>
							</tbody>
						</table>
						<p>Mô tả sản phẩm: </p>
					</div>
					
					<div class="tab-pane fade" id="profile">
						<c:set var = "countList" value="${productsByCat_ID.size()}"/>
						<c:if test="${productsByCat_ID.size() > 6}">
							<c:set var = "countList" value="6"/>
						</c:if>
						<c:forEach var="item" items="${productsByCat_ID}" begin="1" end="${countList}" varStatus="loop">
							<div class="row-fluid">
								<div class="span2">
									<img src="<c:url value="/assets/user/img/products/${item.img}.jpg"/>" alt="">
								</div>
								<div class="span6">
									<h5>${item.pro_name}</h5>
									<p>${item.detail}</p>
								</div>
								<div class="span4 alignR">
									<form class="form-horizontal qtyFrm">
										<h3><fmt:formatNumber type="number" groupingUsed="true" value="${item.price}" />₫</h3>
										<div class="btn-group">
											<a href="<c:url value="/addCart/${item.pro_id}" />" class="defaultBtn"><span
												class=" icon-shopping-cart"></span> Add to cart</a> 
												<a href="<c:url value="/chi-tiet-san-pham/${item.pro_id}"/>" class="shopBtn">VIEW</a>
										</div>
									</form>
								</div>
							</div>
							<hr class="soft">
						</c:forEach>
						
						
						
					</div>
				</div>

			</div>
		</div>
	</div>
<!-- Body wrapper -->
</body>