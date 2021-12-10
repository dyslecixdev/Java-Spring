<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title><c:out value="${book.title}"/></title>
</head>
<body>
	<div>
		<h1><c:out value="${book.title}"/></h1>
		<p><a href="/dashboard">back to the shelves</a></p>
	</div>
	<div>
		<!-- Shows the logged in user who created the book -->
		<h2><c:out value="${book.user.userName}" default="Anonymous"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h2>
		<h2>Here are <c:out value="${book.user.userName}" default="anonymous"/>'s thoughts:</h2>
		<div>
			<c:out value="${book.thought}"/>
		</div>
	</div>
    <!-- edit button -->
</body>