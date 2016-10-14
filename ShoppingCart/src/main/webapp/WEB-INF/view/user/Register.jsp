
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="Header.jsp"%>
<!-- LIGHT SECTION -->
<section class="lightSection clearfix pageHeader">
	<div class="container">
		<div class="row">
			<div
				class="col-xs-10 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
					<h2>
						<font color='skyblue'>Please Sign Up </font><small><font color='white'>It's free and always will be.</font></small>
					</h2>
					<div class="col-xs-6">
						<ol class="breadcrumb pull-right">
							<li><a href="Home">Home</a></li>
							<li class="active">Sign up</li>
						</ol>
					</div>
			</div>
		</div>
	</div>
</section>



<!-- MAIN CONTENT SECTION -->
<section class="mainContent signUp">
	<div class="container">
		<div class="row">
			<div
				class="col-md-10 col-md-offset-1 col-sm-8 col-sm-offset-2 col-xs-12">
				<div class="panel panel-inverse">
					<div class="panel-heading">
						<h3>Sign up</h3>
					</div>
					<div class="panel-body">
						<form:form  method="POST"
							modelAttribute="user" role="form">
							<div class="form-group">
								<form:label path="firstName">First Name *</form:label>
								<form:input path="firstName" type="text" class="form-control"
									name="firstName" autofocus="autofocus" required="required" />
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('firstName')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach>
								<br />
							</div>
							<div class="form-group">
								<form:label path="lastName">Last Name *</form:label>
								<form:input path="lastName" type="text" class="form-control"
									name="lastName" required="required" />
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('lastName')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach>
								<br />
							</div>
							<div class="form-group">
								Shipping Address *
								<form:label path="shippingAddress.street">Street *</form:label>
								<form:input path="shippingAddress.street" type="text"
									class="form-control" name="shippingAddressStreet"
									required="required" />
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('shippingAddressStreet')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach>
								<br />
								<form:label path="shippingAddress.city">City *</form:label>
								<form:input path="shippingAddress.city" type="text"
									class="form-control" name="shippingAddresCity"
									required="required" />
								<form:label path="shippingAddress.pin">Zip Code *</form:label>
								<form:input path="shippingAddress.pin" type="text"
									class="form-control" name="shippingAddressPin"
									required="required" />
							</div>
							<div class="form-group">
								Billing Address *
								<form:label path="billingAddress.street">Street *</form:label>
								<form:input path="billingAddress.street" type="text"
									class="form-control" name="billingAddressStreet"
									required="required" />
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('billingAddressStreet')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach>
								<br />
								<form:label path="billingAddress.city">City *</form:label>
								<form:input path="billingAddress.city" type="text"
									class="form-control" name="billingAddresCity"
									required="required" />
								<form:label path="billingAddress.pin">Zip Code *</form:label>
								<form:input path="billingAddress.pin" type="text"
									class="form-control" name="billingAddressPin"
									required="required" />
							</div>
								<div class="form-group">
									Credit Card details *
									<form:label path="cardDetails[0].cardNumber">Card Number *</form:label>
									<form:input path="cardDetails[0].cardNumber" type="text"
										class="form-control" name="cardNumber" required="required" />
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('cardNumber')}"
										var="err">
										<div>
											<span>${err.text}</span>
										</div>
									</c:forEach>
									<br />
									<form:label path="cardDetails[0].name">Name on card *</form:label>
									<form:input path="cardDetails[0].name" type="text" class="form-control"
										name="name" required="required" />
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
										var="err">
										<div>
											<span>${err.text}</span>
										</div>
									</c:forEach>
									<br />
									<form:label path="cardDetails[0].cvv">CVV *</form:label>
									<form:input path="cardDetails[0].cvv" type="text" class="form-control"
										name="cvv" required="required" />
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('cvv')}"
										var="err">
										<div>
											<span>${err.text}</span>
										</div>
									</c:forEach>
									<br />
									<form:label path="cardDetails[0].expiryMonth">Expiry Month *</form:label>
									<form:input path="cardDetails[0].expiryMonth" type="text"
										class="form-control" name="expiryMonth" required="required" />
									<form:label path="cardDetails[0].expiryYear">Expiry Year *</form:label>
									<form:input path="cardDetails[0].expiryYear" type="text"
										class="form-control" name="expiryYear" required="required" />
								</div>
							<div class="form-group">
								<form:label path="contactNo">Mobile *</form:label>
								<form:input path="contactNo" type="text" class="form-control"
									name="phoneNumber" required="required" />
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('contactNo')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach>
								<br />
							</div>
							<div class="form-group">
								<form:label path="email">Email *${error}</form:label>
								<form:input path="email" type="email" class="form-control"
									name="email" required="required" />
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('email')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach>
								<br />
							</div>
							<div class="form-group">
								<form:label path="password">Password *</form:label>
								<form:input path="password" type="password" class="form-control"
									name="password" required="required" />
								<c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach>
								<br />
							</div>
	                     
	                    * <small>Required Fields</small>
							<button name="_eventId_submit"  type="submit" class="btn btn-primary btn-block">SUBMIT</button>
							<a href=Login><button type="button"
									class="btn btn-link btn-block">
									<span>Already have an account?</span> Login
								</button></a>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript">
		var elem = document.getElementById("LinkRegister");
		elem.className += " active";
	</script>

<%@include file="Footer.jsp"%>