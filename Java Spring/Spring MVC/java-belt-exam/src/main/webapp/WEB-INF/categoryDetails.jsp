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
<title>${ category.name }</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="row">
		<h2 class="text-center">
			Category: ${category.name} <a class="btn btn-outline-primary btn-sm"
				href="/categories/${ category.id }/edit">edit</u></a>
			<form:form action="/categories/${category.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<button type="submit" class="btn btn-outline-danger btn-sm">Delete ${category.name}</button>
			</form:form>
		</h2>
		<h5 class="container col-4 p-2 mb-2 border-bottom">
			<a href="/"><u>Home</u></a>
		</h5>
	</div>

	<div class="container col-4 mb-3">
		<ol>
			<c:forEach var="product" items="${ category.products }">
				<li>- <c:out value="${product.name}" /> <a class="text-danger"
					href="/deleteProduct/${ category.id }/${ product.id }"><u>Remove
							Product</u></a>
				</li>
			</c:forEach>
		</ol>
	</div>

	<h4 class="text-center">Add Product:</h4>
	<div class="container col-4">
		<form action="/categories/${category.id}" method="post">
			<select class="form-control" name="selectedProduct">
				<c:forEach var="product" items="${productsAvailable}">
					<option value="${product.id}">
						<c:out value="${product.name}"></c:out>
					</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-sm btn-success mt-3">Add</button>
		</form>
	</div>

</body>
</html>
