<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Admin_User</title>
</head>
<body>
	<h1>ADMIN USER</h1>
	<table border="1" cellpadding="1" cellspacing="1" width="80%">
		<tr>
			<th><font color="#0000FF">UserId</font></th>
			<th><font color="#0000FF">Fname</font></th>
			<th><font color="#0000FF">Mname</font></th>
			<th><font color="#0000FF">Lname</font></th>
			<th><font color="#0000FF">AccessDetails</font></th>
			<th><font color="#0000FF">AccountStatus</font></th>
		</tr>	
		<c:forEach var="adminuser" items="${adminuser }">
			<tr>
				<td><font color="#000000">${adminuser.userId}</font></td>
				<td><font color="#000000">${adminuser.name.fName}</font></td>
				<td><font color="#000000">${adminuser.name.mName}</font></td>
				<td><font color="#000000">${adminuser.name.lName}</font></td>
				<td><font color="#000000">${adminuser.accessDetails}</font></td>
				<td><font color="#000000">${adminuser.accountStatus}</font></td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>