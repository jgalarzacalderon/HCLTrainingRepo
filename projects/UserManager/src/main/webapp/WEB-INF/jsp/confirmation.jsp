<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Confirmation page</title>

<style>
<%@include file="/WEB-INF/css/main.css"%>
</style>

</head>

<body>

<div class="header">
	<h1>Phase 3 Project 1</h1>
</div>

<div class="main-message">
	
	<h2>SUCCESS!</h2>
	<p>That seemed to do the trick just fine! I went ahead and updated the user you requested!<br>
	Don't believe me? Just do a search for that user and you'll see. I never tell a lie!<br><br>
	Well then, until we meet again さようなら, that's says Sayōnara, it's Japanese for goodbye!</p>
</div>

<table style="width:800px" class="center">
	<caption>Updated User Information</caption>
	<tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
	<c:forEach items="${update}" var="user" varStatus="count">
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
	<a href="userSearch">Search for a User</a>
	<a href="editUser">Update a user</a>
</div>