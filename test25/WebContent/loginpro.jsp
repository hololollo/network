<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
<% 
String userId = "user1";
String userName = "강범준";
%>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	if(id.equals(userId) && name.equals(userName)) {
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		response.sendRedirect("login.jsp");
	}
%>	


</body>
</html>