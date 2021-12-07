<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Ninja Gold Prison</title>
    <link rel="stylesheet" type="text/css" href="css/prison.css">
</head>
<body>
	<div>
		<h1>Welcome to prison.</h1>
		<h1>Your Debt: <c:out value="${gold}"/></h1>
    	<h1><a href="/reset">Try Again</a></h1>
	</div>
</body>