<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Add new product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="row">
		<h4 class=" text-center">Add new product</h4>
		<h5 class="container col-4 p-2 mb-3 border-bottom">
			<a href="/"><u>Home</u></a>
		</h5>
	</div>
	<div class="row justify-content-center">
		<div class="col-4 p-2">
			<form:form action="/products/new" method="POST"
				modelAttribute="product">
				<div class="row justify-content-start">
					<div class="col-6">
						<form:label path="name">Name: </form:label>
						<p class="text-danger">
							<form:errors path="name" />
						</p>
					</div>
					<div class="col-6">
						<form:input path="name" />
					</div>
				</div>
				<div class="row justify-content-start">
					<div class="col-6">
						<form:label path="description">Description: </form:label>
						<p class="text-danger">
							<form:errors path="description" />
						</p>
					</div>
					<div class="col-6">
						<form:input path="description" />
					</div>
				</div>
				<div class="row justify-content-start">
					<div class="col-6">
						<form:label path="price">Price: </form:label>
						<p class="text-danger">
							<form:errors path="price" />
						</p>
					</div>
					<div class="col-6">
						<form:input path="price" />
					</div>
				</div>
				<div class="row justify-content-center p-4">
					<input type="submit" value="Create Product" class="btn btn-success" />
				</div>
			</form:form>
		</div>
	</div>


</body>
</html>