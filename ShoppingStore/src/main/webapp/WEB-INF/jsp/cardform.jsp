

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="mum.edu.cs544.model.CardType"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="checkout" modelAttribute="card" method="POST">
		<!-- 	<form:errors path="*" cssClass="errorblock" element="div" /> -->
		<!-- need to associate this data with product id -->
		<form:hidden path="id" />

		<table>
			<tbody>
				<tr>

					<td><label>Card Number:</label></td>
					<td><form:input path="number"/></td>
					<td><form:errors path="number"/></td>

				</tr>

				<tr>
					<form:select path="type">
						<form:options items="${cards}" />
					</form:select>

				</tr>
				<tr>
					<td><label>Year:</label></td>
					<td><form:input path="year" placeholder="Year" /></td>
					<td><form:errors path="year"/></td>

				</tr>

				<tr>
					<td><label>Month:</label></td>
					<td><form:input path="month" placeholder="month" /></td>
					<td><form:errors path="month"/></td>

				</tr>

				<tr>
					<td><label>Security Code:</label></td>
					<td><form:input path="code" placeholder="Code" /></td>
					<td><form:errors path="code"/></td>

				</tr>

				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Validate" class="save" /></td>
				</tr>
			</tbody>
		</table>



	</form:form>
	
	Result:${responsemsg}
</body>
</html>