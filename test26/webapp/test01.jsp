<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String title = "표현식과 표현언어";
	String[] jongwoo = {"까다로움", "꾸준함", "개웃김", "착함"};
	Map<String, String> cho = new HashMap<>();
	cho.put("name", "조대신");
	cho.put("age", "69");
	cho.put("nick", "조교주");
	
	request.setAttribute("tt", title);
	request.setAttribute("jg", jongwoo); // 일반 문자열부터 객체까지
	request.setAttribute("ch", cho);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(Expression Language{EL})</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>표현식(Expression)</h2>
<p><%=title %> : <%=request.getAttribute("tt") %></p>
<div>
<%
	String[] jwo = (String[]) request.getAttribute("jg");
	for(int i = 0; i < jwo.length; i++) {
%>
	<span><%=jwo[i] %></span>
<%
	}
%>
<div><br>
</div>
<%
	Map<String, String> cht = new HashMap<String, String>();
	cht = (HashMap<String, String>) request.getAttribute("ch");
	Collection<String> val = cht.values(); // 분리
	for(String v : val) {
%>
	<span><%=v %></span>
<%
	}
%>
</div>
<br>
<h2>표현 언어(Expression Language)</h2>
<h3>JSTL을 사용하면 Java 코드를 직접 JSP 페이지에 넣는 것을 피하고, 보다 간결하고 유지보수가 쉬운 코드를 작성할 수 있습니다. </h3>
<p>${tt }</p>	
<div>
<c:forEach var="st" items="${jg }">
	<span>${st}</span>
</c:forEach>
</div><br>
<div>
<c:forEach var="mp" items="${ch }">
	<span>${mp.key }</span>:<span>${mp.value }</span>
</c:forEach>
</div>
</body>
</html>