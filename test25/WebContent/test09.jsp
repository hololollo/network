<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스코프 데이터 추적하기</title>
</head>
<body>
<h2>스코프 데이터 추적하기</h2>
<%
	String msg = request.getParameter("msg");
	String pageData = (String) pageContext.getAttribute("pageData");	 // Attribute로 받아온 데이터는 반드시 그 데이터에 따라 형변환
	String reqData = (String) request.getAttribute("reqData");
	String sesData = (String) session.getAttribute("sesData");
	String appData = (String) application.getAttribute("appData");
%>
<div>
	<p>msg(request on) : <%=msg %> 리퀘스트로 보내온 정상적인 데이터</p> 
	<p>page(pageContext) : <%=page %><!--test08 페이지에서만 구현 가능 --></p> 
	<p>reqData(request off) : <%=reqData %> <!--set만 걸어놨기 때문에 구현 불가능.--> </p> 
	<p>sesData(session) : <%=sesData %><!--세션이 실행중(로그아웃 전까지)에서는 출력이 되어야 한다.--></p> 
	<p>appData(application) : <%=appData %> 애플리케이션이 실행중에는 반드시 출력이 되어야 한다.</p> 
<%
	session.invalidate(); // 세션 끝내기.
    // sesData = (String) session.getAttribute("sesData");
%>
	<p>세션 종료 후</p>
	<p>sesData(session) : <%=sesData %><!--세션이 종료된 상태에서는 출력이 불가능하다.--></p> 
	<p>appData(application) : <%=appData %></p>
	<p>web.xml 전역변수 : <%=application.getInitParameter("admin") %><!-- 고정값. --></p>
</div>
<hr>
<div>
	<a href="index.jsp">홈으로</a><br>
	<a href="test06.jsp">test06 페이지</a>
</div>
</body>
</html>