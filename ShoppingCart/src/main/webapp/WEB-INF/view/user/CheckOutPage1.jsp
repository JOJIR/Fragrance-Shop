<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ include file="Header.jsp"%>
		  <!-- LIGHT SECTION -->
	      <section class="lightSection clearfix pageHeader">
	        <div class="container">
	          <div class="row">
	            <div class="col-xs-6">
	              <div class="page-title">
	             
	              </div>
	            </div>
	            <div class="col-xs-6">
	              <ol class="breadcrumb pull-right">
	                <li>
	                  <a href="Home">Home</a>
	                </li>
	                <li class="active">Billing &amp; Shipping address</li>
	              </ol>
	            </div>
	          </div>
	        </div>
	      </section>
	      
	      <!-- MAIN CONTENT SECTION -->
	      <section class="mainContent clearfix stepsWrapper">
	        <div class="container">
	          <div class="row">
	            <div class="col-xs-12">
	              <div class="innerWrapper clearfix stepsPage">
	                <div class="row progress-wizard" style="border-bottom:0;">
	

	                  <div class="col-xs-4 progress-wizard-step complete">
	                    <div class="text-center progress-wizard-stepnum"><font color="darkgrey">Billing &amp; Shipping Address</font></div>
	                    <div class="progress"><div class="progress-bar"></div></div>
	                    <a href="#" class="progress-wizard-dot"></a>
	                  </div>
	

	                  <div class="col-xs-4 progress-wizard-step disabled">
	                    <div class="text-center progress-wizard-stepnum"><font color="darkgrey">Payment Method</font></div>
	                    <div class="progress"><div class="progress-bar"></div></div>
	                    <a href="${flowExecutionUrl}&_eventId=step2" class="progress-wizard-dot"></a>
	                  </div>
	

	                  <div class="col-xs-4 progress-wizard-step disabled">
	                    <div class="text-center progress-wizard-stepnum"><font color="darkgrey">Review</font></div>
	                    <div class="progress"><div class="progress-bar"></div></div>
	                    <a href="${flowExecutionUrl}&_eventId=step3" class="progress-wizard-dot"></a>
	                  </div>
	                </div>
	                
	                <form:form class="row" method="POST" modelAttribute="user" role="form">
	                  <div class="col-xs-12">
	                    <div class="page-header">
	                      <h4><font color="darkgrey">Billing Information</font></h4>
	                    </div>
	                  </div>
	                  <div class="form-group col-sm-6 col-xs-12">
	                    <form:label path="firstName" for=""><font color="darkgrey">First Name</font></form:label>
	                    <form:input path="firstName" type="text" class="form-control" id="" />
	                  </div>
	                  <div class="form-group col-sm-6 col-xs-12">
	                    <form:label path="lastName" for=""><font color="darkgrey">Last Name</font></form:label>
	                    <form:input path="lastName" type="text" class="form-control" id="" />
	                  </div>
	                  <div class="form-group col-sm-6 col-xs-12">
	                    <form:label path="contactNo" for=""><font color="darkgrey">Phone</font></form:label>
	                    <form:input path="contactNo" type="text" class="form-control" id="" />
	                  </div>
	                  <div class="form-group col-sm-6 col-xs-12">
	                    <form:label path="billingAddress.street" for=""><font color="darkgrey">Street</font></form:label>
	                    <form:input path="billingAddress.street" type="text" class="form-control" id="" />
	                  </div>
	                  <div class="form-group col-sm-6 col-xs-12">
	                    <form:label path="billingAddress.city" for=""><font color="darkgrey">City</font></form:label>
	                    <form:input path="billingAddress.city" type="text" class="form-control" id="" />
	                  </div>
	                  <div class="form-group col-sm-6 col-xs-12">
	                    <form:label path="billingAddress.pin" for=""><font color="darkgrey">Zip Code</font></form:label>
	                    <form:input path="billingAddress.pin" type="text" class="form-control" id="" />
	                  </div>
	                  <div class="col-xs-12">
	                    <div class="page-header">
	                      <h4><font color="darkgrey">Shipping information</font></h4>
	                    </div>
	                  </div>
	                  <div class="form-group col-sm-6 col-xs-12">
	                    <form:label path="shippingAddress.street" for=""><font color="darkgrey">Street</font></form:label>
	                    <form:input path="shippingAddress.street" type="text" class="form-control" id="" />
	                  </div>
	                  <div class="form-group col-sm-6 col-xs-12">
	                    <form:label path="shippingAddress.city" for=""><font color="darkgrey">City</font></form:label>
	                    <form:input path="shippingAddress.city" type="text" class="form-control" id="" />
	                  </div>
	                  <div class="form-group col-sm-6 col-xs-12">
	                    <form:label path="shippingAddress.pin" for=""><font color="darkgrey">Zip Code</font></form:label>
	                    <form:input path="shippingAddress.pin" type="text" class="form-control" id="" />
	                  </div>
	                  <div class="col-xs-12">
	                    <div class="well well-lg clearfix">
	                      <ul class="pager">
	                      <li class="previous"><a href="#" class="hideContent">Back</a></li>
	                        <li class="next"><a href="${flowExecutionUrl}&_eventId=step2">Continue</a></li>
	                      </ul>
	                    </div>
	                  </div>
	                </form:form>
	              </div>
	            </div>
	          </div>
	        </div>
	      </section>
	<%@ include file="Footer.jsp"%>

