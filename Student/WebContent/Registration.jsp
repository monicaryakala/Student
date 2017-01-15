<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>

<script>  
function validateform(){  
var name=document.myform.username.value;  
var password=document.myform.password.value;  
var email=document.myform.email.value
  
if (name==null || name==""){  
  alert("Name can't be blank");  
  return false;  
}else if(password.length<6){  
  alert("Password must be at least 6 characters long.");  
  return false;  
  }else if(email==null || email==""){
	  alert("Email can't be empty");
  }
}  
</script>  

<body>
<% String error = (String)request.getAttribute("error"); %>
<form name="myform" action="RegistratonServlet" method="Post" onsubmit="return validateform()">
<div align = "center">
<table>
<tr>
<td>UserName</td>
<td><input type= "text" name="username" placeholder="username"></td>
</tr>
<tr>
<td>E-mail</td>
<td><input type ="text" name="email" placeholder="email"></td>
</tr>
<tr>
<td>Password</td>
<td><input type = "text" name="password" placeholder="password"></td>
</tr>
<tr>
<td><input type= "submit" value="Register"></td>
</tr>
</table>
<tr>
<td>
<%if(error!=null){
	out.print(error);
}
	%>
	</td>
	</tr>
</div>
</form>
</body>
</html>