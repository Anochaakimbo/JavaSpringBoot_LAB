<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Show All</h1>
	<table border=1>
	<th>ID</th>
	<th>Name</th>
	<th>Type</th>
	<c:forEach items = "${allMovies}" var ="m">
	<tr>
	<td>${m.movieID}</td>
	<td>>${m.movieName}</td>
	<td>>${m.movieType}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>