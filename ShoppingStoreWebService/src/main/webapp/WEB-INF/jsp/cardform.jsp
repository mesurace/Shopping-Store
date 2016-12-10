

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="mum.edu.cs544.model.CardType"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/cardservice" modelAttribute="card" method="POST">
		<!-- 	<form:errors path="*" cssClass="errorblock" element="div" /> -->
		<!-- need to associate this data with product id -->
		<form:hidden path="id" />

		<table>
			<tbody>
				<tr>

					<td><label>Card Number:</label></td>
					<td><form:input path="number" placeholder="Card Number" /></td>

				</tr>

				<tr>
					<td><label>Card Type:</label></td>
					<td><select>
							<c:forEach items="${cards}" var="type">
								<option value="${type}">${type}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><label>Year:</label></td>
					<td><form:input path="year" placeholder="Year" /></td>

				</tr>

				<tr>
					<td><label>Month:</label></td>
					<td><form:input path="month" placeholder="month" /></td>

				</tr>

				<tr>
					<td><label>Security Code:</label></td>
					<td><form:input path="code" placeholder="Code" /></td>

				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>
			</tbody>
		</table>



	</form:form>
</body>
</html>