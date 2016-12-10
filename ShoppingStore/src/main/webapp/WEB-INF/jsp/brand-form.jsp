 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Brand Form</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Brand Form</h2>

		</div>

	</div>

	<div id="container">	
	
	 

		<form:form action="saveBrand" modelAttribute="brand" method="POST">
			<!-- 	<form:errors path="*" cssClass="errorblock" element="div" /> -->
			<!-- need to associate this data with brand id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label><spring:message code="brand.brandName"/></label></td>
						<td><form:input path="brandName" placeholder="Brand Name" /></td>
						<td><form:errors path="brandName"/></td>

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
			<a href="${pageContext.request.contextPath }/brand/list">Back to
				List</a>
		</p>

	</div>

</body>
</html>