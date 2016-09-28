<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<%@ include file="Footer.jsp"%>
