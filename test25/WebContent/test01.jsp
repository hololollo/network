<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@  %>  : 디렉티브(Directive) = 현재 페이지에 필요한 설정이나 리소스 로딩 --%>

<%-- <%@ page ….. %> : 페이지 디렉티브(필수) --%>

<%-- <%@ page import=”java.util.ArrayList”%> : 임포트  --%>

<%-- 각주  : 해당 코드에 대한 설명부 --%>

<%--<%! %>선언문 (Declare) ★ 한번밖엔 쓰지 못함.(거의 쓸 일 없음.)  = 익명의 클래스로서 현재 문서에서만 유효 --%>
<%--<%  %> : 자바 명령문(Scriptlet) ★ 가장 많이 사용  = 해당 페이지에 자바 언어로 프로그래밍한 코드 부 --%>
<%-- <%= %> : 표현식(Expression)  단순출력시 사용. = 해당 결과를 출력 또는 표현시 사용 --%>

<%!
	private String name;
	public String getName() {
		return this.name;
}
	public void setName(String name) {
		this.name = name;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String title="메인 페이지";
%>
<title><%= title %></title>
</head>
<body>
<% 
	setName("강범준");
%>
<h2><%= getName() %>의 홈페이지</h2>
</body>
</html>