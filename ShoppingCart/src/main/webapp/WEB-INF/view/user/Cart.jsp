<%@ include file="Header.jsp"%>
<!-- LIGHT SECTION -->
<section class="lightSection clearfix pageHeaderImage">
	<div class="container">
		<div class="tableBlock">
			<div class="row tableInner">
				<div class="col-xs-10">
					<div class="page-title">

						<ol class="breadcrumb">
							<li><a href="Home">Home</a></li>
							<li class="active">Cart</li>
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
			<div class="col-xs-10">
				<div class="cartListInner">
					<form action="#">
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th></th>
										<th><font color="violet">Product Name</font></th>
										<th><font color="violet">Price</font></th>
										<th><font color="violet">Quantity</font></th>
										<th><font color="violet">Total</font></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${orderList}" var="order" varStatus="status">
										<tr>
											<td class="col-xs-2">
												<button type="button"
													onclick="window.location.href='RemoveFromCart?id=${order.id}';"
													class="close" data-dismiss="alert" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button> <span class="cartImage"><img class="indexproducts"
													src="resources/image/products/${productList[status.index].id}.jpg"
													alt="image"></span>
											</td>
											<td class="col-xs-4"><font color="darkgrey">${productList[status.index].name}</font></td>
											<td class="col-xs-2"><font color="darkgrey">${productList[status.index].price}</font></td>
											<td class="col-xs-2">
												<div class="input-group">
													<input type="text" value="${order.quantity}"><a
														data-custom-idx="${order.id}"
														class="updateCart input-group-addon"><i
														class="fa fa-refresh"></i></a>
												</div>
											</td>
											<td class="col-xs-2"><font color="darkgrey">$${productList[status.index].price
													* order.quantity}</font></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>


						<div class=" totalAmountArea">
							<div class="row">
								<div class="col-sm-4 col-sm-offset-8 col-xs-10">
									<ul class="list-unstyled">
										<li><font color="violet">Total </font><span
											class="grandTotal"><font color="darkgrey">${total}</font></span></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="checkBtnArea">
							<a href="CheckOut.obj" class="btn btn-primary btn-block">CheckOut</a>
							
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<script>
	var list = document.querySelectorAll(".updateCart");
	for (i = 0; i < list.length; i++)
		list[i].addEventListener("click", function() {
			window.location.href = "/ShoppingCart/UpdateCart?id="
					+ this.getAttribute("data-custom-idx") + "&quantity="
					+ this.parentNode.children[0].value;
		});
</script>
<%@ include file="Footer.jsp"%>