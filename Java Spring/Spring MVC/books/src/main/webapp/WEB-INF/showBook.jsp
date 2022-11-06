<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title><c:out value="${book.title}" /></title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="p-2">
	<div class="container">
	<h1><c:out value="${book.title}" /></h1>
	<h3><c:out value="${book.description}" /></h3>
	<h3><c:out value="${book.language}" /></h3>
	<h3><c:out value="${book.numberOfPages}" /></h3>
	</div>
	
	<h5><a href="/books">Go back</a></h5>
</body>
</html>