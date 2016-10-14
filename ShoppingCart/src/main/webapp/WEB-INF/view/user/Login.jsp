
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="Header.jsp"%>
<section class="lightSection pageHeader">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="page-title"></div>
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
				class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-10">
				<div class="panel panel-inverse">
					<div class="panel-heading">
						<h3>Login</h3>
					</div>
					<div class="panelbody">
						<form action="<c:url value='/j_spring_security_check' />"
							method="POST" role="form">
							<div class="form-group">
								<label>Email address</label> <input type="email" name="email"
									class="form-control" autofocus="autofocus" required="required" />
							</div>

							<div class="form-group">
								<label>Password</label> <input type="password" name="password"
									class="form-control" />
							</div>
							<button type="button" class="btn btn-link btn-block">Forget
								the password ?</button>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">Login</button>
					</div>
					<div class="checkbox">
						<label> <input type="checkbox">keep me logged-in
						</label>
					</div>
					
				</form>
				<div class="bottom text-center">
					New here ? <a href="Registration.obj"><b><font color="darkviolet"><button>Create
									an Account</button></font></b></a>
				</div>
				
			</div>
			
		</div>
	</div>


</section>
<c:if test="${invalidCredentials == true}">
	<%@ include file="InvalidCredentials.jsp"%>
</c:if>


<script type="text/javascript">
		var elem = document.getElementById("LinkLogin");
		elem.className += " active";
	</script>


<%@include file="Footer.jsp"%>