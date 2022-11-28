<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="windows-1256">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Kickball League</title>
</head>
<body style="font-family: cursive;">
	
	<main>
		<div class="container mt-4">
			<div class="row">
			
				<h1 style="color: #9900ff;">WELCOME !</h1>
				<form:form class="col" action="/"
					method="post" modelAttribute="newUser">
					<input type="hidden" name="_method" value="put">
					<h2>
						<strong>Register</strong>
					</h2>
					<div class="form-group">
						<label>User Name:</label> <strong> <form:errors
								path="userName" class="text-danger alert mb-3" />
						</strong>
						<form:input path="userName" class="form-control mb-3" />
					</div>
					<div class="form-group">
						<label>Email:</label> <strong> <form:errors path="email"
								class="text-danger text-danger alertmb-3" />
						</strong>
						<form:input path="email" class="form-control mb-3" />
					</div>
					<div class="form-group">
						<label>Password:</label> <strong> <form:errors
								path="password" class="text-danger text-danger alertmb-3" />
						</strong>
						<form:password path="password" class="form-control mb-3" />
					</div>
					<div class="form-group">
						<label>Confirm Password:</label> <strong> <form:errors
								path="confirm" class="text-danger text-danger alert mb-3" />
						</strong>
						<form:password path="confirm" class="form-control mb-3" />
					</div>
					<input type="submit" value="Register"
						class="btn btn-dark" />
				</form:form>

				<form:form class="col m-3" action="/"
					method="post" modelAttribute="newLogin">
					<h2>
						<strong>Log in</strong>
					</h2>
					<div class="form-group">
						<label>Email:</label> <strong>
						<form:errors path="email" class="text-danger alert mb-3" />
						</strong>
						<form:input path="email" class="form-control mb-3" />
					</div>
					<div class="form-group">
						<label>Password:</label> <strong>
						<form:errors path="password" class="text-danger alert mb-3" />
						</strong>
						<form:password path="password" class="form-control mb-3" />
					</div>
					<input type="submit" value="Login" class="btn btn-dark" />
				</form:form>
			</div>
		</div>
	</main>
</body>