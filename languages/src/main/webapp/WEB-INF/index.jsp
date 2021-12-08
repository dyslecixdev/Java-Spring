<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Languages</title>
</head>
<body>
    <div>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Version</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="lang" items="${languages}">
		         <tr>
		         	<td><a href="languages/${lang.id}"><c:out value="${lang.name}"/></a></td>
		         	<td><c:out value="${lang.creator}"/></td>
		         	<td><c:out value="${lang.version}"/></td>
		         	<td>
		         		<form action="/languages/${lang.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form> | <a href="/languages/edit/${lang.id}">edit</a>
					</td>
		         </tr>
		         </c:forEach>
		    </tbody>
		</table>
    </div>
    <div>
    	<form:form action="/languages" method="post" modelAttribute="language">
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