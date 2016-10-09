<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ include file="../user/Header.jsp"%>

	<section class="mainContent logIn">
		<div class="container">
			<div class="row">
				<div
					class="col-md-10 col-md-offset-1 col-sm-8 col-sm-offset-2 col-xs-12">
					<div class="panel panel-inverse">
						<div class="panel-heading">
							<h3>Supplier Details</h3>
						</div>
						<div class="panel-body">
							<form:form action="AddSupplierAttempt" method="POST"
								modelAttribute="supplier" role="form">
								<div class="form-group">
									<form:label path="name">Supplier Name *</form:label>
									<form:input path="name" type="text" class="form-control"
										required="required" />
								</div>
	

								<div class="form-group">
									<form:label path="address">Supplier Address *</form:label>
									<form:input path="address" type="text" class="form-control"
										required="required" />
								</div>
								
								* <small>Required Fields</small>
	

								<input type="submit" value="Add Supplier"
									class="btn btn-primary btn-block" />
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="../user/Footer.jsp"%>

