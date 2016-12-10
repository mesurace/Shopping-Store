<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
	<div align="center">
		<input id="searchText" type="text"><input type="button" value="Search User" id="searchbtn">
	</div>
	<script type="text/javascript">
	
	$("#searchbtn").click(function(){
	    var searchQuery = $("#searchText").val(); 
		
	    searchProduct(searchQuery);
	});
	</script>

</body>
</html>