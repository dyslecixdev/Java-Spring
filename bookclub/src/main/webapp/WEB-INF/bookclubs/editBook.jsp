<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Edit <c:out value="${book.title}"/></title>
</head>
<body>
	<div>
		<h1>Change your Entry</h1>
		<!-- WARNING this edit page creates a new book instead of editing an existing book -->
		<form:form action="/books/${book.id}/edit" method="post" modelAttribute="book">
			<input type="hidden" name="_method" value="put">
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
		    <input type="submit" value="Submit"/>
		</form:form>   
	</div>
	<div>
		<p><a href="/dashboard">back to the shelves</a></p>
	</div>
</body>