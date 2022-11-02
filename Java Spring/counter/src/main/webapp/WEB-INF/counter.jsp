<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Current visit count</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<main>
	<h3 class="mb-3">You have visited <a href="/">http://your_server  </a><span>  (( <c:out value="${count}"></c:out> )) </span>times</h3>
	<h3><a class="btn btn-info mb-2" href="/">Test another visit?</a></h3>
	<h3><a class="btn btn-success mb-2" href="/double_counter">Double counter.</a></h3>
	<h3><a class="btn btn-danger" href="/reset">Reset counter.</a></h3>
	
</main>
</body>
</html>