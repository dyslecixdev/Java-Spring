<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Edit <c:out value="${language.name}"/></title>
</head>
<body>
	<div>
		<form action="/languages/${language.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
		<p><a href="/languages">Dashboard</a></p>
	</div>
    <div>
    	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
	    	<input type="hidden" name="_method" value="put">
	    	<p>
		    	<form:label path="name">Name </form:label>
		    	<form:input path="name"/>
		    	<form:errors path="name"/>
	    	</p>
	    	<p>
		    	<form:label path="creator">Creator </form:label>
		    	<form:input path="creator"/>
		    	<form:errors path="creator"/>
	    	</p>
	    	<p>
		    	<form:label path="version">Version </form:label>
		    	<form:input type="number" path="version" step="any"/>
		    	<form:errors path="version"/>
	    	</p>
	    	<input type="submit" value="Submit">
    	</form:form>
    </div>
</body>