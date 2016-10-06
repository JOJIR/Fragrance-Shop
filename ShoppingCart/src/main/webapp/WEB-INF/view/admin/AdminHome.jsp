<%@ include file="../user/Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<section class="lightSection pageHeader">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="page-title">
						<h2><font color='white'>Admin home</font></h2>
					</div>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb pull-right">
						<li><a href="Home">Home</a></li>
						<li class="active">Admin Home</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	

	<section class="mainContent crud form-body">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-xs-12">
					<div class="panel panel-inverse">
						<div class="panel-heading">
							<h3>Product </h3>
						</div>
						<div id="addProduct" class="panel-body">
							<div class="btn-group-vertical">
								<button type="button" class="btn btn-primary" onclick="window.location.href='AddProduct'">Add
									Product</button>
								<button type="button" class="btn btn-primary" onclick="window.location.href='AdminProductList'" >
									Update Products</button>
							</div>
						</div>
					</div>
				</div>
							<div class="col-md-4 col-xs-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>Category </h3>
					</div>
					<div id="addCategory" class="panel-body">
						<div class="btn-group-vertical">
							<button type="button" class="btn btn-primary"
							onclick="window.location.href='AddCategory'">Add Category</button>
							<button type="button" class="btn btn-primary"
							onclick="window.location.href='AdminCategoryList'">
								Update Categories</button>
						</div>
					</div>
				</div>
			</div>
				
				
				<div class="col-md-4 col-xs-12">
					<div class="panel panel-inverse">
						<div class="panel-heading">
							<h3>Supplier </h3>
						</div>
						<div id="addSupplier" class="panel-body">
							<div class="btn-group-vertical">
								<button type="button" class="btn btn-primary" onclick="window.location.href='AddSupplier'" >Add
									Supplier</button>
								<button type="button" class="btn btn-primary"
									onclick="window.location.href='AdminSupplierList'">
									Update Suppliers</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<c:if test="${isAdminAddProductClicked == true}">
	<%@ include file="AddProduct.jsp" %>
</c:if>
<c:if test="${isAdminEditProductClicked == true}">
	<%@ include file="EditProduct.jsp" %>
</c:if>
<c:if test="${isAdminAddSupplierClicked == true}">
	<%@ include file="AddSupplier.jsp" %>
</c:if>
<c:if test="${isAdminEditSupplierClicked == true}">
	<%@ include file="EditSupplier.jsp" %>
</c:if>
<c:if test="${isAdminAddCategoryClicked == true}">
	<%@ include file="AddCategory.jsp" %>
</c:if>
<c:if test="${isAdminEditCategoryClicked == true}">
	<%@ include file="EditCategory.jsp" %>
</c:if>
<c:if test="${isAdminViewProductsClicked == true}">
	<%@ include file="AdminProductList.jsp" %>
</c:if>
<c:if test="${isAdminViewSuppliersClicked == true}">
	<%@ include file="AdminSupplierList.jsp" %>
</c:if>
<c:if test="${isAdminViewCategoriesClicked == true}">
	<%@ include file="AdminCategoryList.jsp" %>
</c:if>
	
	<%@ include file="../user/Footer.jsp"%>

