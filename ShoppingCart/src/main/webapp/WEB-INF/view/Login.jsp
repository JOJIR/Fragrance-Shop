<%@include file="Header.jsp"  %>
      <ul class="nav navbar-nav navbar-center">
        <li><p class="navbar-text"><font color='white'>Already have an account?</font></p></li>
       
					 <div class="row">
							<div class="col-md-12">
								<font color='white'>Login via</font>
								<div class="social-buttons">
									<a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
									<a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
								</div>
                                or
								 <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
											 <label class="sr-only" for="exampleInputEmail2">Email address</label>
											 <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email address" required>
										</div>
										<div class="form-group">
											 <label class="sr-only" for="exampleInputPassword2">Password</label>
											 <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Password" required>
                                             <div class="help-block text-right"><a href="">Forget the password ?</a></div>
										</div>
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Sign in</button>
										</div>
										<div class="checkbox">
											 <label>
											 <input type="checkbox"> <font color='white'>keep me logged-in</font>
											 </label>
										</div>
								 </form>
							</div>
							<div class="bottom text-center">
								<font color='white'>New here ?</font> <a href="#"><b>REGISTER</b></a>
							</div>
							<%@include file="Footer.jsp"  %>