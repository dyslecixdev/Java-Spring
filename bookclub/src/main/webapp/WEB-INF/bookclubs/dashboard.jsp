<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Dashboard</title>
</head>
<body>
	<div>
		<div>
			<!-- Shows the logged in user's name from setAttribute in the controller -->
			<h1>Welcome, <c:out value="${user_name}"/></h1>
			<p>Books from everyone's shelves:</p>
		</div>
	    <div>
	    	<p><a href="/logout">logout</a></p>
	    	<p><a href="/books/new">+ Add to my shelf!</a></p>
	    </div>
    </div>
    <div>
    	<table>
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Title</th>
		            <th>Author Name</th>
		            <th>Posted By</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="book" items="${books}">
		         <tr>
		         	<td><c:out value="${book.id}"/></td>
		         	<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
		         	<td><c:out value="${book.author}"/></td>
		         	<!-- Shows the logged in user who created the book -->
		         	<td><c:out value="${book.user.userName}" default="Anonymous"/></td>
		         </tr>
		         </c:forEach>
		    </tbody>
		</table>
    </div>
</body>