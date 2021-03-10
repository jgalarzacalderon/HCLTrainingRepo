<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Pet</title>
</head>
<body>


<form action="pets" method="post">
  <label for="name">Name: (Please enter only letters)</label><br>
  <input type="text" id="name" name="name" pattern="[a-zA-Z ]+" required><br>
  <label for="color">Color:(Please enter only letters)</label><br>
  <input type="text" id="color" name="color" pattern="^[a-zA-Z]+$" required><br>
  <label for="price">Price: (max value is 50,000)</label><br>
  <input type="number" id="price" name="price" max="50000" required><br><br>
  <input type="submit" value="Submit">
</form>



</body>
</html>