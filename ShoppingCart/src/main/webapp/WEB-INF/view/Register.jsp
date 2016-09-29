<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="Header.jsp"  %>
 	 <!-- LIGHT SECTION -->
	      <section class="lightSection clearfix pageHeader">
	<div class="container">
	<div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form role="form">
			<h2><font color='violet'>Please Sign Up </font><small><font color='white'>It's free and always will be.</font></small></h2>
			<div class="col-xs-6">
	              <ol class="breadcrumb pull-right">
	                <li>
	                  <a href="Home">Home</a>
	                </li>
	                <li class="active">Sign up</li>
	              </ol>
	            </div>
	            </form>
	            </div>
	            </div>
	            </div>
	            </section>
	           
		
			
			<!-- MAIN CONTENT SECTION -->
	      <section class="mainContent signUp">
	        <div class="container">
	          <div class="row">
	            <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-12">
	              <div class="panel panel-inverse">
	                <div class="panel-heading"><h3>Sign up</h3></div>
	                <div class="panel-body">
	                  <form:form action="RegisterAttempt" method="POST" modelAttribute="userDetails" role="form">
	                    <div class="form-group">
	                      <form:label path="user.firstName">First Name *</form:label>
	                      <form:input path="user.firstName" type="text" class="form-control" name="firstName" autofocus="autofocus" required="required"/>
	                    </div>
	                    <div class="form-group">
	                      <form:label path="user.lastName">Last Name *</form:label>
	                      <form:input path="user.lastName" type="text" class="form-control" name="lastName" required="required"/>
	                    </div>
	                   <div class="form-group">
	                    Shipping Address *
	                      <form:label path="shippingAddress.street">Street *</form:label>
	                      <form:input path="shippingAddress.street" type="text" class="form-control" name="shippingAddressStreet" required="required"/>
	                      <form:label path="shippingAddress.city">City *</form:label>
	                      <form:input path="shippingAddress.city" type="text" class="form-control" name="shippingAddresCity" required="required"/>
	                      <form:label path="shippingAddress.pin">Zip Code *</form:label>
	                      <form:input path="shippingAddress.pin" type="text" class="form-control" name="shippingAddressPin" required="required"/>
	                    </div>
	                    <div class="form-group">
	                    Billing Address *
	                      <form:label path="billingAddress.street">Street *</form:label>
	                      <form:input path="billingAddress.street" type="text" class="form-control" name="billingAddressStreet" required="required"/>
	                      <form:label path="shippingAddress.city">City *</form:label>
	                      <form:input path="billingAddress.city" type="text" class="form-control" name="shippingAddresCity" required="required"/>
	                      <form:label path="billingAddress.pin">Zip Code *</form:label>
	                      <form:input path="billingAddress.pin" type="text" class="form-control" name="billingAddressPin" required="required"/>
	                    </div>
	                    <div class="form-group">
	                    Credit Card details *
									<form:label path="cardDetails.cardNumber">Card Number *</form:label>
									<form:input path="cardDetails.cardNumber" type="text"
										class="form-control" name="cardNumber" required="required" />
									<form:label path="cardDetails.name">Name on card *</form:label>
									<form:input path="cardDetails.name" type="text"
										class="form-control" name="name" required="required" />
									<form:label path="cardDetails.cvv">CVV *</form:label>
									<form:input path="cardDetails.cvv" type="text"
										class="form-control" name="cvv" required="required" />
									<form:label path="cardDetails.expiryMonth">Expiry Month *</form:label>
									<form:input path="cardDetails.expiryMonth" type="text"
										class="form-control" name="expiryMonth" required="required" />
									<form:label path="cardDetails.expiryYear">Expiry Year *</form:label>
									<form:input path="cardDetails.expiryYear" type="text"
										class="form-control" name="expiryYear" required="required" />
	                    </div>
	                    <div class="form-group">
	                      <form:label path="user.contactNo">Phone Number *</form:label>
	                      <form:input path="user.contactNo" type="text" class="form-control" name="phoneNumber" required="required"/>
	                    </div>
	                    <div class="form-group">
	                      <form:label path="user.email">Enter Email *${error}</form:label>
	                      <form:input path="user.email" type="email" class="form-control" name="email" required="required"/>
	                    </div>
	                    <div class="form-group">
	                      <form:label path="user.password">Password *</form:label>
	                      <form:input path="user.password" type="password" class="form-control" name="password" required="required"/>
	                    </div>
	                     
	                    * <small>Required Fields</small>
	                    <button type="submit" class="btn btn-primary btn-block">Submit</button>
	                    <button type="button" class="btn btn-link btn-block"><span>Already have an account?</span> Log in</button>
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
			
<%@include file="Footer.jsp"  %>