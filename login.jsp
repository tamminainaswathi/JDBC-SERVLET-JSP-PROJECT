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

<h1>LOGIN PAGE:</h1>
<form action="validate" method="post" >
<table cellspacing="20">
	<tr>
            <td>EMAIL:</td>
            <td><input type="email" id="email" name="email"></td>
    </tr>

    <tr>
            <td>PASSWORD:</td>
            <td><input type="password" id="pass" name="pass"></td>
    </tr>

	
	<tr>
	<td>  </td>
            <td><input type="submit" value="LOGIN"></td>
    </tr>
	
	
	
</table>
</form>
</center>

</body>
</html>