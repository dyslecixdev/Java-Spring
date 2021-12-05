<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>First JSP</title>
</head>
<body>
	<!-- The keys in the controller file (src/main/java/com.christiandemesa.hoppersreceipt/Assignment.java) match the below ${words}-->
    <h1>Customer Name: <c:out value="${name}"/></h1>
    <h3>Item name: <c:out value="${item}"/></h3>
	<h3>Price: $<c:out value="${price}"/></h3>
	<h3>Metal Strips: <c:out value="${description}"/></h3>
	<h3>Vendor: <c:out value="${store}"/></h3>
</body>
</head>