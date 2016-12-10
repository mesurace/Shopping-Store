<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Category List</title>
<!-- reference to the css file -->


<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Category Form</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">




			<!-- add html table here -->
			<table>
				<tr>
					<th>Category Name</th>					
					<th>Action</th>
				</tr>
				<!-- loop and print our categorys -->
				<c:forEach var="tempCategory" items="${categorys}">

					<!-- construct an "update" link with category id -->
					<c:url var="updatelink" value="/category/showFormForUpdate">
						<c:param name="categoryId" value="${tempCategory.id }"></c:param>
					</c:url>

					<!-- construct an "delete" link with category id -->
					<c:url var="deletelink" value="/category/delete">
						<c:param name="categoryId" value="${tempCategory.id }"></c:param>
					</c:url>
					<tr>
						<td>${ tempCategory.categoryName}</td>
						
						<td><a href="${updatelink}">Update</a> | <a
							href="${deletelink}"
							onclick="if(!(confirm('Are you sure you want to delete this category?'))) return false">Delete</a>
							<!-- javasprit code --></td>

					</tr>
				</c:forEach>
			</table>

			<!-- for add category button -->
			<input value="Add Category" type="button"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
		</div>
	</div>
</body>
</html>