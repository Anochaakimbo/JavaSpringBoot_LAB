<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello ${name }</h1>
	<h2>Your age is ${age}</h2>
	<h2>Student ID: <c:out> value="${stuid}" default="Unknown Student ID"</c:out></h2>
</body>
</html>