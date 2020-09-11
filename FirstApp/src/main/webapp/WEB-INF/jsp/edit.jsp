<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Product</h1>
<form:form method="POST" action="/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="userId" /></td>  
         </tr>   
         <tr>    
          <td>Fname : </td>   
          <td><form:input path="name.fName"  /></td>  
         </tr>
         <tr>    
          <td>Mname : </td>   
          <td><form:input path="name.mName"  /></td>  
         </tr>
         <tr>    
          <td>Lname : </td>   
          <td><form:input path="name.lName"  /></td>  
         </tr>           
         <tr>    
          <td>AccessDetails :</td>    
          <td><form:input path="accessDetails" /></td>  
         </tr>   
         <tr>    
          <td>AccountStatus :</td>    
          <td><form:input path="accountStatus" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    


</body>
</html>