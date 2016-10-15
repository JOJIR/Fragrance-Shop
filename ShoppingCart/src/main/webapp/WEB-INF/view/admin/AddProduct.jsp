<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section class="mainContent logIn">
	<div class="container">
		<div class="row">
			<div
				class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-6">
				<div class="panel panel-inverse">
					<div class="panel-heading">
						<h3>Product Details</h3>
					</div>
					<div class="panel-body">
						<form:form action="AddProductAttempt" method="POST"
							modelAttribute="product" enctype="multipart/form-data"
							role="form">
							<div class="form-group">
								<form:label path="id">Product ID *</form:label>
								<form:input path="id" type="text" class="form-control"
									autofocus="autofocus" required="required" />
								<form:label path="name">Product Name *</form:label>
								<form:input path="name" type="text" class="form-control"
									required="required" />
							</div>
							<form:radiobuttons path="category.id" items="${categoryList}"
								required="required" />
							<div class="form-group">
								<form:label path="description">Description</form:label>
								<form:textarea rows="5" cols="5" path="description"
									class="form-control" />
							</div>
							<div class="form-group">
								<form:label path="price">Price *</form:label>
								<form:input path="price" type="text" class="form-control"
									required="" />
							</div>
							<div class="form-group">
							<form:label path="quantity">Quantity *</form:label>
							<form:input path="quantity" type="text" class="form-control"
								required="required" />
								</div>
							<div class="form-group">
							<form:label path="supplier.id">Supplier *</form:label>
							<form:select class="sbSelector" path="supplier.id" items="${supplierList}" />
							</div>
							<div class="form-group">
							<form:label path="image">Image</form:label>
							<form:input type="file" path="image" />
							</div>
							* <small>Required Fields</small>

							<input type="submit" value="Add Product"
								class="btn btn-primary btn-block" />
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
