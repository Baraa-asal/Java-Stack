<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Book Club</title>
</head>
<body>
	<main role="main">
		<div class="container mt-4">
			<div class="row">
				<div class="col-10">
					<h1>Add a Book to your shelf, ${ loggedInUser.userName }!</h1>
					<form:form class="bg-info round p-3" action="/books/new" method="post" modelAttribute="newBook">

						<p class="form-group">
							<form:label path="title">Book Title:</form:label>
							<form:errors path="title" class="alert text-danger" />
							<form:input class="form-control mb-3" path="title" />
						</p>
						<p class="form-group">
							<form:label path="author">Book Author:</form:label>
							<form:errors path="author" class="alert text-danger" />
							<form:input class="form-control mb-3" path="author" />
						</p>
						<p class="form-group">
							<form:label path="myThoughts">My Thoughts:</form:label>
							<form:errors path="myThoughts" class="alert text-danger" />
							<form:textarea class="form-control mb-3" path="myThoughts" />
						</p>
						<input class="btn btn-primary mb-3" type="submit" value="Submit" />
					</form:form>
				</div>
			</div>
		</div>
	</main>

	<!-- //// JAVASCRIPT LINKS ///////////////////////////////// -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>