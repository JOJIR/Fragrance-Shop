<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>PERFUME POWER</title>
<link rel="stylesheet" href="resources/Bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/font-awesome-4.6.3/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>

	<h1 align='center'>
		<font color='violet'><b><i>PERFUME POWER</b></i></font>
	</h1>


	<nav class="navbar navbar-inverse role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle"
				data-toggle="collapse" data-target="#navbar-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand logo" href="Home"> <img
				src="resources/image/home/logo/logo.png" alt="">
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="navbar-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li id="LinkHome"><a href="Home">HOME</a></li>
				<li id="LinkProduct"><a href="ProductGrid">PRODUCTS</a></li>
				<li id="LinkRegister"><a href="Registration.obj">REGISTER</a></li>
				<li id="LinkLogin"><a href="Login">LOGIN</a></li>
				<li id="LinkAboutUs"><a href="AboutUs">ABOUT US</a></li>
				<li id="LinkContactUs"><a href="ContactUs">CONTACT US</a></li>
			</ul>


			<!-- social media icons -->
			
			<ul class="nav navbar-nav navbar-right social">
				<li><a href="#"><i class="fa fa-lg fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-lg fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-lg fa-google-plus"></i></a></li>

			</ul>

			<div class="col-md-6 col-xs-12">
				<ul class="list-inline pull-right">
					<c:choose>
						<c:when test="${empty pageContext.request.userPrincipal}">
							<li><span><a href="Login"><font color="white">Log
											In</font></a><small><font color="skyblue"> or </font></small><a
									href="Registration.obj"><font color="white">Create
											an Account</font></a></span></li>
						</c:when>
						<c:otherwise>
							<li><a href="AccountHome"><font color="skyblue">Welcome</font>
										<font color="pink">${pageContext.request.userPrincipal.name}</font> <font color="darkgrey">|</font></a> <sec:authorize
									access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
									<a href="javascript:formSubmit()"> <font color="skyblue">Logout</font></a>
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

							<c:forEach items="${orderList}" var="order" varStatus="status">
								<li><a href="#">
										<div class="media">
											<img class="indexproducts"
												src="resources/image/products/${productList[status.index].id}.jpg"
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
							<li><span class="btn-group" role="group" aria-label="...">
									<button type="button" class="btn btn-default"
										onclick="location.href='/ShoppingCart/Cart'">My Cart</button>
									<button type="button" class="btn btn-default">Checkout</button>
							</span></li>
						</ul>
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



		</div>
	</div>

	<!-- /.navbar-collapse --> <!-- /.container-fluid --> </nav>