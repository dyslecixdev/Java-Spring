<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Add Song</title>
</head>
<body>
	<p><a href="/dashboard">Dashboard</a></p>
    <form:form action="/songs/new" method="post" modelAttribute="song">
		<p>
			<!-- Moved the form: label closing tag to put everything in one line -->
			<form:label path="title">
				Title 
				<form:input path="title"/>
				<form:errors path="title"/>
			</form:label>
		</p>
		<p>
			<form:label path="artist">
				Artist 
				<form:input path="artist"/>
				<form:errors path="artist"/>
			</form:label>
		</p>
		<p>
			<form:label path="rating">
				Rating (1-10) 
				<form:input type="number" path="rating"/>
				<form:errors path="rating"/>
			</form:label>
		</p>
		<input type="submit" value="Add Song">
	</form:form>
</body>