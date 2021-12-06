<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Current visit count</title>
</head>
<body>
	<!-- countToShow comes from CounterController.java -->
    <h1>You have visited http://localhost:8080 <c:out value="${countToShow}"/> time(s).</h1>
    <!-- Various links that redirect to @RequestMapping routes -->
    <h1><a href="/">Test another visit?</a></h1>
    <h1><a href="/twice">Test two visits?</a></h1>
    <h1><a href="/reset">Reset the count.</a></h1>
</body>
</head>