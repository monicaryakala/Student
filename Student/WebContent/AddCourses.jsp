<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form  action="CoursesServlet" method="Post" enctype="multipart/form-data">
<div align = "center">
<table>
<tr>
<td>Course ID</td>
<td><input type= "text" name="courseid" placeholder="courseid"></td>
</tr>
<tr>
<td>Course Name</td>
<td><input type= "text" name="coursename" placeholder="coursename"></td>
</tr>
<tr> 
<td>Course Description</td>
<td><textarea name="coursecontent id="coursecontent">

</textarea></td>
</tr>
<tr>
<td>Upload Course Material:</td>
			<td><input type="file" name="material" enctype="multipart/form-data"></td>
			<td>Name the Material</td>
			<td><input type="text" name="materialname"></td>
</tr>
<tr>
<td><input type= "submit" value="Add Course"></td>


</tr>
</table>
</div>
</form>
</body>
</html>