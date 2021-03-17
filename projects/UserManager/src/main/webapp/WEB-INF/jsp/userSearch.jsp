<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Search Page</title>

<style>
<%@include file="/WEB-INF/css/main.css"%>
</style>

</head>

<body>

<div class="header">
	<h1>Phase 3 Project 1</h1>
</div>

<div class="main-message">
	<h1>Search for User Page</h1>
	
	<p>So you want to find someone do you? Well then it is simple and I'm here to help!<br>
	Just enter the ID number of the user you wish to find below and I'll take care of the rest!</p>
</div>

<div class="form">
	<form action="/user" method="post">
		
		<label for="id">User ID#:</label>
		<input type="number" id="id" name="id" required>
		<input type="submit" value="Submit">
	
	</form>
</div><br>

<table style="width:800px" class="center">
	<caption>User Information</caption>
	<tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
	<c:forEach items="${user}" var="user" varStatus="count">
		<tr id="${count.index}">
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.email}</td>
			<td>${user.password}</td>
		</tr>
	</c:forEach>
</table><br>

<div class="botnav">
	<a href="/">Home Page</a>
	<a href="editUser">Update a user</a>
</div>

</body>
</html>