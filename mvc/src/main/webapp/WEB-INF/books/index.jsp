<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Reading Books</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<h1>All Books</h1>
	<table>
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Title</th>
	            <th>Language</th>
	            <th>Number of Pages</th>
	        </tr>
	    </thead>
	    <tbody>
	         <c:forEach var="book" items="${books}">
	         <tr>
	         	<td><c:out value="${book.id}"/></td>
	         	<!-- Title is a hyperlink that goes to the @GetMapping("/books/{bookId}") route -->
	         	<td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
	         	<td><c:out value="${book.language}"/></td>
	         	<td><c:out value="${book.numberOfPages}"/></td>
	         </tr>
	         </c:forEach>
	    </tbody>
	</table>
</body>