<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
</head>
<body>
	<div>
		<h1>Book Club</h1>
		<p>A place for friends to share thoughts on books</p>
	</div>
	<div>
		<div>
			<h2>Register</h2>
		    <form:form action="/register" method="post" modelAttribute="newUser">
		        <div>
		            <label>User Name:</label>
		            <form:input path="userName"/>
		            <form:errors path="userName"/>
		        </div>
		        <div>
		            <label>Email:</label>
		            <form:input path="email"/>
		            <form:errors path="email"/>
		        </div>
		        <div>
		            <label>Password:</label>
		            <form:password path="password"/>
		            <form:errors path="password"/>
		        </div>
		        <div>
		            <label>Confirm Password:</label>
		            <form:password path="confirm"/>
		            <form:errors path="confirm"/>
		        </div>
		        <input type="submit" value="Register"/>
		    </form:form>
	    </div>
	    <div>
	    	<h2>Login</h2>
		    <form:form action="/login" method="post" modelAttribute="newLogin">
		        <div>
		            <label>Email:</label>
		            <form:input path="email"/>
		            <form:errors path="email"/>
		        </div>
		        <div>
		            <label>Password:</label>
		            <form:password path="password"/>
		            <form:errors path="password"/>
		        </div>
		        <input type="submit" value="Login"/>
		    </form:form>
		</div>
    </div>
</body>
</html>