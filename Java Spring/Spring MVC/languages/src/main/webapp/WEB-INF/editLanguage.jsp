<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/script.js" defer></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="mt-3" style="font-family: cursive;">


		<h1>Edit Languages</h1>
	

	<div class="container">
		<h3>Edit a language:</h3>
		<form:form action="/languages/${language.id}" method="post"
			modelAttribute="currentLanguage">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="name">Language Name: </form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="creator">Creator: </form:label>
				<form:errors path="creator" class="text-danger" />
				<form:input path="creator" />
			</p>
			<p>
				<form:label path="version">Version: </form:label>
				<form:errors path="version" class="text-danger" />
				<form:input path="version" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>