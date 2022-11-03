<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>Send an Omikuji</h1>
		<form action="/form_data" method = "POST">
			<div class="form-group col-4 mb-2 ">
				<label>Pick any number from 5 to 25: </label> 
			</div>
			<div class="form-group col-4 mb-2 ">
				<input class="bg-light" type="number" name="number" min="5" max="25" class="form-control"></input>
			</div>
			<div class="form-group col-4 mb-2">
				<label>Enter the name of any city: </label>
				<input class="bg-light" type="text" name="city" class="form-control"></input>
			</div>
			<div class="form-group col-4 mb-2">
				<label>Enter the name of any real person: </label>
				<input class="bg-light" type="text" name="person" class="form-control"></input>				
			</div>
			<div class="form-group col-4 mb-2">
				<label>Enter professional endeavor or hobby: </label>
				<input class="bg-light" type="text" name="hobby" class="form-control"></input>
			</div>
			<div class="form-group col-4 mb-2">
				<label>Enter any type of living thing: </label>
				<input class="bg-light" type="text" name="livingThing" class="form-control"></input>
			</div>
			<div class="form-group col-4 mb-2">
				<label>Say something nice to someone: </label>
				<textarea class="bg-light" class="form-control" rows="3" name="message"></textarea>			
			</div>
			<p><i>Send and show a friend</i></p>	
			<button type="submit" class="btn btn-primary">Send</button>		
		</form>		
		
	</div>	
</body>
</html>