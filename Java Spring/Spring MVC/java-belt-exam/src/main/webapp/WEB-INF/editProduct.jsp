<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Edit ${ currentProduct.name }</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/script.js" defer></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="mt-3" style="font-family: cursive;">

	<div class="container">
		<h4>Edit ${ currentProduct.name }</h4>
		<form:form action="/products/${currentProduct.id}" method="post"
			modelAttribute="currentProduct">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="name">Product Name: </form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="description">Description: </form:label>
				<form:errors path="description" class="text-danger" />
				<form:input path="description" />
			</p>
			<p>
				<form:label path="price">Price: </form:label>
				<form:errors path="price" class="text-danger" />
				<form:input path="price" />
			</p>
			
			<input type="submit" value="Update Product" />
		</form:form>
	</div>
</body>
</html>