<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Add the below tag to render this page on a PUT request -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Edit Expense</title>
</head>
<body>
    	<h2>Edit Expense</h2>
    	<!-- Link to go back to index.jsp -->
    	<p><a href="/expenses">Go Back</a></p>
    	<!-- Grabs expense.id from the expense we passed into the model in ExpenseService.java -->
    	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
	    	<!-- Hidden input changes it from a POST to a PUT request -->
	    	<input type="hidden" name="_method" value="put">
	    	<p>
		    	<form:label path="name">Expense Name: </form:label>
		    	<form:input path="name"/>
		    	<form:errors path="name"/>
	    	</p>
	    	<p>
		    	<form:label path="vendor">Vendor: </form:label>
		    	<form:input path="vendor"/>
		    	<form:errors path="vendor"/>
	    	</p>
	    	<p>
		    	<form:label path="amount">Amount: </form:label>
		    	<form:input type="number" path="amount" step="any"/>
		    	<form:errors path="amount"/>
	    	</p>
	    	<p>
		    	<form:label path="description">Description: </form:label>
		    	<form:textarea path="description"/>
		    	<form:errors path="description"/>
		    </p>
	    	<input type="submit" value="Submit">
    	</form:form>
</body>