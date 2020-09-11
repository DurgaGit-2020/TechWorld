<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title><spring:eval expression="@environment.getProperty('app.name')" />&nbsp;${var2}</title>
</head>
<body>	 	

    <h2><spring:eval expression="@environment.getProperty('app.name')" />&nbsp;${var2}</h2>	
    
	<form action="/viewHomePage">
		<input type="text" name="keyword" id="keyword" size="50" placeholder="Enter text to search..." th:value="${keyword}" />
		
	<select name="AccountStatus" id="AccountStatus" th:value="${keyword1}">
		<option value="-1"><spring:eval expression="@environment.getProperty('category.name')" />&nbsp;${category}</option>
		<option value="Completed"><spring:eval expression="@environment.getProperty('completed.name')" />&nbsp;${completed}</option>
		<option value="Active"><spring:eval expression="@environment.getProperty('active.name')" />&nbsp;${active}</option>
		<option value="Pending"><spring:eval expression="@environment.getProperty('pending.name')" />&nbsp;${pending}</option>
		<option value="Locked"><spring:eval expression="@environment.getProperty('locked.name')" />&nbsp;${locked}</option>
	</select>
	
	<button><spring:eval expression="@environment.getProperty('button.search')" />&nbsp;${search}</button>
	</form>
	<br/>
	
	<form action="/ClearData" >
	<button><spring:eval expression="@environment.getProperty('showall.name')" />&nbsp;${showall}</button>
	</form>
	<br/>
	
	<div>
	<table border="1" cellpadding="1" cellspacing="1" width="80%">
		<tr>
			<th><font color="#0000FF"><spring:eval expression="@environment.getProperty('userid.name')" />&nbsp;${userid}</font></th>
			<th><font color="#0000FF"><spring:eval expression="@environment.getProperty('fname.name')" />&nbsp;${fname}</font></th>
			<th><font color="#0000FF"><spring:eval expression="@environment.getProperty('mname.name')" />&nbsp;${mname}</font></th>
			<th><font color="#0000FF"><spring:eval expression="@environment.getProperty('lname.name')" />&nbsp;${lname}</font></th>
			<th><font color="#0000FF"><spring:eval expression="@environment.getProperty('accessdetails.name')" />&nbsp;${accessdetails}</font></th>
			<th><font color="#0000FF"><spring:eval expression="@environment.getProperty('accountstatus.name')" />&nbsp;${accountstatus}</font></th>
			<th><font color="#0000FF"><spring:eval expression="@environment.getProperty('edit.name')" />&nbsp;${edit}</font></th>
			<th><font color="#0000FF"><spring:eval expression="@environment.getProperty('delete.name')" />&nbsp;${delete}</font></th>
		</tr>
		<% if(request.getAttribute("adminuser") != null) { %>
         <c:forEach var="adminuser" items="${adminuser }">
			<tr>
				<td><font color="#000000">${adminuser.userId}</font></td>
				<td><font color="#000000">${adminuser.name.fName}</font></td>
				<td><font color="#000000">${adminuser.name.mName}</font></td>
				<td><font color="#000000">${adminuser.name.lName}</font></td>
				<td><font color="#000000">${adminuser.accessDetails}</font></td>
				<td><font color="#000000">${adminuser.accountStatus}</font></td>
				<td><a href="editemp/${adminuser.userId}">Edit</a></td>  
                <td><a href="deleteemp/${adminuser.userId}">Delete</a></td> 
			</tr>
		</c:forEach>	
      <% } else { %>
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
      <% } %>	
	</table>
	</div>
</body>
</html>