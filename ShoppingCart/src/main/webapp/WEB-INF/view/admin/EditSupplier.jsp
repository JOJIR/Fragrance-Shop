<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section class="adminHome mainContent logIn">
		<div class="container">
			<div class="row">
				<div
					class="col-md-8 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-6">
					<div class="panel panel-inverse">
						<div class="panel-heading">
							<h3>Supplier Details</h3>
						</div>
						<div class="panel-body">
							<form:form action="EditSupplierAttempt" method="POST"
								modelAttribute="supplier" role="form">
								<div class="form-group">
									<form:hidden path="id"></form:hidden>
									<form:label path="name">Supplier Name *</form:label>
									<form:input path="name" type="text" class="form-control"
										autofocus="autofocus" required="required" />
								</div>
	

								<div class="form-group">
									<form:label path="address">Supplier Address *</form:label>
									<form:input path="address" type="text" class="form-control"
										required="required" />
								</div>
								
								* <small>Required Fields</small>
	

								<input type="submit" value="Update Supplier"
									class="btn btn-primary btn-block" />
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
