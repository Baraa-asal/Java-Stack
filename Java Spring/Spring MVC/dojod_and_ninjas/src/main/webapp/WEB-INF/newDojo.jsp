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

<meta charset="UTF-8">
<title>New Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<main>
		<div class="container mt-4">
			<h1>New Dojo</h1>
			<div class="bg-infop-3">
				<form:form action="/add-new-dojo" method="post" modelAttribute="dojo">
					<p class="form-group">
						<form:label path="name">Name:</form:label>
						<form:input class="form-control mb-3" path="name" />
						<form:errors path="name" class="alert alert-danger mb-3" />
					</p>
					<input class="btn btn-success" type="submit" value="Create" />
				</form:form>
			</div>
		</div>
	</main>
	   
</body>
</html>

