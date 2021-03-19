<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Feedback</title>

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
		<h1>Test form to add feedback</h1>
		
		<p>Enter a username, the comment for the user, and a rating below in the form. Then hit<br>
		   the submit button when finished to POST the data to the feedback table in the db_example database<br><br>
		   
		   Once the data is posted to the feedback table in the database you can verify the status by running<br>
		   the curl command or following the Postman instructions entered into this projectss write up.</p>
	</div>
	
	<div class="form">
		<h3>Form to submit a new entry to the feedback table in the db_example database</h3>
		<form action="feedback" method="post">
			
			<label for="user">Username:</label>
			<input type="text" id="user" name="user" required><br>
			<label for="comments">Comments:</label>
			<input type="text" id="comments" name="comments" required><br>
			<label for="rating">Rating:</label>
			<input type="number" id="rating" name="rating" required><br>
			<input type="submit" value="Submit">
		
		</form>
	</div><br>
	
	<div class="botnav">
		<a href="/">Home Page</a>
	</div>
</div>
</body>
</html>