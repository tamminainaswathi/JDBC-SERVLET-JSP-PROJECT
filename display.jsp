<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.model.student100" %>
<!DOCTYPE html>
<html>
<head>
<style>
        table {
            border-collapse: collapse; /* This property ensures that adjacent cell borders are combined into a single border */
            width: 50%;
        }

        th, td ,tr{
            border: 1px solid black; /* Set border for table cells */
            padding: 8px; /* Add padding for better appearance */
            text-align: center; /* Align text to the left in cells */
        }
       
    </style>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
crossorigin="anonymous">
<title>student data</title>
</head>
<body>
<center>
<h1>STUDENT DETAILS:</h1>
	<table border="1" width="50">
	<tr class="table-danger">
		<th>SID</th>
		<th>NAME</th>
		<th>COURSE</th>
	</tr>
	
	<% ArrayList<student100> al = (ArrayList<student100>) request.getAttribute("display"); 
	for(student100 s:al)
	{
	%>
	
	<tr class="table-danger">
	<td> <%=s.getSno() %> </td>
	<td><%=s.getSname() %></td>
	<td><%=s.getSub() %></td>
	</tr>
	
	<%
	}
	%>

	
	</table>

</center>


</body>
</html>