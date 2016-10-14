


<!-- MAIN CONTENT SECTION -->
<section class="adminHome mainContent clearfix productsContent">
		<div class="container">
		<div class="row">
		<div class="col-xs-12">
				<table class="table supplierTable">
					<thead>
						<tr>
							<th><font color="violet">EDIT</font></th>
							<th><font color="violet">DELETE</font></th>
							<th><font color="violet">NAME</font></th>
							<th><font color="violet">ADDRESS</font></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${supplierList}" var="supplier">
							<tr>
								<td class="col-xs-1"><a href="EditSupplier?id=${supplier.id}"><i class="fa fa-pencil"></i></a></td>
								<td class="col-xs-1"><a href="DeleteSupplierAttempt?id=${supplier.id}"><i class="fa fa-times"></i></a></td>
								<td><font color="darkgrey"><b>${supplier.name}</b></font></td>
								<td><font color="darkgrey"><b>${supplier.address}</b></font></td>
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
