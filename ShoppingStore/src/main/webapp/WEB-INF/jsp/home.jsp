<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Products</title>
<!-- reference to the css file -->
<style>
.table {
	width: 100%;
}

th {
	height: 50px;
	text-align: left;
}

th, td {
	border-bottom: 1px solid #ddd;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}
</style>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>All Products</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">

			<form action="/search" method="GET">
				<input type="text" name="search" placeholder="Search..">
			</form>
			<!-- add html table here -->
			<table class="table">
				<tr>
					<th>Product</th>
					<th>Price</th>
					<th>Description</th>
					<th>Brand</th>
					<th>Category</th>
					<th>Image</th>
					<th>Action</th>
				</tr>
				<!-- loop and print our products -->
				<c:forEach var="tempProduct" items="${products}">

					<!-- construct an "update" link with product id -->
					<c:url var="addcart" value="addToCart">
						<c:param name="productId" value="${tempProduct.id }"></c:param>
					</c:url>

					<tr>
						<td>${ tempProduct.name}</td>
						<td>${ tempProduct.price}</td>
						<td>${ tempProduct.description}</td>
						<td>${ tempProduct.brand.brandName}</td>
						<td>${ tempProduct.category.categoryName}</td>
						<td><img src="/resources/images/${tempProduct.name}.jpg"
							width="150" height="100" /></td>
						<td><a href="${addcart}">ADD TO CART</a></td>

					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>