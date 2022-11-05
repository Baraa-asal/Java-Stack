<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Ninja Gold</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body class="container" style="font-family: cursive; padding:10%;">

	<h4 class="mb-5"> Your Golds: <span class="border p-2"><c:out value="${gold}"></c:out></span></h4>
	
	<div class="d-flex justify-content-around">
		<div class="p-3 d-flex flex-column align-items-center" style="background-color: #b4de8d">
			<h4 class="mb-3">Farm</h4>
			<h5 class="mb-3">(earns 10-20 gold)</h5>
			<form action="/addGolds" method="POST">
				<input type="hidden" name="building" value="farm">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		<div class="p-3 d-flex flex-column align-items-center" style="background-color: #d8b781">
			<h4 class="mb-3">Cave</h4>
			<h5 class="mb-3">(earns 10-20 gold)</h5>
			<form action="/addGolds" method="POST">
				<input type="hidden" name="building" value="cave"> <input
					type="submit" value="Find Gold!">
			</form>
		</div>
		<div class="p-3 d-flex flex-column align-items-center" style="background-color: #a2cbf4">
			<h4 class="mb-3">House</h4>
			<h5 class="mb-3">(earns 10-20 gold)</h5>
			<form action="/addGolds" method="POST">
				<input type="hidden" name="building" value="house">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
		<div class="p-3 d-flex flex-column align-items-center" style="background-color: #c98a84">
			<h4 class="mb-3">Quest</h4>
			<h5 class="mb-3">(earns/takes 50 gold)</h5>
			<form action="/addGolds" method="POST">
				<input type="hidden" name="building" value="quest">
				<input type="submit" value="Find Gold!">
			</form>
		</div>
	</div>
</body>
</html>