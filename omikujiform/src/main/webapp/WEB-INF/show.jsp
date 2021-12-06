<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Omikuji Show</title>
    <link rel="stylesheet" type="text/css" href="css/show.css">
</head>
<body class="box">
    <h1>Here's Your Omikuji!</h1>
    <div class="message">
    	<!-- The values come from OmikujiFormController.java -->
    	<h2>In <c:out value="${showNumber}"/> years you will live in <c:out value="${showCity}"/> with <c:out value="${showPerson}"/> as your roommate, <c:out value="${showHobby}"/> for a living. The next time you see a <c:out value="${showThing}"/>, you will have good luck. <c:out value="${showText}"/></h2>
    </div>
    <p class="link"><a href="/omikuji">Go Back</a></p>
</body>