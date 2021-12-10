<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login & Registration</title>
<!-- Imports bootstrap, but do not forget to add the dependencies in pom.xml -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<!-- Register form -->
    <form:form action="/register" method="post" modelAttribute="newUser">
        <div class="form-group">
            <label>User Name:</label>
            <form:input path="userName" class="form-control" />
            <form:errors path="userName" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Confirm Password:</label>
            <form:password path="confirm" class="form-control" />
            <form:errors path="confirm" class="text-danger" />
        </div>
        <!--div class="form-group">
            <label>Your favorite language:</label>
            <form:select path="language" class="form-control">
            	<form:option value="-" label="--Please Select--"/>
            	<form:option value="HTML"/>
            	<form:option value="CSS"/>
            	<form:option value="JavaScript"/>
            	<form:option value="Python"/>
            	<form:option value="SQL"/>
            	<form:option value="NoSQL"/>
            	<form:option value="Java"/>
            </form:select>
            <form:errors path="language" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Gender:</label>
            Male: <form:radiobutton path="gender" value="male" class="form-control" />
            Female: <form:radiobutton path="gender" value="female" class="form-control" />
            Prefer not to say: <form:radiobutton path="gender" value="none" class="form-control" />
            <form:errors path="gender" class="text-danger" />
        </div>
        <div class="form-group">
            <label>What do you like?</label>
            Sports/Exercise: <form:checkbox path="likes" value="sports" class="form-control" />
            Music/Singing: <form:checkbox path="likes" value="music" class="form-control" />
            Coding/Video Games: <form:checkbox path="likes" value="computer" class="form-control" />
        </div-->
        <input type="submit" value="Register" class="btn btn-primary" />
    </form:form>
    <!-- Login form -->
    <form:form action="/login" method="post" modelAttribute="newLogin">
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        <input type="submit" value="Login" class="btn btn-success" />
    </form:form>
</body>
</html>
