<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Fruity Loops</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body class="flexbox">
	<div class="header">
		<h1 class="title">Fruit Store</h1>
	</div>
    <table class="table">
    	<tr>
    		<th>Name</th>
    		<th>Price</th>
    	</tr>
    	<!-- Uses c:forEach on every item in the fruits ArrayList -->
    	<c:forEach var="fruit" items="${fruits}">
 		<tr>
 			<!-- fruit.name and fruit.price come from the constructor in Item.java -->
 			<td class="body"><c:out value="${fruit.name}"/></td>
 			<td class="body">$ <c:out value="${fruit.price}"/></td>
  		</tr>
 		</c:forEach>
    </table>
</body>
</head>