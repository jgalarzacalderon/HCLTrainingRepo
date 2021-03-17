<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>

<style>
<%@include file="/WEB-INF/css/main.css"%>
</style>

</head>

<body>

<div class="header">
	<h1>Phase 3 Project 1</h1>
</div>

<div class="main-message">
	<h1>Update User Page</h1>
	
	<p>Okay, its time to do some redecorating around here! I'll help you update a user's information.<br><br>
	Just type the user ID# into the first form field. Then enter the information you want to update <br>
	for that particular user in the Username, Email, and Password fields. <br><br>
	Once you hit "Submit" I'll get right to work!</p>
</div>

<div class="form">
	<h3>Update a user by ID#</h3>
	<form action="update" method="post">
		
		<label for="id">User ID#:</label>
		<input type="number" id="id" name="id" required>
		<label for="name">Username:</label>
		<input type="text" id="name" name="name" required>
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" required>
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required>
		<input type="submit" value="Submit">
	
	</form>
</div><br>

<div class="botnav">
	<a href="/">Home Page</a>
	<a href="userSearch">Search for a User</a>
</div>

</body>
</html>