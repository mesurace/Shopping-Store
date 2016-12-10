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
						
						

					</tr>
				</c:forEach>
			</table>

			
		</div>
	</div>
</body>
</html>