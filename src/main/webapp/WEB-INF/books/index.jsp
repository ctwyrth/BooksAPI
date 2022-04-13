<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BooksAPI = Home</title>

	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto mt-5 text-center">
			<h1 class="display-4">All Books!</h1>
			<table class="table col-8">
				<thead class="table-info">
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Language</th>
						<th># Pages</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>
							<td><c:out value="${book.id}" /></td>
							<td><c:out value="${book.title}" /></td>
							<td><c:out value="${book.language}" /></td>
							<td><c:out value="${book.numberOfPages}" /></td>
							<td>
								<button class="btn btn-sm btn-primary" onclick="editBook(<c:out value="${book.id}" />)">Edit</button>
								<button class="btn btn-sm btn-success" onclick="viewBook(<c:out value="${book.id}" />)">View</button>
								<button class="btn btn-sm btn-danger" onclick="deleteBook(<c:out value="${book.id}" />)">Delete</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button class="btn btn-sm btn-secondary col-2 mt-3" onclick="addBook()">New Book</button>
		</div>
	</div>
</body>
</html>