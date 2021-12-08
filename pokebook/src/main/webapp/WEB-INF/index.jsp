<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- You need the following two lines to use form:form, and fmt:formatNumber -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>PokeBook Expenses</title>
</head>
<body>
    <div>
    <h1>PokeBook</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Expense</th>
	            <th>Vendor</th>
	            <th>Amount</th>
	        </tr>
	    </thead>
	    <tbody>
	         <c:forEach var="exp" items="${expenses}">
	         <tr>
	         	<td><c:out value="${exp.name}"/></td>
	         	<td><c:out value="${exp.vendor}"/></td>
	         	<!-- This formats the number entered into $0.00. Note you need to include the above tag to use ftm:formatNumber -->
	         	<td><fmt:formatNumber value="${exp.amount}" type="currency"/></td>
	         </tr>
	         </c:forEach>
	    </tbody>
	</table>
    </div>
    <div>
    	<h3>Track an expense:</h3>
    	<!-- Creating the form like this gives us access to error messages -->
    	<!-- modelAttribute must match @ModelAttribute in ExpenseController.java -->
    	<form:form action="/expenses" method="post" modelAttribute="expense">
	    	<p>
	    		<!-- Similar to label -->
		    	<form:label path="name">Expense Name: </form:label>
		    	<!-- Similar to input type="text" name="name" -->
		    	<form:input path="name"/>
		    	<!-- The error message from Expense.java will show here for "name" -->
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
    </div>
</body>