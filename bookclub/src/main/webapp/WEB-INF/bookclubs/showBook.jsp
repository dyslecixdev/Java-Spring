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
	<!-- Uses c:set to give a variable a value -->
	<c:set var="user" value="${user_name}"/>
	<div>
		<h2>
			<!-- Uses c:if to display "You" if the sessioned user_name (i.e. user) matches the user who created the book -->
			<c:if test="${user == book.user.userName}">You</c:if>
			<!-- Uses c:if to display the user who created the book if the sessioned user name does not match the user who created the book -->
			<c:if test="${user != book.user.userName}"><c:out value="${book.user.userName}" default="Anonymous"/></c:if>
			 read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.
		</h2>
		<h2>Here are <c:out value="${book.user.userName}" default="anonymous"/>'s thoughts:</h2>
		<div>
			<c:out value="${book.thought}"/>
		</div>
		<div>
			<!-- This edit link will appear if the sessioned user_name matches the user who created the book -->
			<p><c:if test="${user == book.user.userName}"><a href="/books/${book.id}/edit">edit</a></c:if></p>
		</div>
	</div>
</body>