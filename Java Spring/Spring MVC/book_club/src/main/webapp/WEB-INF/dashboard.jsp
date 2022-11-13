<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>${loggedInUser.userName}Profile</title>
</head>
<body style="font-family: cursive;">
	<div class="container mt-2 mb-5 d-flex justify-content-between">
		<div class="row">
			<h1 style="color: #9900ff;">Welcome, ${loggedInUser.userName}!</h1>
			
		</div>
		<div class="d-flex align-items-end flex-column">
			<a class="mb-4" style="color: red;" href="/logout"><u>Logout</u></a>
			<a href="/books/new"><u>+ add a book to my shelf!</u></a>
		</div>
	</div>

	<main>
		<table class="table container table-striped">
			<thead>
				<tr>
					<th scope="col"><strong>ID</strong></th>
					<th scope="col"><strong>Title</strong></th>
					<th scope="col"><strong>Author Name</strong></th>
					<th scope="col"><strong>Posted By</strong></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${ bookList }">
					<tr>
						<td>${ book.id }</td>
						<td><a href="/books/${ book.id }"><u>${ book.title }</u></a></td>
						<td>${ book.author }</td>
						<td>${ book.user.userName }</td>
						
						
						
						<td class="row">
							<!-- **************************** Button that points to Book View ****************************** -->
							<div class="col">
								<button class="btn btn-primary btn-sm round"
									onclick="window.location.href='/books/${ book.id }';">View</button>
							</div> <c:choose>
								<c:when test="${user_id == book.user.id}">
									<div class="col">
										<button class="btn btn-warning btn-sm round"
											onclick="window.location.href='/books/${ book.id }/edit';">Edit</button>
									</div>
									<!-- **** Button that deletes Book ************ -->
									<form class="col" action="/books/${ book.id }/delete"
										method="post">
										<input type="hidden" name="_method" value="delete">
										<!-- ### Converts method of form to DELETE ### -->
										<button class="btn btn-danger btn-sm round">Delete</button>
									</form>
								</c:when>
							</c:choose>
						</td>
						
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>

</body>
</html>