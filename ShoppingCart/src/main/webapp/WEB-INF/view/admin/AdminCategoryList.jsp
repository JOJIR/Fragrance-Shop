

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
								<th>Description</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${categoryList}" var="category">
								<tr>
									<td class="col-xs-1"><a href="EditCategory?id=${category.id}"><i class="fa fa-pencil"></i></a></td>
									<td class="col-xs-1"><a href="DeleteCategoryAttempt?id=${category.id}"><i class="fa fa-times"></i></a></td>							
									<td>${category.name}</td>
									<td>${category.description}</td>
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
			window.location.href = "/ShoppingCart/AdminCategoryList?sort=" + this.value;
		});
	</script>
	



