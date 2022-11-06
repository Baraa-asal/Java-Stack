<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Rendering Books</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="pt-5">
<table class="table">
  <thead class="thead-dark myTable">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Language</th>
      <th scope="col"># Pages</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="book" items="${books}">
    <tr>
      <th scope="row">${book.id}</th>
      <td><a href="/books/${book.id}">${book.title}</a></td>
      <td>${book.language}</td>
      <td>${book.numberOfPages}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>