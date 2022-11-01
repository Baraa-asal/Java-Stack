<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256" import="java.util.Date" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Fruit</title>
</head>
<body>
	<h1>Hello there</h1>
	<% for(int i = 0; i < 5; i++) { %>
	<h1><%= i %></h1>
	<% } %>
	
	<h3>The time is: <%= new Date() %></h3>
	
	<h1>Fruit of the day: </h1>
	<h2><c:out value="${fruit}"></c:out></h2>
	
</body>
</html>