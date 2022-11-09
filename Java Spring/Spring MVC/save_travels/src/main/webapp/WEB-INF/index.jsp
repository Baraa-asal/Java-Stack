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
<title>Read Share</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/script.js" defer></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body style="font-family: cursive;">

	<div class="container">
		<h1>Save Travels</h1>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th class="text-center">Expense</th>
					<th class="text-center">Vendor</th>
					<th class="text-center">Amount</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td class="text-center"><a href="/expenses/${expense.id}"><c:out value="${expense.name}"></c:out></a></td>
						<td class="text-center"><c:out value="${expense.vendor}"></c:out></td>
						<td class="text-center">$<c:out value="${expense.amount}"></c:out></td>
						<td class="text-center d-flex justify-content-around"><a class="btn btn-info btn-sm mr-3"
							href="/expenses/edit/${expense.id}">Edit</a>
						<form:form action="/expenses/${expense.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<button type="submit" class="btn btn-danger btn-sm">Delete</button>
						</form:form></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="container">
		<h3>Add an expense:</h3>
		<form:form action="/createExpense" method="post"
			modelAttribute="expense">
			<p>
				<form:label path="name">Expense Name: </form:label>
				<form:errors path="name" class="text-danger" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="vendor">Vendor: </form:label>
				<form:errors path="vendor" class="text-danger" />
				<form:input path="vendor" />
			</p>
			<p>
				<form:label path="amount">Amount: </form:label>
				<form:errors path="amount" class="text-danger" />
				<form:input path="amount" />
			</p>
			<p>
				<form:label path="description">Description: </form:label>
				<form:errors path="description" class="text-danger" />
				<form:textarea path="description" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>