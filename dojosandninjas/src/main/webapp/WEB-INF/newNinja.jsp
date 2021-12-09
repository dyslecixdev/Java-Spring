<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">		  
		<p>
			<form:label path="dojo">
				Dojo: 
				<!-- Creates a drop-down menu -->
				<form:select path="dojo">
					<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}" path="dojo">
						<c:out value="${dojo.name}"/>
					</form:option>
					</c:forEach>
				</form:select>
			</form:label>
		</p>
		<p>
			<form:label path="firstName">
				First Name: 
				<form:input path="firstName"/>
			</form:label>
			<form:errors path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">
				Last Name: 
				<form:input path="lastName"/>
			</form:label>
			<form:errors path="lastName"/>
		</p>
		<p>
			<form:label path="age">
				Age: 
				<form:input type="number" path="age"/>
			</form:label>
			<form:errors path="age"/>
		</p>
		<input type="submit" value="Create">
	</form:form>
</body>