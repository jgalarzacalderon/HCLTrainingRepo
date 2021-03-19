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
		<h1>Phase 3 Project 2</h1>
	</div>
	
	<div class="main-message">
		<h1>Update User Page</h1>
		
		<p>Welcome to the Phase 3 project number 2 for the HCL Rise Academy course.<br><br>
		
		   This project implements a simple REST API to take user data entered in a<br>
		   web page and pass it to our database's table named feedback. It passes the<br>
		   information as JSON and this can be validated through the use of the application<br>
		   Postman or through curl commands in the terminal or command line tool for Windows.<br><br>
		   
		   When you're ready click on the Test Form Page link below to be directed to the form<br>
		   and enter your data to test the application.</p> 
	</div>
	
	<div class="botnav">
		<a href="testform">Test Form Page</a>
	</div>
</div>
</body>
</html>