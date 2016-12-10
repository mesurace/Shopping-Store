 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Category Form</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Category Form</h2>

		</div>

	</div>

	<div id="container">	
		<h3>Save Category</h3>

		<form:form action="saveCategory" modelAttribute="category" method="POST">
			<!-- 	<form:errors path="*" cssClass="errorblock" element="div" /> -->
			<!-- need to associate this data with category id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Category Name:</label></td>
						<td><form:input path="categoryName" /></td>
						<td><form:errors path="categoryName"/></td>

					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>



		</form:form>
		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath }/category/list">Back to
				List</a>
		</p>

	</div>

</body>
</html>