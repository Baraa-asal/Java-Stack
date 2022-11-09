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
<title>${loggedInUser.userName} Profile</title>
</head>
<body style="font-family: cursive;">
	<div class="container mt-2">
		<div class="row">
			<h1 style="color: #9900ff;">Welcome, ${loggedInUser.userName}!</h1>
			<h5>This is your dashboard. Nothing to see here yet.</h5>
		</div>
		<a class="btn btn-outline-danger" href="/logout">Logout</a>
	</div>
	

</body>
</html>