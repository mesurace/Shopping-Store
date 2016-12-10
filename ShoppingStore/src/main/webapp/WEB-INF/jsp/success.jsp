<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center">
				<tr>
					<th>User Name</th>					
					<th>Action</th>
				</tr>
				<!-- loop and print our users -->
				<c:forEach var="users" items="${users}">

					<!-- construct an "update" link with user id -->
					<c:url var="updatelink" value="showFormForUpdate">
						<c:param name="userName" value="${users.userCredential.userName }"></c:param>
					</c:url>

					<!-- construct an "delete" link with user id -->
					<c:url var="deletelink" value="delete">
						<c:param name="id" value="${users.id }"></c:param>
					</c:url>
					<tr>
						<td>${ users.userCredential.userName}</td>
						
						<td><a href="${updatelink}">Update</a> | <a
							href="${deletelink}"
							onclick="if(!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
							<!-- javasprit code --></td>

					</tr>
				</c:forEach>
			</table>

			<!-- for add user link -->
			<table align="center" cellPadding="2px">
				
				<tr>
				<td><a href="/userform">Add User</a></td>
				<td><a href="/searchform">Search User</a></td>
				</tr>
			</table>
</body>
</html>