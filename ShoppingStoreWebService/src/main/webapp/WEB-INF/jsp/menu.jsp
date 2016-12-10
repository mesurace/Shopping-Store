<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<nav id="primary_nav_wrap">
		<ul class="tab">
			<li class="current-menu-item"><a href="/cart">Cart</a><br></li>
			<li class="current-menu-item"><a href="/category/list">Category</a><br></li>
			<li class="current-menu-item"><a href="/brand/list">Brand</a><br></li>
			<li class="current-menu-item"><a href="/product/list">Product</a><br></li>
			<li class="current-menu-item"><a href="http://localhost:8080/">Home</a><br></li>
			


		</ul>
	</nav>

</body>
</html>