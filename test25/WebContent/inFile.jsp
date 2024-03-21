<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String) pageContext.getAttribute("name"); // 값을 불러와서 name에 넣어준다.
	String age = (String) pageContext.getAttribute("age"); // 값을 불러와서 age에 넣어준다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>포함 되는 파일</h2>
	<div>
		<p>Name : <%=name %></p>
		<p>Age : <%=age %></p>		
	</div>
</body>
</html>