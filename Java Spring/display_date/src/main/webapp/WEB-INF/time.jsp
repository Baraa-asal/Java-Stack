<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="windows-1256">
<title>Display Time</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/time.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>

</head>

<body>
	<div class="main_container">
	<h3><c:out value="${time}"></c:out></h3>
	</div>
</body>

</html>