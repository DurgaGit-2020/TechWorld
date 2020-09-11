<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Filtered AdminUser Details</title>
</head>
<body>
<h1>Users List</h1>  

<br/>
<table border="1" cellpadding="10">
		<thead>
			<tr>
				<th>UserId</th>
				<th>Fname</th>
				<th>Mname</th>
				<th>Lname</th>
				<th>AccessDetails</th>			
				<th>AccountStatus</th>	
				<th>Edit</th>	
				<th>Delete</th>			
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${listProducts}" var="adminUser">  
		<tr>
			<td>${adminUser.userId}</td>
			<td>${adminUser.name.fName}</td>
			<td>${adminUser.name.mName}</td>  
			<td>${adminUser.name.lName}</td>  
			<td>${adminUser.accessDetails}</td>
			<td>${adminUser.accountStatus}</td> 
			<td><a href="editemp/${adminuser.userId}">Edit</a></td>  
			<td><a href="deleteemp/${adminuser.userId}">Delete</a></td> 
		</tr>
		</c:forEach> 
		</tbody>
	</table>
	<br/>
	<td><a href="/AdminUserJsp">Go to Admin Home Page</a>
</body>  
</html>  
