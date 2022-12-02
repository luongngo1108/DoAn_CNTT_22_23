<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<title>Categories</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-12">
			<a href="/BanThuCung/quan-tri/san-pham/cac-san-pham/productForm"><button type="button" class="btn btn-secondary m-2">Add new product</button></a>
			<h5 style="color:red">${filesuccess}</h5>  
			<form:form method="post" action="/BanThuCung/quan-tri/san-pham/cac-san-pham/savefile" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="formFile" class="form-label">Upload ảnh sản phẩm</label> 
				<input name="file" id="fileToUpload"  class="form-control" type="file" id="formFile">
			</div>
			<p><input type="submit" value="Upload"></p> 
			</form:form>
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">Danh sách các sản phẩm</h6>
				<i>${errorDelProductMessage}</i>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Product ID</th>
							<th scope="col">Property ID</th>
							<th scope="col">Category ID</th>
							<th scope="col">Supplier ID</th>
							<th scope="col">Name</th>
							<th scope="col">Quantity</th>
							<th scope="col">Price</th>
							<th scope="col">Highlight</th>
							<th scope="col">New Product</th>
							<th scope="col">Detail</th>
							<th scope="col">Created at</th>
							<th scope="col">Updated at</th>
							<th scope="col">Image name</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${productList}">
							<tr>
								<td><c:out value="${product.pro_id}" /></td>
								<td><c:out value="${product.proper_id }" /></td>
								<td><c:out value="${product.cat_id}" /></td>
								<td><c:out value="${product.sup_id}" /></td>
								<td><c:out value="${product.pro_name}" /></td>
								<td><c:out value="${product.quantity}" /></td>
								<td><c:out value="${product.price}" /></td>
								<td><c:out value="${product.highlight}" /></td>
								<td><c:out value="${product.new_product}" /></td>
								<td><c:out value="${product.detail}" /></td>
								<td><c:out value="${product.created_at}" /></td>
								<td><c:out value="${product.updated_at}" /></td>
								<td><c:out value="${product.img}" /></td>
								<td><a href="edit/${product.pro_id}/${product.proper_id} ">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete/${product.pro_id}/${product.proper_id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>