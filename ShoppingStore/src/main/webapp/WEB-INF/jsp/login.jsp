<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>
</head>

<body>

 <c:if test="${param.error ne null}">
        <div>
            Invalid username and password.
        </div>
     </c:if>
         <c:if test="${param.logout ne null}">
        <div>
            You have been logged out.
        </div>
      </c:if>
      		
            <form action="/login" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div><input type="submit" value="Sign In"/></div>
        </form>
        You dont havae account here
        <a href="/userform">create account</a>
</body>