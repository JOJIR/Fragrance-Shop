<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ include file="../user/Header.jsp"%>
	<section class="adminHome mainContent logIn">
		<div class="container">
			<div class="row">
				<div
					class="col-md-10 col-md-offset-1 col-sm-8 col-sm-offset-2 col-xs-12">
					<div class="panel panel-inverse">
						<div class="panel-heading">
							<h3>Category Details</h3>
						</div>
						<div class="panel-body">
							<form:form action="EditCategoryAttempt" method="POST"
								modelAttribute="category" role="form">
								<div class="form-group">
									<form:label path="id">Category ID *</form:label>
									<form:input path="id" type="text" class="form-control"
										autofocus="autofocus" required="required" />
								</div>
								<div class="form-group">
									<form:label path="name">Category Name *</form:label>
									<form:input path="name" type="text" class="form-control"
										required="required" />
								</div>
	

								<div class="form-group">
									<form:label path="description">Category Description</form:label>
									<form:input path="description" type="text" class="form-control"
										required="required" />
								</div>
								
								* <small>Required Fields</small>
	

								<input type="submit" value="Update Category"
									class="btn btn-primary btn-block" />
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
		<%@ include file="../user/Footer.jsp"%>

	