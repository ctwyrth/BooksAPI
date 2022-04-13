<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BooksAPI - Book Info</title>

	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mt-4">
			<h1><c:out value="${book.title}"/></h1>
			<p><strong>Description:</strong> <c:out value="${book.description}"/></p>
			<p><strong>Language:</strong> <c:out value="${book.language}"/></p>
			<p><strong>Number of Pages:</strong> <c:out value="${book.numberOfPages}"/></p>
		</div>
		<div class="col-6 mx-auto mt-3">
			<button class="btn btn-sm btn-success me-2" onclick="editBook(${book.id})">Edit</button>
			<button class="btn btn-sm btn-danger me-2" onclick="deleteBook(${book.id})">Delete</button>
			<button class="btn btn-sm btn-secondary" onclick="goHome()">Home</button>
		</div>
	</div>

</body>
</html>