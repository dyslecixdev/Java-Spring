<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>New Book</title>
</head>
<body>
	<div>
		<h1>Add a Book to Your Shelf!</h1>
		<form:form action="/books/new" method="post" modelAttribute="book">
			<p>
				<form:errors path="title"/>
				<form:errors path="author"/>
				<form:errors path="thought"/>
			</p>
		    <p>
		        <form:label path="title">
			        Title 
			        <form:input path="title"/>
		        </form:label>
		        
		    </p>
		    <p>
		        <form:label path="author">
			        Author 
			        <form:input path="author"/>
		        </form:label>
		    </p> 
		    <p>
		        <form:label path="thought">
			        My thoughts 
			        <form:textarea path="thought"/>
		        </form:label>
		    </p>
		    <!-- Adds the logged in user's id with setAttribtue from the controller ("user_id"), and makes it the value for the user member variable in the books table -->
		    <form:input type="hidden" path="user" value="${user_id}"/>
		    <input type="submit" value="Submit"/>
		</form:form>   
	</div>
	<div>
		<p><a href="/dashboard">back to the shelves</a></p>
	</div>
</body>