<%@ include file="Header.jsp"%>
	<section class="lightSection pageHeader">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="page-title">
						<h2>Cart</h2>
					</div>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb pull-right">
						<li><a href="Home">Home</a></li>
						<li class="active">Cart</li>
					</ol>
				</div>
			</div>
			<div class="col-xs-12">
				<table class="table">
					<thead>
						<tr>
							<th>Image</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderList}" var="order">
							<tr>
								<td><a href="RemoveFromCart?id=${order.productID}"><i class="fa fa-times"></i></a></td>
								<td><img src="resources/image/products/${order.productID}.jpg"></td>
								<td>${order.productName}</td>
								<td>${order.Price}</td>
								<td>${order.quantity}</td>
								<td>${order.Price * order.quantity}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	

	<%@ include file="Footer.jsp"%>

