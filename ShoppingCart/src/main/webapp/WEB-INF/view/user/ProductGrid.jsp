<%@ include file="Header.jsp"%>
  <!-- LIGHT SECTION -->
      <section class="lightSection clearfix pageHeader">
        <div class="container">
          <div class="row">
            <div class="col-xs-6">
              <div class="page-title">
              
              </div>
            </div>
            <div class="col-xs-6">
              <ol class="breadcrumb pull-right">
                <li>
                  <a href="Home">Home</a>
                </li>
               
                <li class="active">Product Grid</li>
              </ol>
            </div>
          </div>
        </div>
      </section>
      
           <!-- MAIN CONTENT SECTION -->
      <section class="mainContent clearfix productsContent">
        <div class="container">
          <div class="row">
            <div class="col-md-3 col-sm-4  col-xs-12 sideBar">
              <div class="panel panel-inverse">
                <div class="panel-heading"><font color="darkblue"><strong>Product Categories</strong></font></div>
                <div class="panel-body">
                  <div class="collapse navbar-collapse navbar-ex1-collapse navbar-side-collapse">
                    <ul class="nav navbar-nav side-nav">
                      <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#men">Men <i class="fa fa-plus"></i></a>
                        <ul id="men" class="collapse collapseItem">
                        	<c:forEach items="${maleCategoryList}" var="maleCategory">
                         		<li><a href="/ShoppingCart/ProductGrid?category=${maleCategory.id}"><i class="fa fa-caret-right" aria-hidden="true"></i>${maleCategory.name}</a></li>
							</c:forEach>
						 </ul>
                      </li>
                                <li><a href="javascript:;" data-toggle="collapse" data-target="#women">Women <i class="fa fa-plus"></i></a>
                        <ul id="women" class="collapse collapseItem">
							 <c:forEach items="${femaleCategoryList}" var="femaleCategory">
                         		<li><a href="/ShoppingCart/ProductGrid?category=${femaleCategory.id}"><i class="fa fa-caret-right" aria-hidden="true"></i>${femaleCategory.name}</a></li>
							</c:forEach>

                        </ul>
                      </li>
                        </ul>
                  </div>
                </div>
              </div>
              			<div class="col-xs-6">
						<div class="btn-group pull-right" role="group">
							<button type="button" class="btn btn-default active"
								onclick="window.location.href='ProductGrid'">
								<i class="fa fa-th" aria-hidden="true"></i><span>Grid</span>
							</button>
							<button type="button" class="btn btn-default"
								onclick="window.location.href='ProductList'">
								<i class="fa fa-th-list" aria-hidden="true"></i><span>List</span>
							</button>
						</div>
					</div>
				</div>
				<div class="row">
						<c:forEach items="${productList}" var="product">
							<div class="col-sm-4 col-xs-12">
								<div class="productBox">
									<div class="productImage clearfix">
										<img class="indexproducts" src="resources/image/products/${product.id}.jpg" alt="products-img">
										<div class="productMasking">
											<ul class="list-inline btn-group" role="group">
												<li><a href="AddToCart?id=${product.id}" class="btn btn-default"><i
														class="fa fa-shopping-cart"></i></a></li>
											</ul>
										</div>
									</div>
											<div class="productCaption clearfix">
										<a href="single-product.html">
											<h4><font color="violet">${product.name}</font></h4>
										</a>
										<h3><font color="darkgrey">$${product.price}</font></h3>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</section>
		<script>
		var elem = document.getElementById("LinkProduct");
		elem.className += " active";
		var e = document.querySelector("#sortOrder");
		e.value = ${sortOrder};
		e.addEventListener("change", function() {
			window.location.href = "/ShoppingCart/ProductGrid?" + ${categoryQuery} "sort=" + this.value;
		});
	</script>
	

<%@ include file="Footer.jsp"%>
      