<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/script.js" defer></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body style="font-family: cursive;">

	<div class="container">
		<h1>Languages</h1>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">Name</th>
					<th class="text-center">Creator</th>
					<th class="text-center">Version</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="language" items="${languages}">
					<tr>
						<td class="text-center"><a href="/languages/${language.id}"><c:out value="${language.name}"></c:out></a></td>
						<td class="text-center"><c:out value="${language.creator}"></c:out></td>
						<td class="text-center"><c:out value="${language.version}"></c:out></td>
						<td class="text-center d-flex justify-content-around"><a class="btn btn-info btn-sm mr-3"
							href="/languages/edit/${language.id}">Edit</a>
						<form:form action="/languages/${language.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<button type="submit" class="btn btn-danger btn-sm">Delete</button>
						</form:form></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container">
		<h3>Add an language:</h3>
		<form:form action="/createLanguage" method="post"
			modelAttribute="language">
			<p>
				<form:label path="name">Name: </form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="creator">Creator: </form:label>
				<form:errors path="creator" class="text-danger" />
				<form:input path="creator" />
			</p>
			<p>
				<form:label path="version">Version: </form:label>
				<form:errors path="version" class="text-danger" />
				<form:input path="version" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>