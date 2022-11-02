<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Fruits</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<main>
		<h1>Fruit Store</h1>
		
		<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Name</th>
	      <th scope="col">Price</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="fruit" items="${fruits_arraylist}">
	    <tr>
	      <td><c:out value="${ fruit.getName() }"></c:out></td>
	      <td><c:out value="${ fruit.getPrice() }"></c:out></td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>	
	</main>
</body>
</html>