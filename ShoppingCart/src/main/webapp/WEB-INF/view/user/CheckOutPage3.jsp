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
	                <li class="active">Review</li>
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
	

	                  <div class="col-xs-4 progress-wizard-step complete fullBar">
	                    <div class="text-center progress-wizard-stepnum"><font color="darkgrey">Billing &amp; Shipping Address</font></div>
	                    <div class="progress"><div class="progress-bar"></div></div>
	                    <a href="${flowExecutionUrl}&_eventId=step1" class="progress-wizard-dot"></a>
	                  </div>
	

	                  <div class="col-xs-4 progress-wizard-step complete fullBar">
	                    <div class="text-center progress-wizard-stepnum"><font color="darkgrey">Payment Method</font></div>
	                    <div class="progress"><div class="progress-bar"></div></div>
	                    <a href="${flowExecutionUrl}&_eventId=step2" class="progress-wizard-dot"></a>
	                  </div>
	

	                  <div class="col-xs-4 progress-wizard-step complete">
	                    <div class="text-center progress-wizard-stepnum"><font color="darkgrey">Review</font></div>
	                    <div class="progress"><div class="progress-bar"></div></div>
	                    <a href="#" class="progress-wizard-dot"></a>
	                  </div>
	                </div>
	                
	                <form action="" class="row" method="POST" role="form">
	                  <div class="col-xs-12">
	                    <div class="page-header">
	                      <h4><font color="darkgrey">Order Review</font></h4>
	                    </div>
	                  </div>
	                  <div class="col-sm-6 col-xs-12">
	                    <div class="panel panel-default">
	                      <div class="panel-heading">
	                        <h4 class="panel-title"><font color="darkgrey">Billing Address</font></h4>
	                      </div>
	                      <div class="panel-body">
	                        <address>
	                          ${user.billingAddress.street}<br>
	                          ${user.billingAddress.city}<br>
	                          ${user.billingAddress.pin}<br>
	                        </address>
	                      </div>
	                    </div>
	                  </div>
	                  <div class="col-sm-6 col-xs-12">
	                    <div class="panel panel-default">
	                      <div class="panel-heading">
	                        <h4 class="panel-title">Shipping Address</h4>
	                      </div>
	                      <div class="panel-body">
	                        <address>
	                          ${user.shippingAddress.street}<br>
	                          ${user.shippingAddress.city}<br>
	                          ${user.shippingAddress.pin}<br>
	                        </address>
	                      </div>
	                    </div>
	                  </div>
	                  <div class="col-sm-6 col-xs-12">
	                    <div class="panel panel-default">
	                      <div class="panel-heading">
	                        <h4 class="panel-title">Payment Method</h4>
	                      </div>
	                      <div class="panel-body">
	                        <address>
	                          <span>Credit Card - VISA</span>
	                        </address>
	                      </div>
	                    </div>
	                  </div>
	                  <div class="col-xs-12">
	                    <div class="panel panel-default">
	                      <div class="panel-heading">
	                        <h4 class="panel-title">Order Details</h4>
	                      </div>
	                      <div class="panel-body">
	                        <div class="row">
	                          <div class="col-sm-4 col-xs-12">
	                            <address>
	                              <a href="#">Email:${email}</a> <br>
	                              <span>Phone:${user.contactNo}</span>
	                            </address>
	                          </div>
	                         
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	                  <div class="col-xs-12">
	                    <div class="cartListInner">
	                      <div class="table-responsive">
	                        <table class="table">
	                          <thead>
	                            <tr>
	                              <th></th>
	                              <th><font color="violet">Product Name</font></th>
	                              <th><font color="violet">Price</font></th>
	                              <th><font color="violet">Quantity</font></th>
	                              <th><font color="violet">Total</font></th>
	                            </tr>
	                          </thead>
	                          <tbody>
	                            <c:forEach items="${orderList}" var="order" varStatus="status">
											<tr>
												<td class="col-xs-2">
												<span class="cartImage"><img class="cart" src="resources/image/products/${productList[status.index].id}.jpg" alt="image"></span>
												</td>
												<td class="col-xs-4"><font color="darkgrey">${productList[status.index].name}</font></td>
												<td class="col-xs-2"><font color="darkgrey">${productList[status.index].price}</font></td>
												<td class="col-xs-2"><font color="darkgrey">${order.quantity}</font></td>
												<td class="col-xs-2"><font color="darkgrey">$${productList[status.index].price * order.quantity}</font></td>
											</tr>
								</c:forEach>
	                          </tbody>
	                        </table>
	                      </div>
	                      <div class="row totalAmountArea">
	                        <div class="col-sm-4 col-sm-offset-8 col-xs-12">
	                          <ul class="list-unstyled">
	                            <li>Total <span class="grandTotal">$${total}</span></li>
	                          </ul>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	                  <div class="col-xs-12">
	                    <div class="well well-lg clearfix">
	                      <ul class="pager">
	                      <li class="previous"><a href="${flowExecutionUrl}&_eventId=step2">Back</a></li>
	                        <li class="next"><a href="${flowExecutionUrl}&_eventId=step4">Confirm</a></li>
	                      </ul>
	                    </div>
	                  </div>
	                </form>
	              </div>
	            </div>
	          </div>
	        </div>
	      </section>
	

	<%@ include file="Footer.jsp"%>

