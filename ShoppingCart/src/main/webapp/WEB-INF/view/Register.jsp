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
	                      <form:label path="firstName">First Name *</form:label>
	                      <form:input path="firstName" type="text" class="form-control" name="firstName" autofocus="autofocus" required="required"/>
	                    </div>
	                    <div class="form-group">
	                      <form:label path="lastName">Last Name *</form:label>
	                      <form:input path="lastName" type="text" class="form-control" name="lastName" required="required"/>
	                    </div>
	                    <div class="form-group">
	                      <form:label path="address">Shipping Address *</form:label>
	                      <form:input path="address" type="text" class="form-control" name="address" required="required"/>
	                    </div>
	                    <div class="form-group">
	                      <form:label path="contactNumber">Phone Number *</form:label>
	                      <form:input path="contactNumber" type="text" class="form-control" name="phoneNumber" required="required"/>
	                    </div>
	                    <div class="form-group">
	                      <form:label path="email">Enter Email *${error}</form:label>
	                      <form:input path="email" type="email" class="form-control" name="email" required="required"/>
	                    </div>
	                    <div class="form-group">
	                      <form:label path="password">Password *</form:label>
	                      <form:input path="password" type="password" class="form-control" name="password" required="required"/>
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