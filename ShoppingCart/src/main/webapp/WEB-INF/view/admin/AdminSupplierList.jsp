<%@ include file="../user/Header.jsp"%>


<!-- MAIN CONTENT SECTION -->
<section class="adminHome mainContent clearfix productsContent">
		<div class="container">
		<div class="row">
		<div class="col-xs-12">
				<table class="table supplierTable">
					<thead>
						<tr>
							<th>Edit</th>
							<th>Delete</th>
							<th>Name</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${supplierList}" var="supplier">
							<tr>
								<td class="col-xs-1"><a href="EditSupplier?id=${supplier.id}"><i class="fa fa-pencil"></i></a></td>
								<td class="col-xs-1"><a href="DeleteSupplierAttempt?id=${supplier.id}"><i class="fa fa-times"></i></a></td>
								<td>${supplier.name}</td>
								<td>${supplier.address}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</div>
			</div>
</section>
<script>
	var e = document.querySelector("#sortOrder");
	e.value = ${sortOrder};
	e.addEventListener("change", function() {
		window.location.href = "/ShoppingCart/AdminSupplierList?sort=" + this.value;
	});
</script>
<%@ include file="../user/Footer.jsp"%>