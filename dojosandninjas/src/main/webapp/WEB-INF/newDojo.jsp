<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/new" method="post" modelAttribute="dojo">		  
		<p>
			<form:label path="name">
				Name: 
				<form:input path="name"/>
			</form:label>
			<form:errors path="name"/>
		</p>
		<input type="submit" value="Create">
	</form:form>
</body>