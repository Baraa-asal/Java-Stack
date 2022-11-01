<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Simple Receipt</title>
</head>
<body>

	<h1>Customer Name: <c:out value ="${name}"></c:out></h1>
	<h3>Item Name: <c:out value="${item_name}"></c:out></h3>
	<h3>Price: <c:out value="${item_price}"></c:out></h3>
	<h3>Description : <c:out value="${item_desc}"></c:out></h3>
	<h3>Vendor: <c:out value="${vendor}"></c:out></h3>
</body>
</html>