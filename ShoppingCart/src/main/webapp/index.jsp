<%@include file="WEB-INF/view/Header.jsp"  %>
 
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img class="first-slide" src="resources/image/perfume1.jpg" alt="First slide" width="100%" height="360">
    </div>

    <div class="item">
      <img class="second-slide" src="resources/image/perfume2.jpg" alt="Second slide" width="100%" height="360">
    </div>

    <div class="item">
      <img class="third -slide" src="resources/image/perfume3.jpg" alt="Third slide" width="100%" height="360">
    </div>
    
    <div class="item">
      <img class="fourth -slide" src="resources/image/perfume4.jpg" alt="Third slide" width="100%" height="360">
    </div>
    
    <div class="item">
      <img class="fifth -slide" src="resources/image/perfume5.jpg" alt="Third slide" width="100%" height="360">
    </div>
    
    <div class="item">
      <img class="sixth -slide" src="resources/image/perfume6.jpg" alt="Third slide" width="100%" height="360">
    </div>
    



  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

			<br>
			<br>
			<br>
			<br>
			<br>

<div class="box featured">
<div class="box-heading">Featured Products</div>
<div class="box-content">
<div class="box-product">
<ul class="row">
<li class="first-in-line span3">
<script type="text/javascript">
				$(document).ready(function(){
					$("a.colorbox1").colorbox({
					rel: 'colorbox',
					inline:true,
					html: true,
					width:'58%',
					maxWidth:'780px',
					height:'70%',
					opacity:0.6,
					open:false,
					returnFocus:false,
					fixed: false,
					title: false,
					href:'.quick-view1',
					current:'Product {current} of {total}'
					});
					});
				</script>


<div class="image1" onclick="location.href='SingleProduct';" >
							<a href=""><img id="" src="" alt="" /></a>
						</div>
						<div style="display: none;">
							<div class="quick-view1 preview">
								<div class="wrapper marg row-fluid">
									<div class="left span4">
										<div class="image2">
											<a
												href=""><img
												src=""
												alt="" /></a>
										</div>
									</div>
									
										<div class="cart-button">
											<div class="cart">
												<a title="Add to cart" data-id=""
													class="button addToCart-1 "> <span>Add to cart</span>
												</a>
											</div>

											<div class="wishlist">
												<a class="tooltip-1" title="Add to Wish List"
													onclick="addToWishList('43');"> <i class="icon-star"></i>
													<span>Add to Wish List</span>
												</a>
											</div>


											<script type="text/javascript">
		var elem = document.getElementById("LinkHome");
		elem.className += " active";
	</script>


											<%@include file="WEB-INF/view/Footer.jsp"%>