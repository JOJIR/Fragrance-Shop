<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="Header.jsp"%>
<!-- LIGHT SECTION -->
<section class="lightSection clearfix pageHeader">
	<div class="container">
		<div class="row">
			<div class="col-xs-6">
				<div class="page-title">
					<h2>Supplier List</h2>
				</div>
			</div>
			<div class="col-xs-6">
				<ol class="breadcrumb pull-right">
					<li><a href="Home">Home</a></li>
					<li><a href="AdminHome">Admin Home</a></li>
					<li class="active">Admin Supplier List</li>
				</ol>
			</div>
		</div>
	</div>
</section>

<!-- MAIN CONTENT SECTION -->
<section class="mainContent clearfix productsContent">
	<div class="container">
		<div class="row">
		<div class="col-xs-12">
				<table class="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${supplierList}" var="supplier">
							<tr>
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
<%@ include file="Footer.jsp"%>