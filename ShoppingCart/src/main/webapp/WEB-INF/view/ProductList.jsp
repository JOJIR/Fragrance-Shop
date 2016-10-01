<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
               
                <li class="active">Product List </li>
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
              <div class="panel panel-default">
                <div class="panel-heading">Product categories</div>
                <div class="panel-body">
                  <div class="collapse navbar-collapse navbar-ex1-collapse navbar-side-collapse">
                    <ul class="nav navbar-nav side-nav">
                      <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#men">Men <i class="fa fa-plus"></i></a>
                        <ul id="men" class="collapse collapseItem">
                          <c:forEach items="${maleCategoryList}" var="maleCategory">
		                   	<li><a href="/ShoppingCart/ProductList?category==${maleCategory.id}"><i class="fa fa-caret-right" aria-hidden="true"></i>${maleCategory.name}</a></li>
		                  	</c:forEach>
		                  </ul>
                      </li>
                                <li><a href="javascript:;" data-toggle="collapse" data-target="#women">Women <i class="fa fa-plus"></i></a>
                        <ul id="women" class="collapse collapseItem">
                        <c:forEach items="${femaleCategoryList}" var="femaleCategory">
                          <li><a href="/ShoppingCart/ProductList?category==${femaleCategory.id}"><i class="fa fa-caret-right" aria-hidden="true"></i>${femaleCategory.name}</a></li>
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
				<div class="row productListSingle">

					<c:forEach items="${productList}" var="product">
						<div class="col-xs-12">
							<div class="media">
								<div class="media-left">
									<img class="media-object indexproducts"
										src="resources/image/products/${product.id}.jpg" alt="Image">
									<span class="maskingImage"><a data-toggle="modal"
										href=".quick-view" class="btn viewBtn">Quick View</a></span>
								</div>
								<div class="media-body">
									<div class="col-xs-10 content-wrap">
										<h4 class="media-heading">
											<a href="SingleProduct"><font color="violet">${product.name}</font></a>
										</h4>
										<p><font color="lightblue">${product.description}</font></p>
										<h3><font color="darkgrey">$${product.price}</font></h3>
										<div class="btn<-group" role="group">
											
											<button type="button" class="btn btn-default"
												onclick="location.href='cart-page.html';">
												<i class="fa fa-shopping-cart" aria-hidden="true"></i>
											</button>
										</div>
									</div>
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
      </section>
	<script>
		var e = document.querySelector("#sortOrder");
		e.value = ${sortOrder};
		e.addEventListener("change", function() {
			window.location.href = "/ShoppingCart/ProductList?sort=" + this.value;
		});
	</script>
	<%@ include file="Footer.jsp"%>
					
											
	
											
	