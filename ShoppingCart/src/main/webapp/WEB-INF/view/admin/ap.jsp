<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="sec"
		uri="http://www.springframework.org/security/tags"%>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>BigBag Store</title>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.js"></script>
	<script src="https://use.fontawesome.com/20c7f48529.js"></script>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="resources/css/style.css">
	</head>
	<body>
		<!-- HEADER -->
		<div class="header clearfix">
	

			<!-- TOPBAR -->
			<div class="topBar">
				<div class="container">
					<div class="row">
						<div class="col-md-6 hidden-sm hidden-xs">
							<ul class="list-inline">
								<li><a href="#"><i class="fa fa-twitter hicon"></i></a></li>
								<li><a href="#"><i class="fa fa-facebook hicon"></i></a></li>
								<li><a href="#"><i class="fa fa-dribbble hicon"></i></a></li>
								<li><a href="#"><i class="fa fa-vimeo hicon"></i></a></li>
								<li><a href="#"><i class="fa fa-tumblr hicon"></i></a></li>
							</ul>
						</div>
						<div class="col-md-6 col-xs-12">
							<ul class="list-inline pull-right">
								<c:choose>
									<c:when test="${empty pageContext.request.userPrincipal}">
										<li><span><a href="Login">Log in</a> <small>or</small>
												<a href="Registration.obj">Create an account</a></span></li>
									</c:when>
									<c:otherwise>
										<li><a href="AccountHome">Welcome
												${pageContext.request.userPrincipal.name} |</a> <sec:authorize
												access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
												<a href="javascript:formSubmit()"> Logout</a>
											</sec:authorize></li>
									</c:otherwise>
								</c:choose>
								<li class="dropdown searchBox"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"><i
										class="fa fa-search hicon"></i></a>
									<ul class="dropdown-menu dropdown-menu-right">
										<li><span class="input-group"> <input type="text"
												class="form-control" placeholder="Search..."
												aria-describedby="basic-addon2"> <span
												class="input-group-addon" id="basic-addon2">Search</span>
										</span></li>
									</ul></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"><i class="fa fa-shopping-cart hicon"></i>$${total}</a>
									<ul class="dropdown-menu dropdown-menu-right">
										<li>Item(s) in your cart</li>
										<c:forEach items="${orderList}" var="order" varStatus="status">
											<li><a href="#">
													<div class="cartImage media">
														<img class="media-left media-object"
															src="resources/images/products/${productList[status.index].id}.jpg"
															alt="cart-Image">
														<div class="media-body">
															<h5 class="media-heading">
																${productList[status.index].name} <br> <span>${order.quantity}
																	X $${productList[status.index].price}</span>
															</h5>
														</div>
													</div>
											</a></li>
										</c:forEach>
										<li>
											<div class="btn-group" role="group" aria-label="...">
												<button type="button" class="btn btn-default"
													onclick="location.href='/FashionStore/Cart'">Shopping
													Cart</button>
												<button type="button" class="btn btn-default">Checkout</button>
											</div>
										</li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	

		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
			<!-- For login user -->
			<c:url value="/j_spring_security_logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>
		</sec:authorize>
	

		<nav class="navbar navbar-main navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Home"> <img
					src="resources/images/logo.png" alt=""><span
					class="company-name">B<small>IG</small> B<small>AG</small></span></a>
			</div>
	

			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li id="LinkHome"><a href="Home">Home</a></li>
					<li id="LinkRegister"><a href="Registration.obj">Register</a></li>
					<li id="LinkLogin"><a href="Login">Login</a></li>
					<li id="LinkAboutUs"><a href="AboutUs">About Us</a></li>
					<li id="LinkContactUs"><a href="ContactUs">Contact Us</a></li>
				</ul>
			</div>
		</div>
		</nav>

