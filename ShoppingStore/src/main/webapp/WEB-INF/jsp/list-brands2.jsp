<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Brand List</title>
<!-- reference to the css file -->


<link type="text/css" rel="stylesheet"
	href="/ShoppingStore/src/main/webapp/WEB-INF/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Brand Form</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">




			<!-- add html table here -->
			<table>
				<tr>
					<th>Brand Name</th>					
					
				</tr>
				<!-- loop and print our brands -->
				<c:forEach var="tempBrand" items="${brands}">

					<!-- construct an "update" link with brand id -->
					<c:url var="updatelink" value="/brand/showFormForUpdate">
						<c:param name="brandId" value="${tempBrand.id }"></c:param>
					</c:url>

					<!-- construct an "delete" link with brand id -->
					<c:url var="deletelink" value="/brand/delete">
						<c:param name="brandId" value="${tempBrand.id }"></c:param>
					</c:url>
					<tr>
						<td>${ tempBrand.brandName}</td>
						
						

					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
</body>
</html>