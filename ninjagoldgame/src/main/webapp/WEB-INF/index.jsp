<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Ninja Gold Game</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body class="box">
	<div class="header">
		<h1>Your Gold: <span><c:out value="${gold}"/></span></h1>
    	<h1><a href="/reset">Reset</a></h1>
	</div>
    <div class="body">
    	<form action="/gold" class="place">
    		<h1>Farm</h1>
    		<h3>(earns 10-20 gold)</h3>
    		<!-- Used input type="hidden" to pass a value (e.g. "farm") to compare to name (e.g. "place") in NinjaGoldGameController.java -->
    		<input type="hidden" name="place" value="farm"/>
    		<h2><input type="submit" value="Find Gold!"></h2>
    	</form>
    	<form action="/gold" class="place">
    		<h1>Cave</h1>
    		<h3>(earns 5-10 gold)</h3>
    		<input type="hidden" name="place" value="cave"/>
    		<h2><input type="submit" value="Find Gold!"></h2>
    	</form>
    	<form action="/gold" class="place">
    		<h1>House</h1>
    		<h3>(earns 2-5 gold)</h3>
    		<input type="hidden" name="place" value="house"/>
    		<h2><input type="submit" value="Find Gold!"></h2>
    	</form>
    	<form action="/gold" class="place">
    		<h1>Casino</h1>
    		<h3>(earns/takes 0-50 gold)</h3>
    		<input type="hidden" name="place" value="casino"/>
    		<h2><input type="submit" value="Find Gold!"></h2>
    	</form>
    	<form action="/gold" class="place">
    		<h1>Spa</h1>
    		<h3>(takes 5-20 gold)</h3>
    		<input type="hidden" name="place" value="spa"/>
    		<h2><input type="submit" value="Find Gold!"></h2>
    	</form>
    </div>
    <div class="activities"><h1>Your Activities:</h1></div>
    <div class="text">
    	<!-- Uses c:forEach to get every message in the activities ArrayList -->
    	<c:forEach var="activity" items="${activities}">
    		<p><c:out value="${activity}"/></p>
    	</c:forEach>
    </div>
</body>