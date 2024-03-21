<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "강범준"); // 값을 정의 해준다.(name 이 강범준이다.)
	pageContext.setAttribute("age", "32"); // 값을 정의 해준다.(age 가 32다.)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 실습</title>
</head>
<body>
	<h2>디렉티브를 이용한 include</h2>
	<%@ include file="inFile.jsp" %>
<hr>
	<h2>액션태그(:)를 활용한 include</h2>
	<jsp:include page="inFile.jsp"></jsp:include>
</body>
</html>