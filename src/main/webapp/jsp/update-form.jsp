<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/updateForum" method="post">
		<input type="hidden" name="id" value="${Forum.id}">
		Author:<input type="text" name="author" value="${Forum.author}" readonly ><br>
		Detail:<input type="text" name="detail" value="${Forum.detail}"><br>
		Love : <input type="text" name="love" value="${Forum.love}"><br>
	
		<input type="submit" value="แก้ไข">
	</form>
</body>
</html>