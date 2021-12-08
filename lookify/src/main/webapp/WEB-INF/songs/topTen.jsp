<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Search</title>
</head>
<body>
	<div>
		<p>Top Ten Songs</p>
		<a href="/dashboard">Dashboard</a>
	</div>
	<div>
		<ul>
			<c:forEach var="song" items="${songs}">
				<!-- Add css to remove the bullet point -->
				<li>${song.rating} - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> - ${song.artist}</li>
			</c:forEach>
		</ul>
	</div>
</body>