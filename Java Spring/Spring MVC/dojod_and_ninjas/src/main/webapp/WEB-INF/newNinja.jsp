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
		<div class="container mt-4 bg-info rounded">
			<h1>Create New Ninja</h1>
			<div class="bg-infop-3">
				<!-- //// CREATE NEW DOJO FORM ///////////////// -->
				<form:form action="/add-new-ninja" method="post" modelAttribute="ninja">
					<form:label path="dojo">Dojo:</form:label>
					
					<form:select path="dojo" class="form-select">
						<c:forEach var="dojo" items="${dojos}">
							<form:option value="${dojo.id}" path="dojo">
								${ dojo.name }
							</form:option>
						</c:forEach>
					</form:select>
					
					<p class="form-group">
						<form:label path="firstName">First Name:</form:label>
						<form:input class="form-control mb-3" path="firstName" />
						<form:errors path="firstName" class="alert alert-danger mb-3" />
					</p>
					<p class="form-group">
						<form:label path="lastName">Last Name:</form:label>
						<form:input class="form-control mb-3" path="lastName" />
						<form:errors path="lastName" class="alert alert-danger mb-3" />
					</p>
					<p class="form-group">
						<form:label path="age">Age in years:</form:label>
						<form:input class="form-control mb-3" path="age" type="number" />
						<form:errors path="age" class="alert alert-danger mb-3" />
					</p>
					<input class="btn btn-success mb-3" type="submit"
						value="Create" />
				</form:form>
			</div>
		</div>
	</main>
	   
</body>
</html>

