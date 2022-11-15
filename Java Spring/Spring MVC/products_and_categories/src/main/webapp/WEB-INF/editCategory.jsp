<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Edit ${ currentCategory.name }</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/script.js" defer></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="mt-3" style="font-family: cursive;">

	<div class="container">
	<h4>Edit ${ currentCategory.name }</h4>
		<form:form action="/categories/${currentCategory.id}" method="post"
			modelAttribute="currentCategory">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="name">Category Name: </form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" />
			</p>
			<input type="submit" value="Update Category" />
		</form:form>
	</div>
</body>
</html>