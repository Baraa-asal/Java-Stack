<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>${expense.name}</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="mt-3" style="font-family: cursive;">
	<main class="container">
		<div style="width:40%;" class="d-flex justify-content-between mb-4">
			<h1>Expense Details</h1>
			<a href="/"><u>Go back</u></a>
		</div>

		<div>
			<h4>
				<strong>Expense Name: </strong> ${expense.name}
			</h4>
		</div>
		<div>
			<h4>
				<strong>Expense Description: </strong> ${expense.description}
			</h4>
		</div>
		<div>
			<h4>
				<strong>Vendor: </strong> ${expense.vendor}
			</h4>
		</div>
		<div>
			<h4>
				<strong>Amount Spent: </strong>$ ${expense.amount}
			</h4>
		</div>
	</main>
</body>
</html>