
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ include file="Header.jsp"%>
	 <!-- LIGHT SECTION -->
	      <section class="lightSection clearfix pageHeader">
	        <div class="container">
	          <div class="row">
	            <div class="col-xs-6">
	              <div class="page-title">
	                <h2>Single Product</h2>
	              </div>
	            </div>
	            <div class="col-xs-6">
	              <ol class="breadcrumb pull-right">
	                <li>
	                  <a href="Home">Home</a>
	                </li>
	                <li class="active">${product.name}</li>
	              </ol>
	            </div>
	          </div>
	        </div>
	      </section>
	      <!-- MAIN CONTENT SECTION -->
	      <section class="mainContent clearfix">
	        <div class="container">
	          <div class="row singleProduct">
	            <div class="col-xs-12">
	              <div class="media">
	                <div class="media-left productSlider">
	                  <img src="resources/image/products/${product.id}.jpg">
	                  <h2>${product.name}</h2>
	                  <h3>$${product.price}</h3>
	                  <p>${product.description}</p>
	                  </div>
	                  </div>
	                  </div>
	                  </div>
	                  </div>
	                  </section>
	                  
	           
	<%@ include file="Footer.jsp"%>
