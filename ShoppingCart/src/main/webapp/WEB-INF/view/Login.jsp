<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<%@include file="Header.jsp"  %>
<section class="lightSection pageHeader">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="page-title">
						<h2><font color='white'>Login</font></h2>
					</div>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb pull-right">
						<li><a href="Home">Home</a></li>
						<li class="active">Login</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<section class="mainContent logIn">
		<div class="container">
			<div class="row">
				<div
					class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-12">
					<div class="panel panel-inverse">
						<div class="panel-heading">
							<h3>Login</h3>
						</div>
      
				
                               <font color='white'> or</font>
                               <div class="panelbody">
								 <form:form class="form" action="LoginAttempt" method="POST" modelAttribute="user" role="form">
										<div class="form-group">
											 <form:label path="email">Email address</form:label>
											 <form:input path="email" type="email" class="form-control" autofocus="autofocus"  required="required"/>
										</div>
										
										<div class="form-group">
											 <form:label path="password" >Password</form:label>
											 <form:input path="password" type="password" class="form-control" />
                                             <div class="help-block text-right"><a href="">Forget the password ?</a></div>
										</div>
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Log in</button>
										</div>
										<div class="checkbox">
											 <label>
											 <input type="checkbox">keep me logged-in
											 </label>
										</div>
								 </form:form>
							</div>
								<div class="bottom text-center">
								New here ? <a href="#"><b>REGISTER</b></a>
							</div>
						
						</div>
					
					</div>
				</div>
			</div>
	
		</section>
		
		<script type="text/javascript">
		var elem = document.getElementById("LinkLogin");
		elem.className += " active";
	</script>
							
							
		<%@include file="Footer.jsp"  %>