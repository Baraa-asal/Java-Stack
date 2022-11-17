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
<title>Products and Categories</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<div class="container">
		<div class="row p-3">
			<h1 class="text-center">Products and Categories</h1>
			<h5>
				<a href="/products/new">New Product</a>
			</h5>
			<h5>
				<a href="/categories/new">New Category</a>
			</h5>
		</div>

		<div class="row">
			<table class="table table-bordered table-striped">

				<thead class="thead-dark">
					<tr>
						<td><h4>Products</h4></td>
						<td><h4>Categories</h4></td>
					</tr>
				</thead>

				<tbody>

					<tr>

						<td>
							<ol>
								<c:forEach var="product" items="${ products }">
									<li><a href="/products/${ product.id }"><c:out
												value="${product.name}"></c:out></a></li>
								</c:forEach>
							</ol>
						</td>

						<td>
							<ol>
								<c:forEach var="category" items="${ categories }">
									<li><a href="/categories/${ category.id }"><c:out
												value="${category.name}"></c:out></a></li>
								</c:forEach>
							</ol>
						</td>

					</tr>


				</tbody>
			</table>
		</div>

	</div>
</body>
</html>