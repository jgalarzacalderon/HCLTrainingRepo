<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<h2>Please Sign In</h2>

<form action="login" method="post">
  <label for="name">Username: </label><br>
  <input type="text" id="name" name="name" required><br>
  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password" max="32" required><br><br>
  <input type="submit" value="Login">
</form><br>
<a href="registration.jsp">Don't have an account? Register Here</a><br>
</body>
</html>