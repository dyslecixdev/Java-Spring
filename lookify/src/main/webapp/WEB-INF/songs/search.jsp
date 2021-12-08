<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Search</title>
</head>
<body>
	<div>
		<!-- Figure out how to show the artist's name -->
		<p>Songs by artist: <c:out value="${song.artist}"/></p>
		<form action="/search" method="post">
			<input type="text" name="artist">
			<input type="submit" value="New Search">
		</form>
		<p><a href="/dashboard">Dashboard</a></p>
	</div>
	<div>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Rating</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="song" items="${songs}">
		         <tr>
		         	<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
		         	<td><c:out value="${song.rating}"/></td>
		         	<td>
			         	<form action="/songs/${song.id}" method="post">
						 	<input type="hidden" name="_method" value="delete">
							<input type="submit" value="delete">
						</form>
					</td>
		         </tr>
		         </c:forEach>
		    </tbody>
		</table>
	</div>
</body>