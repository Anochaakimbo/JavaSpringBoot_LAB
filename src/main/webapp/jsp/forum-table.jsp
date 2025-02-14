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
<table border="1">
<th>ID</th>
<th>Author</th>
<th>details</th>
<th>Love</th>
<th>Date</th>
<c:forEach items="${allForums}" var="m">
<tr>
<td>${m.id}</td>
<td>${m.author}</td>
<td>${m.detail}</td>
<td>${m.love}</td>
<td>${m.post_date}</td>
 <td>
            <a href="/updateForm/${m.id}">แก้ไข</a>
            <a href="/deleteForum/${m.id}">ลบ</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>