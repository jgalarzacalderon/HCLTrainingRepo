<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>

<style>
<%@include file="/WEB-INF/css/main.css"%>
</style>

</head>

<body>
<div class="header">
	<h1>Phase 3 Project 1</h1>
</div>

<div class="main-message">
	<h1>Home Page</h1>
	
	<p>Welcome to the main page of SimpliLearn Phase 3 Project 1 by John Galarza-Calderon</p>
	<p>This project utilizes Spring MVC with Hibernate, log4j, and MySQL Connector to allow<br>
	you to search a database (db_example.user) for a specific user. If a user is found you<br>
	will be given the option to update that user by entering new updated information for that<br>
	user or return to the main page. Please enjoy your time here, and have a great day.</p>
</div>

<div class="botnav">
	<a href="userSearch">Search for a User</a>
	<a href="editUser">Update a user</a>
</div>


</body>
</html>