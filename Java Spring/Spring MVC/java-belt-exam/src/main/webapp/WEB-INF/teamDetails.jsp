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
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>${ team.teamName }Team</title>
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

	<!-- //// MAIN AREA //////////////////////////////////////// -->
	<main role="main">
		<div class="container mt-4">
			<h1 class="mb-3">${ team.teamName }</h1>
			<div class="round p-3">
				<h4>
					<strong>Team Name:</strong> ${team.teamName }
				</h4>
				<h4>
					<strong>Skill Level:</strong> ${team.skillLevel }
				</h4>
				<h4>
					<strong>Game Day:</strong> ${team.gameDay }
				</h4>
				<h4>
					<strong>Players:</strong>

					<ol>
						<c:forEach var="player" items="${ players_list }">
							<li>- <c:out value="${player.userName}" /> <a
								class="text-danger"
								href="/deleteplayer/${ player.id }/${ team.id }"><u>Remove
										player</u></a>
							</li>
						</c:forEach>
					</ol>
				</h4>

				<c:choose>
					<c:when test="${user_id == team.user.id}">
						<div class="row mt-3">
							<div class="col-2">
								<button class="btn btn-warning btn-sm round"
									onclick="window.location.href='/teams/${ team.id }/edit';">Edit</button>
							</div>

							<form class="col-2" action="/teams/${ team.id }/delete"
								method="post">
								<input type="hidden" name="_method" value="delete">
								<button class="btn btn-danger btn-sm round">Delete</button>
							</form>
						</div>
					</c:when>
				</c:choose>
			</div>

			<h4 class="text-center">Add Player:</h4>
			<div class="container col-4">
				<form action="/teams/${team.id}" method="post">
					<select class="form-control" name="selectedPlayer">
						<c:forEach var="player" items="${playersAvailable}">
							<option value="${player.id}">
								<c:out value="${player.userName}"></c:out>
							</option>
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-sm btn-success mt-3">Add</button>
				</form>
			</div>

		</div>
	</main>

</body>