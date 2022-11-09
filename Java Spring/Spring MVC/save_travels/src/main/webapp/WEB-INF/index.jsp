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
<body>

	<div class="container">
		<h1>Save Travels</h1>
		<table class="table table-striped table-bordered">
			<thead >
				<tr>
					<th class="text-center">Expense</th>
					<th class="text-center">Vendor</th>
					<th class="text-center">Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
						<td class="text-center"><c:out value="${expense.name}"></c:out></td>
						<td class="text-center"><c:out value="${expense.vendor}"></c:out></td>
						<td class="text-center">$<c:out value="${expense.amount}"></c:out></td>
						<td class="text-center"><a href="/expenses/${expense.id}">Edit</a></td>
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