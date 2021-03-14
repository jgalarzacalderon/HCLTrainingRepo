<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>

<h2>Registration Page</h2>
<form action="register" method="post">
  <label for="name">Username: </label><br>
  <input type="text" id="name" name="name" required><br>
  <label for="email">Email</label><br>
  <input type="email" id="email" name="email" required><br>
  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password" minlength="8" maxlength="32" required><br><br>
  <input type="submit" value="Submit">
</form>



</body>
</html>