
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Form</title>

<link type="text/css" rel="stylesheet"
	href="/resources/css/add-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Product Form</h2>

		</div>

	</div>

	<div id="container">
		<h3>Save Product</h3>

		<form:form action="saveProduct" modelAttribute="product" method="POST"
			enctype="multipart/form-data">
			<!-- 	<form:errors path="*" cssClass="errorblock" element="div" /> -->
			<!-- need to associate this data with product id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Product Name:</label></td>
						<td><form:input path="name" placeholder="Product Name" /></td>
				    	<td><form:errors path="name" /></td>
				    	

					</tr>

					<tr>
						<td><label>Price:</label></td>
						<td><form:input   path="price" placeholder="Price of Product" /></td>
						
						<td><form:errors path="price" /></td>
					</tr>

					<tr>
						<td><label>Description:</label></td>
						<td><form:textarea path="description"
								placeholder="Description of Product" /></td>
										<td><form:errors path="description" /></td>

					</tr>

					<tr>
						<td><label>Quantity:</label></td>
						<td><form:input value="1" type="number" path="quantity" placeholder="Quantity" /></td>
												<td><form:errors path="quantity" /></td>

					</tr>

					<tr>
						<td><label>Image:</label></td>
						<td><input type="file" path="image" name="image" required><br>

						</td>
						

					</tr>
					<tr>
						<td><label>Category:</label></td>
						<td><form:select path="category">
						<form:option value="" label="select the category"></form:option>
								<form:options itemLabel="categoryName" itemValue="id"
									items="${categories}" />
							</form:select></td>
					</tr>

					<tr>
						<td><label>Brand:</label></td>
						<td><form:select path="brand">
						<form:option value="" label="select the brand"></form:option>
								<form:options itemLabel="brandName" itemValue="id"
									items="${brands}" />
							</form:select></td>
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
			<a href="${pageContext.request.contextPath }/product/list">Back
				to List</a>
		</p>

	</div>

</body>
</html>