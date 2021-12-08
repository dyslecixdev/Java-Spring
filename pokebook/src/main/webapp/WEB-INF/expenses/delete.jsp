<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Show Expense</title>
</head>
<body>
    	<h2>Expense Details</h2>
    	<!-- Link to go back to index.jsp -->
    	<p><a href="/expenses">Go Back</a></p>
    	<p>Expense Name: <c:out value="${expense.name}"/></p>
    	<p>Expense Description: <c:out value="${expense.description}"/></p>
    	<p>Vendor: <c:out value="${expense.vendor}"/></p>
    	<p>Amount spent: <fmt:formatNumber value="${expense.amount}" type="currency"/></p>
    	<form action="/expenses/${expense.id}" method="post">
    		<!-- Hidden input changes it from a DELETE to a PUT request -->
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
</body>