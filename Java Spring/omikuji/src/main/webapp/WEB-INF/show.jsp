<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Here's Your Omikuji!</h1>
		
		<div class="border border-3 w-70"  style="background-color:#8FBDD3">
			<p>In <span><c:out value="${number }"/></span>
			 years, you will live in <c:out value="${city}"/>
			  with <c:out value="${person}"/> as your roommate, 
			  <c:out value="${hobby}"/> for living.
			 The next time you see a <c:out value="${living_thing}"/>,
			  you will have good luck. 
			  Also, <c:out value="${message}"/>.</p>
		</div>
		<a href="/">go back</a>
	</div>	
</body>
</html>