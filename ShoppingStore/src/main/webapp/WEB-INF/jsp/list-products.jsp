<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Product List</title>
<!-- reference to the css file -->



<link type="text/css" rel="stylesheet"
	href="/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Product Form</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">




			<!-- add html table here -->
			<table width="950">
				<tr>
					<th>Product Name</th>
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
					<c:url var="updatelink" value="/product/showFormForUpdate">
						<c:param name="productId" value="${tempProduct.id }"></c:param>
					</c:url>

					<!-- construct an "delete" link with product id -->
					<c:url var="deletelink" value="/product/delete">
						<c:param name="productId" value="${tempProduct.id }"></c:param>
					</c:url>
					<tr>
						<td>${ tempProduct.name}</td>
						<td>${ tempProduct.price}</td>
						<td>${ tempProduct.description}</td>
						<td>${ tempProduct.brand.brandName}</td>
						<td>${ tempProduct.category.categoryName}</td>


						<td><img src="/resources/images/${tempProduct.name}.jpg" width="150" height="100" /></td>




						<%--  <td><c:if test="${not empty tempProduct.image}"><img src="${tempProduct.image}"/></c:if></td>  --%>
						<td><a href="${updatelink}">Update</a> | <a
							href="${deletelink}"
							onclick="if(!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
							<!-- javasprit code --></td>

					</tr>
				</c:forEach>
			</table>

			<!-- for add product button -->
			<input value="Add Product" type="button"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
		</div>
	</div>
</body>
</html>