<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>${dojo} Ninjas</title>
</head>
<body>
	<main>
		<div class="container mt-4 bg-info rounded">
			<h1>${ dojo.name } Ninjas</h1>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col"><strong>First Name</strong></th>
						<th scope="col"><strong>Last Name</strong></th>
						<th scope="col"><strong>Age</strong></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ninja" items="${ dojo.ninjas }">
						<tr>
							<td>${ ninja.firstName }</td>
							<td>${ ninja.lastName }</td>
							<td>${ ninja.age }</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
</body>
</html>