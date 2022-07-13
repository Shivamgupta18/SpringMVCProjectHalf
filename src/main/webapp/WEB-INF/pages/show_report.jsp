<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Actor Information
		Report</h1>
	<c:choose>
		<c:when test="${!empty actorsInfo}">
			<table border="1" align="center" bgcolor="yellow">
				<tr bgcolor="green">
					<th>ActorId</th>
					<th>ActorName</th>
					<th>category</th>
					<th>mobileNo</th>
					<c:forEach var="artist" items="${actorsInfo}">
						<tr>
							<td>${artist.actorid}</td>
							<td>${artist.actorname}</td>
							<td>${artist.category}</td>
							<td>${artist.mobileNo}</td>
						</tr>
					</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">Actors Not Found</h1>
		</c:otherwise>

	</c:choose>
</body>
</html>