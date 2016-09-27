<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ include file="Header.jsp"%>
	<!-- LIGHT SECTION -->
	<section class="lightSection clearfix pageHeader">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<div class="page-title">
						<h2><font color = "white">Product List</font> </h2>
					</div>
				</div>
				<div class="col-xs-6">
					<ol class="breadcrumb pull-right">
						<li><a href="Home">Home</a></li>
						<li class="active">Product List</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	
	
	
	<!-- MAIN CONTENT SECTION -->
	<section class="mainContent clearfix productsContent">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-4 col-xs-12 sideBar">
					<div class="panel panel-inverse">
						<div class="panel-heading">Product categories</div>
						<div class="panel-body">
							<div
								class="collapse navbar-collapse navbar-ex1-collapse navbar-side-collapse">
								<ul class="nav navbar-nav side-nav">
									<li><a href="javascript:;" data-toggle="collapse"
										data-target="#men">Men <i class="fa fa-plus"></i></a>
										<ul id="men" class="collapse collapseItem">
											<li><a href="#"><i class="fa fa-caret-right"
											aria-hidden="true"></i>Fragrance Men <span>()</span></a></li>
											<ul id="men" class="collapse collapseItem">
											<li><a href="#"><i class="fa fa-caret-right"
											aria-hidden="true"></i>Deodorant Men <span>()</span></a></li>
											<ul id="men" class="collapse collapseItem">
											<li><a href="#"><i class="fa fa-caret-right"
											aria-hidden="true"></i>Perfume Men <span>()</span></a></li>
											</ul></li>
											
											<li><a href="javascript:;" data-toggle="collapse"
										data-target="#women">Women <i class="fa fa-plus"></i></a>
										<ul id="women" class="collapse collapseItem">
											<li><a href="#"><i class="fa fa-caret-right"
											aria-hidden="true"></i>Fragrance Women <span>()</span></a></li>
											<ul id="women" class="collapse collapseItem">
											<li><a href="#"><i class="fa fa-caret-right"
											aria-hidden="true"></i>Deodorant Women <span>()</span></a></li>
											<ul id="women" class="collapse collapseItem">
											<li><a href="#"><i class="fa fa-caret-right"
											aria-hidden="true"></i>Perfume Women <span>()</span></a></li>
											</ul></li>
											
							
					
					<div class="col-md-9 col-sm-8 col-xs-12">
					<div class="row filterArea">
						<div class="col-xs-6">
							<select name="sortOrder" id="sortOrder" class="select-drop">
								<option value="0">Sort by name</option>
								<option value="1">Sort by price</option>
								<option value="2">Sort by quantity</option>
								
							</select>
						</div>
						
								<div class="btn-group pull-right" role="group">
								<button type="button" class="btn btn-inverse active"
									onclick="window.location.href='ProductList'">
									<i class="fa fa-th-list" aria-hidden="true"></i><span>List</span>
								</button>
							</div>
						</div>
					</div>
					<div class="row productListSingle">
	

						<c:forEach items="${productList}" var="product">
							<div class="col-xs-12">
								<div class="media">
									<div class="media-left">
										<img class="media-object" src="resources/image/products/${product.id}.jpg"
											alt="Image"> <span class="maskingImage"><a
											data-toggle="modal" href=".quick-view" class="btn viewBtn">Quick
												View</a></span>
									</div>
									<div class="media-body">
										<h4 class="media-heading">
											<a href="single-product">${product.name}</a>
										</h4>
										<p>${product.description}</p>
										<h3>$${product.price}</h3>
										
										<div class="col-xs-2">
										<i class="fa fa-times">${product.quantity}</i>
									</div>
										
									</div>
								</div>
							</div>
						</c:forEach>
	

					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
		var e = document.querySelector("#sortOrder");
		e.value = ${sortOrder};
		e.addEventListener("change", function() {
			window.location.href = "/ShoppingCart/ProductList?sort=" + this.value;
		});
	</script>
	<%@ include file="Footer.jsp"%>
					
											
	
											
	