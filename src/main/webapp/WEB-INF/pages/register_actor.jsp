<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: Blue; text-align: center">Actor Registration
		form Page</h1>
	<frm:form action="actor_add" modelAttribute="actor" method="POST">
		<table bgcolor="cyan" align="center">
			<tr>
				<td>Actor Name</td>
				<td><frm:input path="actorname" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><frm:input path="category" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><frm:input path="mobileNo" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="register"></td>
			</tr>
		</table>
	</frm:form>
</body>
</html>