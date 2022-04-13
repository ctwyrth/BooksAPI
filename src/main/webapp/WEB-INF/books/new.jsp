<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BooksAPI - New Book</title>

	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mt-5 mx-auto text-center">
			<h1 class="display-5">Add a New Book!</h1>
			<form:form action="/books/add" method="POST" modelAttribute="book" class="col-5 p-3 mx-auto">
				<div class="mb-3">
					<form:label path="title" class="form-label">Title:</form:label>
					<form:input type="text" path="title" class="form-control" />
					<form:errors path="title" />
				</div>
				<div class="mb-3">
					<form:label path="description" class="form-label">Description:</form:label>
					<form:textarea path="description" class="form-control" />
					<form:errors path="description" />
				</div>
				<div class="mb-3">
					<form:label path="language" class="form-label">Language:</form:label>
					<form:input type="text" path="language" class="form-control" />
					<form:errors path="language" />
				</div>
				<div class="mb-3">
					<form:label path="numberOfPages" class="form-label">Pages:</form:label>
					<form:input type="number" path="numberOfPages" class="form-control" />
					<form:errors path="numberOfPages" />
				</div>
				<input type="submit" value="Add Book" class="btn btn-sm btn-secondary mt-3" />
			</form:form>
			<button class="btn btn-sm btn-secondary" onclick="goHome()">Cancel</button>
		</div>
	</div>
</body>
</html>