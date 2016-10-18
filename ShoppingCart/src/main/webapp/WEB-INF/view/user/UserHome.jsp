
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ include file="Header.jsp"%>
	<section class="lightSection pageHeader">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="page-title">
						<h3><font color='skyblue'>User Home</font> <small><font color="darkgrey">welcome ${email}</font></small></h3>
					</div>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb pull-right">
						<li><a href="Home">Home</a></li>
						<li class="active">User Home</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	
	<!-- MAIN CONTENT SECTION -->
	<section class="mainContent clearfix stepsWrapper">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12">
					<div class="innerWrapper clearfix stepsPage">
	

						<form action="" class="row" method="POST" role="form">
							<div class="col-xs-12">
								<div class="page-header">
									<h4>User Profile</h4>
								</div>
							</div>
							<div class=""form-group"">
								<div class="panel panel-inverse">
									<div class="panel-heading">
										<h4 class="panel-title">Billing Address</h4>
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
							<div class=""form-group"">
								<div class="panel panel-inverse">
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
							<div class=""form-group"">
								<div class="panel panel-inverse">
									<div class="panel-heading">
										<h4 class="panel-title">Credit Card</h4>
									</div>
									<div class="panel-body">
									<c:forEach items="${user.cardDetails}" var="card">
										<address>
											<span>Card Number:${card.cardNumber}</span><br />
											<span>CVV:${card.cvv}</span><br />
											<span>Name on card:${card.name}</span>
										</address>
									</c:forEach>
									</div>
								</div>
							</div>
							<div class=""form-group"">
								<div class="panel panel-inverse">
									<div class="panel-heading">
										<h4 class="panel-title">Contact Info</h4>
									</div>
									<div class="panel-body">
										<div class="row">
										<div class=""form-group"">
												<address>
													<span>Name:${user.firstName}</span> <span>${user.lastName}</span> <br />
												</address>
											</div>
											<div class=""form-group"">
												<address>
													<a href="#">Email:${email}</a> <br /> <span>Phone:${user.contactNo}</span>
												</address>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	<%@ include file="Footer.jsp"%>

