<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Search user Form</title>
</head>
<body>
	<div id="wrapper">
		<div id="header" align="center">
		<a href="?language=en">English | </a><a href="?language=en_IN"
			class="lang">Spanish</a>
			<h2> <spring:message
						code="create.account" text="default text" /></h2>
		</div>
	</div>
	<div id="container">
		

		<div id="userForm" align="center">
		<!-- <h3>create A ccount </h3> -->
			<form:form action="userform" method="POST" modelAttribute="user">
			
				<div id="userElement">
					<form:label path="">Title</form:label>
					<form:select path="title">
						<form:option value="Mr." label="Mr." />
						<form:option value="Ms." label="Ms." />
						<%-- <form:errors path="title" cssStyle="color : red; " /> --%>
					</form:select>
				</div>
				<div id="formElement">
					
					<form:label path="">First Name</form:label>
					<form:input path="firstName" /><form:errors path="firstName" cssStyle="color : red;"/>
				</div>
				<div id="formElement">
					<form:label path="">Last Name</form:label>
					<form:input path="lastName" />
				</div>
				
				<div id="formElement">
					<form:label path="">Age</form:label>
					<form:label path="age"></form:label>
					<form:input path="age" />
				</div>
				
				<div id="formElement">
					<form:label path="dateOfBirth">Date Of Birth</form:label>
					<form:input type="date" path="dateOfBirth" placeholder="yyyy-mm-dd" /><form:errors path="dateOfBirth" cssStyle="color : red;"/>
				</div>
				<div id="formElement">
					<form:label path="email">Email</form:label>
					<form:input path="email"  />
				</div>
				
				<div id="formElement">
					<form:label path="userCredential.userName">User Name</form:label>
					<form:input path="userCredential.userName"  />
					<form:errors path="userCredential.userName" cssStyle="color : red;"/>
				</div>
				
				<div id="formElement">
					<form:label  path="userCredential.password">Password</form:label>
					<form:input type="password" path="userCredential.password"  />
				</div>
				
				<div id="formElement">
					<form:label path="userCredential.rePassword">Re-Password</form:label>
					<form:input type="password" path="userCredential.rePassword"  />
				</div>
				
				<div id="formElement">
					<form:label path="phone">Phone</form:label>
					<form:input path="phone"  />
				</div>
				
				<h2>Address</h2>
				
				<%-- <div id="formElement">
					<form:label path="address.street">Phone</form:label>
					<form:input path="address.street"  />
				</div> --%>
				<div id="formElement">
					<form:label path="address.street">Street</form:label>
					<form:input path="address.street"  /><form:errors path="address.street" cssStyle="color : red;"/>
				</div>
				
				<div id="formElement">
					<form:label path="address.city">City</form:label>
					<form:input path="address.city"  />
				</div>
				
				<div id="formElement">
					<form:label path="address.state">State</form:label>
					<form:input path="address.state"  />
				</div>
				
				<div id="formElement">
					<form:label path="address.zip">Zip</form:label>
					<form:input path="address.zip"  />
				</div>
				
				<div id="formElement">
					<input type="submit" value="Next" />
				</div>
				
				
				

			</form:form>
		</div>
		<p>
			<a href="/">Back to
				home</a>
		</p>
	</div>
</body>
</html>