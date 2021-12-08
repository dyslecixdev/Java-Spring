<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Lookify!</title>
</head>
<body>
    <div>
    	<p><a href="/songs/new">Add New</a></p>
    	<p><a href="/search/topTen">Top Songs</a></p>
    	<!-- Figure out how to change the route to "/search/{song.artist}" -->
    	<form action="/search" method="post">
			<input type="text" name="artist">
			<input type="submit" value="Search Artists">
		</form>
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