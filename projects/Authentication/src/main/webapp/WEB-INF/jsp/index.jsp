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
<div class="container">
	<div class="header">
		<h1>Phase 3 Project 3</h1>
	</div>
	
	<div class="main-message">
		<h1>Update User Page</h1>
		
		<p>Welcome to the Phase 3 project number 3. This project is meant<br>
		   to perform JUNIT testing on the methods utilized to make this <br>
		   simple web app run. The app doesn't do much besides implement a <br>
		   basic user login page. If you follow the link below "Login Page" <br>
		   it will take you to a web form asking you to type in a username <br>
		   and password to login. It will validate the credentials and if <br>
		   valid will direct you to the confirmation page verifying valid <br>
		   credentials. If invalid it will direct you to an error page <br>
		   directing you to go back to the "Home Page" or the "Login Page". </p> 
		   
		<p>As said the primary purpose of the project was just to write <br>
		   JUNIT test utilizing spring-boot framework with a maven project. <br>
		   Refer to the project write up submitted with this project for<br>
		   more information. This project requires you follow the steps in <br>
		   the write up to ensure you have the proper database and table <br>
		   created in your mysql service in order for the application to query <br>
		   for valid user credentials.</p>
	
	</div>
	
	<div class="botnav">
		<a href="/login">Login Page</a>	
	</div>
</div>
</body>
</html>