<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<style>
ul.tab {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Float the list items side by side */
ul.tab li {
	float: right;
}

/* Style the links inside the list items */
ul.tab li a {
	display: inline-block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of links on hover */
ul.tab li a:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
ul.tab li a:focus, .active {
	background-color: #ccc;
}
</style>
</head>
<body>


	
	<div>
		<a href="?language=en">English | </a><a href="?language=en_IN"
			class="lang">Nepali</a>
	</div>
	<nav id="primary_nav_wrap">
		<ul class="tab">

			
			<li class="current-menu-item"><a href="/cart"> <spring:message
						code="menu.cart" text="default text" />
			</a><br></li>
			<li class="current-menu-item"><a href="/categoryList"><spring:message
						code="menu.category" text="default text" /></a><br></li>
			<li class="current-menu-item"><a href="/brandList"><spring:message
						code="menu.brand" text="default text" /></a><br></li>
			<li class="current-menu-item"><a href="http://localhost:8080/"><spring:message
						code="menu.home" text="default text" /></a><br></li>





		</ul>
	</nav>

</body>
</html>