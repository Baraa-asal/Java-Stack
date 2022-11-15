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
<title>${product.name}</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="row">
		<h2 class="text-center">
			Product: ${product.name} <a class="btn btn-outline-primary btn-sm"
				href="/products/${ product.id }/edit">edit</a>
			<form:form action="/products/${product.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<button type="submit" class="btn btn-outline-danger btn-sm">Delete ${product.name}</button>
			</form:form>

		</h2>
		<h5 class="container col-4 p-2 mb-2 border-bottom">
			<a href="/"><u>Home</u></a>
		</h5>
	</div>
	<div class="container col-4 mb-3">
		<p>
			<strong>Description:</strong> ${product.description}
		</p>
		<p>
			<strong>Price:</strong> ${product.price}
		</p>
		<p>
			<strong>Categories:</strong>
		</p>
		<ol>
			<c:forEach var="category" items="${product.categories}">
				<li>- <c:out value="${category.name}" /> <a
					class="text-danger"
					href="/deleteCategory/${ product.id }/${ category.id }"><u>Remove
							Category</u></a>
				</li>
			</c:forEach>
		</ol>
	</div>

	<h4 class="text-center">Add Category:</h4>
	<div class="container col-4">
		<form action="/products/${product.id}" method="post">
			<select class="form-control" name="selectedCategory">
				<c:forEach var="category" items="${categoriesAvailable}">
					<option value="${category.id}">
						<c:out value="${category.name}"></c:out>
					</option>
				</c:forEach>
			</select>
			<button type="submit" class="btn btn-sm btn-success mt-3">Add</button>
		</form>
	</div>

</body>
</html>