<%@ include file="Header.jsp"%>
	<!-- LIGHT SECTION -->
	<section class="lightSection clearfix pageHeaderImage">
		<div class="container">
			<div class="tableBlock">
				<div class="row tableInner">
					<div class="col-xs-12">
						<div class="page-title">
							<h2>Cart</h2>
							<ol class="breadcrumb">
								<li><a href="Home">Home</a></li>
								<li class="active">cart</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	

	<!-- MAIN CONTENT SECTION -->
	<section class="mainContent clearfix cartListWrapper">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="cartListInner">
						<form action="#">
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th></th>
											<th>Product Name</th>
											<th>Price</th>
											<th>Quantity</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${orderList}" var="order" varStatus="status">
											<tr>
												<td class="col-xs-2">
													<button type="button" onclick="window.location.href='RemoveFromCart?id=${order.id}';" class="close" data-dismiss="alert"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button> <span class="cartImage"><img
														src="resources/image/products/${productList[status.index].id}.jpg"
														alt="image"></span>
												</td>
												<td class="col-xs-4">${productList[status.index].name}</td>
												<td class="col-xs-2">${productList[status.index].price}</td>
												<td class="col-xs-2">
													<div class="input-group">
														<input type="text" value="${order.quantity}"><a
											data-custom-idx="${order.id}" class="updateCart input-group-addon"><i class="fa fa-refresh"></i></a>
													</div>
												</td>
												<td class="col-xs-2">$${productList[status.index].price
													* order.quantity}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
	

							<div class=" totalAmountArea">
								<div class="row">
									<div class="col-sm-4 col-sm-offset-8 col-xs-12">
										<ul class="list-unstyled">
											<li>Total <span class="grandTotal">${total}</span></li>
										</ul>
									</div>
								</div>
							</div>
	

							<div class="checkBtnArea">
								<a href="checkout-step-1.html" class="btn btn-primary btn-block">checkout<i
									class="fa fa-arrow-circle-right" aria-hidden="true"></i></a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
	var list = document.querySelectorAll(".updateCart");
	for(i = 0; i < list.length; i++)
		list[i].addEventListener("click", function(){
			window.location.href="/ShoppingCart/UpdateCart?id=" + this.getAttribute("data-custom-idx") + "&quantity=" + this.parentNode.children[0].value;});
	</script>
	<%@ include file="Footer.jsp"%>

