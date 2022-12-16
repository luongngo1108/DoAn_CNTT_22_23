<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Categories</title>
<div class="container-fluid pt-4 px-4">
	<div class="row g-4">
		<div class="col-sm-12 col-xl-12">
			<a href="/BanThuCung/quan-tri/don-hang/cac-don-hang/orderForm"><button type="button" class="btn btn-secondary m-2">Add new order</button></a>
			<div class="bg-light rounded h-100 p-4">
				<h6 class="mb-4">Danh sách các đơn hàng</h6>
				<i>${errorDelOrderMessage}</i>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Order ID</th>
							<th scope="col">Account Name</th>
							<th scope="col">Payment</th>
							<th scope="col">Deliver Service</th>
							<th scope="col">Name Receive</th>
							<th scope="col">Phone Receive</th>
							<th scope="col">Address Receive</th>
							<th scope="col">Note</th>
							<th scope="col">Total</th>
							<th scope="col">Quantity</th>
							<th scope="col">Date</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="order" items="${orderList}">
							<tr>
								<td><c:out value="${order.order_id}" /></td>
								<c:choose>
									<c:when test="${order.acc_id != null}">
										<c:forEach var="acc" items="${cusAccList}">
											<c:if test="${acc.acc_id == order.acc_id}">
												<td><c:out value="${acc.name}" /></td>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td><c:out value=" " /></td>
   									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${order.pay_id != null}">
										<c:forEach var="pay" items="${payList}">
											<c:if test="${pay.pay_id == order.pay_id}">
												<td><c:out value="${pay.name}" /></td>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td><c:out value=" " /></td>
   									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${order.deli_ser_id != null}">
										<c:forEach var="deliService" items="${deliServiceList}">
											<c:if test="${deliService.deli_ser_id == order.deli_ser_id}">
												<td><c:out value="${deliService.type}" /></td>
											</c:if>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td><c:out value=" " /></td>
   									</c:otherwise>
								</c:choose>
								<td><c:out value="${order.name_receiver}" /></td>
								<td><c:out value="${order.phone_receiver}" /></td>
								<td><c:out value="${order.address_receiver}" /></td>
								<td><c:out value="${order.note}" /></td>
								<td><c:out value="${order.total}" /></td>
								<td><c:out value="${order.quantity}" /></td>
								<td><c:out value="${order.date}" /></td>
								<td><a href="edit/${order.order_id} ">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; <a
									href="delete/${order.order_id}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>