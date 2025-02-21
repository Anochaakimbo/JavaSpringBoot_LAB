<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* กำหนด border ให้กับทุกๆ element ที่ต้องการ */
body {
	font-family: Arial, sans-serif;
}

h1 {
	border-bottom: 2px solid #000;
	padding-bottom: 10px;
}

p {
	border: 1px solid #ccc;
	padding: 10px;
	margin-bottom: 10px;
}

a {
	text-decoration: none;
	color: blue;
	border: 1px solid #007BFF;
	padding: 5px;
	border-radius: 5px;
	margin-top: 5px;
}

a:hover {
	background-color: #f0f0f0;
}

form {
	border: 2px solid #000;
	padding: 20px;
	margin-top: 20px;
	width: 300px;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #007BFF;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1>What do you think?</h1>
	<c:forEach items="${allForums}" var="m">
		<p>${m.detail}
		<p>

			<a href="/loveAdd/${m.id}">Love</a> ${m.love} ผู้เขียน : ${m.author}
			${m.post_date}
	</c:forEach>
	<br>
	<form action="/insertForum" method="GET">
		<input type="text" id="detail" name="detail"
			placeholder="What on your mind"><br> <input type="text"
			id="author" name="author" placeholder="Writer"><br> <input
			type="submit" value="Submit">
	</form>
</body>
</html>
