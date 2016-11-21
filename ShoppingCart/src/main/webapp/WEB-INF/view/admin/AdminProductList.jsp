<!-- MAIN CONTENT SECTION -->
      <section class="adminHome mainContent clearfix productsContent">
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
                          	<li><a href="/ShoppingCart/AdminProductList?category=${maleCategory.id}"><i class="fa fa-caret-right" aria-hidden="true"></i>${maleCategory.name}</a></li>
						</c:forEach>
                        </ul>
                      </li>
                                <li><a href="javascript:;" data-toggle="collapse" data-target="#women">Women <i class="fa fa-plus"></i></a>
                        <ul id="women" class="collapse collapseItem">
                          <c:forEach items="${femaleCategoryList}" var="femaleCategory">
                          <li><a href="/ShoppingCart/AdminProductList?category=${femaleCategory.id}"><i class="fa fa-caret-right" aria-hidden="true"></i>${femaleCategory.name}</a></li>
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
										href=".quick-view" class="btn viewBtn"> </a></span>
								</div>
								<div class="media-body">
									<div class="col-xs-10 content-wrap">
										<h4 class="media-heading">
											<a href="SingleProduct"><font color="violet">${product.name}</font></a>
										</h4>
										<p><font color="lightblue">${product.description}</font></p>
										<h3><font color="darkgrey">$${product.price}</font></h3>
										<ul class="list-inline">
											<li><h4><font color="darkgrey">Category:${product.category.name}</font></h4></li>
											<li><h4><font color="darkgrey">Supplier:${product.supplier.name}</font></h4></li>
										</ul>
										<div class="btn-group" role="group">
										<button type="button" class="btn btn-default"
												onclick="location.href='/ShoppingCart/EditProduct?id=${product.id}';">
												<i class="fa fa-pencil" aria-hidden="true"></i>
											</button>	
											<button type="button" class="btn btn-default"
												onclick="location.href='/ShoppingCart/DeleteProductAttempt?id=${product.id}';">
												<i class="fa fa-times" aria-hidden="true"></i>
											</button>
										</div>
									</div>
									<div class="col-xs-2">
										<i class="fa fa-times"><font color="violet">${product.quantity}</font></i>
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
			window.location.href = "/ShoppingCart/AdminProductList?sort="
					+ this.value;
		});
	</script>