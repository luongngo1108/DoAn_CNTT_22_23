<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Category Form</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-6">
			<div class="bg-light rounded h-100 p-4">
				<c:if test="${product.pro_id !=null && product.proper_id != null}">
					<h6 class="mb-4">Edit Product ${product.pro_id}</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/cac-san-pham/update" modelAttribute="product" >
						<div class="mb-3">
							<label for="InputProductID" class="form-label">Product ID</label> 
								<form:input pattern="PR+[0-9]{3,3}" path="pro_id" type="text" class="form-control" id="InputProductID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: PR001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="proper_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="proper" items="${properList}">
									<c:if test="${proper.proper_id == product.proper_id }">
										<option selected value="${proper.proper_id}">${proper.proper_id}</option>
									</c:if>
									<c:if test="${proper.proper_id != product.proper_id }">
										<option value="${proper.proper_id}">${proper.proper_id}</option>
									</c:if>
								</c:forEach>
								<c:if test="${product.proper_id == null}">
									<option selected value="null">null</option>
								</c:if>
								<c:if test="${product.proper_id != null}">
									<option value="null">null</option>
								</c:if>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="cat_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="cat" items="${catList}">
									<c:if test="${cat.cat_id == product.cat_id }">
										<option selected value="${cat.cat_id}">${cat.cat_id}</option>
									</c:if>
									<c:if test="${cat.cat_id != product.cat_id }">
										<option value="${cat.cat_id}">${cat.cat_id}</option>
									</c:if>
								</c:forEach>
								<c:if test="${product.cat_id == null}">
									<option selected value="null">null</option>
								</c:if>
								<c:if test="${product.cat_id != null}">
									<option value="null">null</option>
								</c:if>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="sup_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="sup" items="${supList}">
									<c:if test="${sup.sup_id == Product.sup_id }">
										<option selected value="${sup.sup_id}">${sup.sup_id}</option>
									</c:if>
									<c:if test="${sup.sup_id != Product.sup_id }">
										<option value="${sup.sup_id}">${sup.sup_id}</option>
									</c:if>		
								</c:forEach>
								<c:if test="${product.sup_id == null}">
									<option selected value="null">null</option>
								</c:if>
								<c:if test="${product.sup_id != null}">
									<option value="null">null</option>
								</c:if>
							</form:select>
						</div>
						<div class="mb-3">
							<label for="InputProName" class="form-label">Name</label>
							<form:input path="pro_name" type="text" class="form-control" id="InputProName" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputProQuantity" class="form-label">Quantity</label>
							<form:input path="quantity" min="0" type="number" class="form-control" id="InputProQuantity" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputProPrice" class="form-label">Price</label>
							<form:input path="price" type="text" class="form-control" id="InputProPrice" required="required"/>
						</div>
						<label class="form-label">Highlight</label>
						<div class="form-floating mb-3">		
							<form:select path="highlight" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<option selected value="${product.highlight}">${product.highlight}</option>
								<c:if test="${product.highlight == true }"><option value="false">false</option></c:if>
								<c:if test="${product.highlight == false }"><option value="true">true</option></c:if>
							</form:select>
						</div>
						<label class="form-label">New product</label>
						<div class="form-floating mb-3">
							<form:select path="new_product" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<option selected value="${product.new_product}">${product.new_product}</option>
								<c:if test="${product.new_product == true }"><option value="false">false</option></c:if>
								<c:if test="${product.new_product == false }"><option value="true">true</option></c:if>
							</form:select>
						</div>
						<div class="form-floating">
							<form:textarea path="detail" class="form-control"
								placeholder="Detail here" id="floatingTextarea"
								style="height: 150px;"></form:textarea>
							<label for="floatingTextarea">Details</label>
						</div>
						<div class="mb-3">
							<label for="InputProCreatedAt" class="form-label">Created at</label>
							<form:input path="created_at" type="date" class="form-control" id="InputProCreatedAt" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputProUpdatedAt" class="form-label">Updated at</label>
							<form:input path="updated_at" type="date" class="form-control" id="InputProUpdatedAt" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputProIMG" class="form-label">Image</label>
							<form:input path="img" type="text" class="form-control" id="InputProIMG" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/cac-san-pham/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
				<c:if test="${Product._id == null && product.proper_id == null}">
					<h6 class="mb-4">Add new Product</h6>
					<i>${error}</i>
					<form:form id="myForm" method="POST" action="/BanThuCung/quan-tri/san-pham/cac-san-pham/create" modelAttribute="product" >
						<div class="mb-3">
							<label for="InputProductID" class="form-label">Product ID</label> 
								<form:input pattern="PR+[0-9]{3,3}" path="pro_id" type="text" class="form-control" id="InputProductID"  aria-describedby="idHelp" required="required"/>
							<div id="idHelp" class="form-text">Vui lòng nhập đúng theo mã định dạng, vd: PR001</div>
						</div>
						<div class="form-floating mb-3">
							<form:select path="proper_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="proper" items="${properList}">
									<option value="${proper.proper_id}">${proper.proper_id}</option>
								</c:forEach>
								<option selected value="null">null</option>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="cat_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="cat" items="${catList}">
									<option value="${cat.cat_id}">${cat.cat_id}</option>
								</c:forEach>
								<option selected value="null">null</option>
							</form:select>
						</div>
						<div class="form-floating mb-3">
							<form:select path="sup_id" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<c:forEach var="sup" items="${supList}">
									<option value="${sup.sup_id}">${sup.sup_id}</option>
								</c:forEach>
								<option selected value="null">null</option>
							</form:select>
						</div>
						<div class="mb-3">
							<label for="InputProName" class="form-label">Name</label>
							<form:input path="pro_name" type="text" class="form-control" id="InputProName" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputProQuantity" class="form-label">Quantity</label>
							<form:input path="quantity" min="0" type="number" class="form-control" id="InputProQuantity" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputProPrice" class="form-label">Price</label>
							<form:input path="price" type="text" class="form-control" id="InputProPrice" required="required"/>
						</div>
						<label class="form-label">Highlight</label>
						<div class="form-floating mb-3">		
							<form:select path="highlight" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<option value="false">false</option>
								<option selected value="true">true</option>
							</form:select>
						</div>
						<label class="form-label">New product</label>
						<div class="form-floating mb-3">
							<form:select path="new_product" class="form-select" id="floatingSelect"
								aria-label="Floating label select example"
								style="padding-top: 0px !important; padding-bottom: 0px !important;">
								<option value="false">false</option>
								<option selected value="true">true</option>
							</form:select>
						</div>
						<div class="form-floating">
							<form:textarea path="detail" class="form-control"
								placeholder="Detail here" id="floatingTextarea"
								style="height: 150px;"></form:textarea>
							<label for="floatingTextarea">Details</label>
						</div>
						<div class="mb-3">
							<label for="InputProCreatedAt" class="form-label">Created at</label>
							<form:input path="created_at" type="date" class="form-control" id="InputProCreatedAt" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputProUpdatedAt" class="form-label">Updated at</label>
							<form:input path="updated_at" type="date" class="form-control" id="InputProUpdatedAt" required="required"/>
						</div>
						<div class="mb-3">
							<label for="InputProIMG" class="form-label">Image</label>
							<form:input path="img" type="text" class="form-control" id="InputProIMG" required="required"/>
						</div>
						<button type="submit" class="btn btn-primary">Save</button>
						<a href="/BanThuCung/quan-tri/san-pham/cac-san-pham/list"><button style="margin-left: 100px !important" type="button" class="btn btn-danger m-2">Quay lại</button></a>
					</form:form>
				</c:if>
			</div>
		</div>
	</div>
</div>