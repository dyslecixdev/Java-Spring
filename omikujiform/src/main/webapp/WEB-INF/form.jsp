<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Omikuji Form</title>
    <link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body class="box">
    <h1>Send an Omikuji!</h1>
    <!-- The submitted form will be sent to @PostMapping("/send") as a POST request -->
    <form action="/send" method="post" class="form">
    	<label>Pick any number from 5 to 25:</label>
    	<!-- input type="number" creates input box for numbers only, and min and max are the range of acceptable numbers -->
    	<input type="number" min=5 max=25 name="number">
    	<label>Enter the name of any city:</label>
    	<input type="text" name="city">
    	<label>Enter the name of any real person:</label>
    	<input type="text" name="person">
    	<label>Enter professional endeavor or hobby:</label>
    	<input type="text" name="hobby">
    	<label>Enter any type of living thing:</label>
    	<input type="text" name="thing">
    	<label>Say something nice to someone:</label>
    	<textarea name="text" rows=4 cols=30></textarea>
    	<label>Send and show a friend</label>
    	<input type="submit" value="Send" class="button">
    </form>
</body>