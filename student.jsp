<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table cellspacing="20">
<h1>ENTER DETAILS HERE:</h1>
<form action="insert" method="post">
<tr>
<td> SNO:</td>
<td><input type="text" name="sno"> </td>
</tr>

<tr>
<td>SNAME:</td>
<td><input type="text" name="sname"></td>
</tr>
<tr>
<td>SUBJECT:</td>
<td><input type="text" name="sub"> </td> 
</tr>

<tr>
<td></td>
<td><input type="submit" value="INSERT"></td>
</tr>
</form>
</table>
</center>
</body>
</html>