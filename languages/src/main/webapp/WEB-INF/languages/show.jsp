<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <!-- Put the name of the language in the title -->
    <title><c:out value="${language.name}"/></title>
</head>
<body>
    	<p><a href="/languages">Dashboard</a></p>
    	<p><c:out value="${language.name}"/></p>
    	<p><c:out value="${language.creator}"/></p>
    	<p><c:out value="${language.version}"/></p>
    	<p><a href="/languages/edit/${language.id}">Edit</a></p>
    	<form action="/languages/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
</body>