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
<title>Kickball League Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
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

	<main class="d-flex flex-column align-items-center">
		<table class="mb-3 table container table-striped">
			<thead>
				<tr>
					<th scope="col"><strong>Team Name</strong></th>
					<th scope="col"><strong>Skill Level (1-5)</strong></th>
					<th scope="col"><strong>Game Day</strong></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" items="${ teamList }">
					<tr>
						<td><a href="/teams/${ team.id }"><u>${ team.teamName }</u></a></td>
						<td>${ team.skillLevel }</td>
						<td>${ team.gameDay }</td>

						<!-- 
						<td>
								<c:if test="${team.user.id == userId}">
									<td><a href="/teams/${team.id}/edit">edit</a> | <a
										href="/teams/${team.id }/delete">delete</a></td>
								</c:if>
						</td>
 -->
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="d-flex align-items-center justify-content-center">
			<a class="row btn btn-outline-success" href="/teams/new"><u>Create
					New Team</u></a>
		</div>

	</main>
</body>
</html>