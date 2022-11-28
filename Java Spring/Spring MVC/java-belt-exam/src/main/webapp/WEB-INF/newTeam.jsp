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
<title>Kickball League</title>
</head>
<body>
	<header>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<a href="/" class="col-4 navbar-brand"> <strong
					class="text-warning">Kickball League</strong>
				</a>
				<div class="col-6 row align-items-center">
					<p class="col text-white m-2">Welcome, ${ loggedInUser.userName }!</p>
					<button class="col btn btn-info btn-sm round m-2"
						onclick="window.location.href='/home';">Home</button>
					<button class="col btn btn-danger btn-sm round"
						onclick="window.location.href='/logout';">Log-Out</button>
				</div>
			</div>
		</div>
	</header>
	<main role="main">
		<div class="container mt-4">
			<div class="row">
				<div class="col-10">
					<h3 class="mb-3" style="color: #244c30;">Add a Team, ${ loggedInUser.userName }!</h3>
					<form:form action="/teams/new/" method="post"
						modelAttribute="newTeam">
						<form:input type="hidden" path="user" value="${loggedInUser.id}"></form:input>
						<p class="form-group">
							<form:label path="teamName">Team Name:</form:label>
							<form:errors path="teamName" class="alert text-danger" />
							<form:input class="form-control mb-3" path="teamName" />
						</p>
						<p class="form-group">
							<form:label path="skillLevel">Skill Level (1-5):</form:label>
							<form:errors path="skillLevel" class="alert text-danger" />
							<form:input type="number" class="form-control mb-3"
								path="skillLevel" />
						</p>
						<p class="form-group">
							<form:label path="gameDay">Game Day:</form:label>
							<form:errors path="gameDay" class="alert text-danger" />
							<form:input class="form-control mb-3" path="gameDay" />
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