<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<style>
<%@include file="/WEB-INF/css/main.css"%>
</style>
</head>
<body>
<div class="container">
	
	<div class="header">
		<h1>Phase 3 Project 3</h1>
	</div>
	
	<div class="form">	
		<form action="login" method="post">
			<div><label> User Name : <input type="text" name="name" id="name"/> </label></div>
			<div><label> Password: <input type="password" name="password" id="password"/> </label></div>
			<div><input type="submit" value="Sign In"/></div>
		</form>
	</div>
	
	<div class="botnav">
		<a href="/">Home Page</a>
	</div>
</div>
</body>
</html>