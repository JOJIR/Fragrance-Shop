<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
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
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li id="LinkHome"><a href="Home">HOME</a></li>
				<li id="LinkLogin"><a href="Login">LOGIN</a></li>
				<li id="LinkRegister"><a href="Register">REGISTER</a></li>
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
						<c:when test="${empty isLoggedIn}">
							<li><span><a href="Login"><font color="white">Log In</font></a><small><font color="skyblue"> or </font></small><a
									href="Register"><font color="white">Create an Account</font></a></span></li>
									</c:when>
									<c:otherwise>
									<li><a href="AccountHome"><font color="skyblue">Welcome ${email}</font> |</a> <a href="LogOut"><font color="skyblue">Log Out</font></a></li>
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
								data-toggle="dropdown"><i class="fa fa-shopping-cart hicon"></i>$0</a>
								</li>
								</ul>
						<div class="col-md-6 col-xs-12">
							<ul class="list-inline pull-right">
										<li><span class="btn-group" role="group" aria-label="...">
											<button type="button" class="btn btn-default" onclick="location.href='/ShoppingCart/Cart'">Shopping
												Cart</button>
											<button type="button" class="btn btn-default">Checkout</button></span>
										</li></ul></div>
										
									
								
								
			</div>
		</div>
	</div>
	<!-- /.navbar-collapse -->
	<!-- /.container-fluid --> </nav>