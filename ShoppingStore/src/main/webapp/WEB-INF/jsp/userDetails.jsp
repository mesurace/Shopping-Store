<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type = "text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<!-- <script type = "text/javascript" 
         src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> -->

</head>
<body>
	<div align="center">
		<input id="searchText" type="text"><input type="button" value="Search User" id="searchbtn">
	</div>
	
	<script type = "text/javascript" language = "javascript">
	
	$("#searchbtn").click(function(){
	    var searchQuery = $("#searchText").val(); 
		
	    searchProduct(searchQuery);
	});
	
	
	function searchProduct(searchQuery){
       
    	$.ajax({
	    		url: "search_user/"+searchQuery,
	    		type:"GET", 
	    		error: function(response) {
	    			 	
	    			$('#stage').html('Not found');
	            },
	    		success: function(result,status)
	        	{	            	
	    			var obj = jQuery.parseJSON(JSON.stringify(result));
	            	//alert("First Name: : "+obj.firstName+" "+"Last Name: "+obj.lastName+" Email: "+obj.email+" User Name: "+obj.userName);
	            	//alert("hello");
	            	 $('#stage').append('<p> Sex: ' + obj.title+ '</p>');
	            	$('#stage').html('<p>First Name: ' + obj.firstName + '</p>');
	            	$('#stage').html('<p>Last Name: ' + obj.firstName + '</p>');
	            	 $('#stage').append('<p>Age : ' + obj.age+ '</p>');
	            	 $('#stage').append('<p> Sex: ' + obj.title+ '</p>');
	            	 $('#stage').append('<p> Email: ' + obj.email+ '</p>');
	            	 $('#stage').append('<p> Phone: ' + obj.phone+ '</p>');
	            	 $('#stage').append('<p> User Name: ' + obj.userCredential.userName+ '</p>');
	            	 $('#stage').append('<p> Street: ' + obj.address.street+ '</p>');
	            	 $('#stage').append('<p> City: ' + obj.address.city+ '</p>');
	            	 $('#stage').append('<p> State: ' + obj.address.State+ '</p>');
	        
	    }
    });
   }
	
	</script>
	
	<p><h2>Click on the button to load web service:</h2></p>
		
      <div id = "stage" style = "background-color:#cc0;">
        
      </div>
		
      

</body>
</html>