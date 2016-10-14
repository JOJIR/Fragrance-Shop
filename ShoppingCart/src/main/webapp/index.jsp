<%@include file="WEB-INF/view/user/Header.jsp"%>


	<!--slider-->

	<div id="slider-carousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
		<li data-target="#slider-carousel" data-slide-to="1"></li>
		<li data-target="#slider-carousel" data-slide-to="2"></li>
		<li data-target="#slider-carousel" data-slide-to="3"></li>
		<li data-target="#slider-carousel" data-slide-to="4"></li>
	</ol>


	<!-- Wrapper for slides -->
	<div class="carousel-inner">
		<div class="item active">
			<img class="first-slide"
				src="resources/image/home/carousel/perfume1.jpg" alt="First slide">
		</div>

		<div class="item">
			<img class="second-slide"
				src="resources/image/home/carousel/perfume2.jpg" alt="Second slide">
		</div>

		<div class="item">
			<img class="third -slide"
				src="resources/image/home/carousel/perfume3.jpg" alt="Third slide">
		</div>

		<div class="item">
			<img class="fourth -slide"
				src="resources/image/home/carousel/perfume4.jpg" alt="Fourth slide">
		</div>

		<div class="item">
			<img class="fifth -slide"
				src="resources/image/home/carousel/perfume5.jpg" alt="Fifth slide">
		</div>

		<div class="item">
			<img class="sixth -slide"
				src="resources/image/home/carousel/perfume6.jpg" alt="Sixth slide">
		</div>




		<!-- Left and right controls -->
		<a class="left carousel-control" href="#slider-carousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#slider-carousel"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</div>
</div>
	

	<br>  

	<div class="box featured">
		<div class="box-heading">Featured Products</div>
		<div class="box-content">
			<div class="box-product">
				<ul class="row">
					<li class="first-in-line span">

						<section class="mainContent">
							<div class="container">
								<div class="row featuredCollection">
									
									<div class="col-sm-4 col-xs-12">
										<div class="image" onclick="location.href='SingleProduct';">
											<div class="imageWrapper">
												<img class="indexproducts" src="resources/image/home/featuredproducts/FG-02.jpg"
													alt="featureproducts-image">
												<div class="masking">
													<a href="ProductGrid" class="btn viewBtn"><font color="lightblue">View Products</font></a>
												</div>
											</div>
											<div class="caption">
						<h4><font color="violet">FRAGRANCE WOMEN</font></h4>
					</div>
										</div>
									</div>
									<div class="col-sm-4 col-xs-12">
										<div class="image" onclick="location.href='SingleProduct';">
											<div class="imageWrapper">
												<img class="indexproducts" src="resources/image/home/featuredproducts/DO-02.jpg"
													alt="featureproducts-image">
												<div class="masking">
													<a href="ProductGrid" class="btn viewBtn"><font color="lightblue">View Products</font></a>
												</div>
											</div>
											<div class="caption">
						<h4><font color="violet">DEODORANT MEN</font></h4>
					</div>
										</div>
									</div>
									<div class="col-sm-4 col-xs-12">
										<div class="image" onclick="location.href='SingleProduct';">
											<div class="imageWrapper">
												<img class="indexproducts" src="resources/image/home/featuredproducts/PF-01.jpg"
													alt="featureproducts-image">
												<div class="masking">
													<a href="ProductGrid" class="btn viewBtn"><font color="lightblue">View Products</font></a>
												</div>
											</div>
											<div class="caption">
						<h4><font color="violet">PERFUME MEN</font></h4>
					</div>
										</div>
									</div>
								</div>
							</div>
						</section>
						<div id="banner0" class="banner row">
							<div class="col-sm-4 col-xs-12">
								<a href=""><img src="resources/image/footer/order.png"
									alt="" title="" />
								<span class="s-desc">
										<h1>order</h1>
										<h2>online</h2>
										<h3>Hours: 8AM -11PM</h3>
									</span></a>
							</div>
							<div class="col-sm-4 col-xs-12">
								<a href=""><img src="resources/image/footer/shipping.png"
									alt="" title="" />
								<span class="s-desc">
										<h1>Free</h1>
										<h2>Shipping</h2>
										<h3>on orders over $99</h3>
									</span></a>
							</div>
							<div class="col-sm-4 col-xs-12">
								<a href=""><img src="resources/image/footer/gift.png" alt=""
									title="" />
								<span class="s-desc">
										<h1>Special</h1>
										<h2>gift cards</h2>
										<h3>Give the perfect gift</h3>
									</span></a>
							</div>
							<div class="clear"></div>
						</div>
						<h1 style="display: none;">PERFUME POWER</h1>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>


<div class="clear"></div>
<script type="text/javascript">
	var elem = document.getElementById("LinkHome");
	elem.className += " active";
</script>
<%@ include file="WEB-INF/view/user//Footer.jsp"%>