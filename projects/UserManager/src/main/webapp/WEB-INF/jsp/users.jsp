<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List Page</title>

<style>
<%@include file="/WEB-INF/css/main.css"%>
</style>

</head>

<body>

<div class="form">
	<form action="/users" method="get">
		
		<p>Print all users in the database</p><input type="submit" value="Submit" class="center">
	
	</form>
</div><br>

<table style="width:800px" class="center">
	<caption>Users Table</caption>
	<tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
    <c:forEach items="${users}" var="user" varStatus="count">
	    <tr id="${count.index}">
	    	<td>${user.id}</td>
	        <td>${user.name}</td>
	        <td>${user.email}</td>
	        <td>${user.password}</td>
	    </tr>
    </c:forEach>
</table><br>


</body>
</html>