<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="org.kh.dto.Member" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL(Java Standard Tag Library) CORE</title>
</head>
<body>
<%
	List<Member> mList = new ArrayList<>();
	mList.add(new Member(1, "kang", "1234", "강범준"));
	mList.add(new Member(2, "park", "1004", "박동연"));
	mList.add(new Member(3, "lee", "4321", "이연정"));
%>
<%@ include file="menu.jsp" %>
<hr>
<h2>JSTL(Java Standard Tag Library) CORE</h2>
<p>CORE : JSTL의 기본 명령</p>
<br>
<h3>01 . c:out 태그 => 출력문</h3>
<c:out value="강범준 최고" />
<hr>
<h3>02. c:set => 선언문</h3>
<c:set var="name" value="강민우" scope="session" />
<c:out value="${name }"/>
<hr>
<h3>03. c:import => 임포트문</h3>
<c:set var="path1" value="/login.jsp"/>
<%-- <c:import url="${path1] }" /> --%>
<hr>
<h3> * 04. c:if => 조건문</h3>
<c:set var="age" value="27"/>
<c:if test="${age ge 20}">
	<c:out value="성년"/>
</c:if>
<c:if test="${age lt 20}">
	<c:out value="미성년"/>
</c:if>
<hr>
<h3>05. c:choose => 선택문</h3>
<c:set var="point" value="85"/>
<c:choose>
	<c:when test="${point ge 90 }"><span>수</span></c:when>
	<c:when test="${point ge 80 }"><span>우</span></c:when>
	<c:when test="${point ge 70 }"><span>미</span></c:when>
	<c:otherwise><span>가</span></c:otherwise>
</c:choose>
<hr>
<h3>06. c:remove => 제거문</h3>
<c:remove var="age"/>
<hr>
<h3> * 07. c:forEach => 반복실행문</h3>
<c:forEach var="mem" items="${mList }" varStatus="staus">
	<ul>
		<li>연변 : ${status.count }</li>
		<li>아이디 : ${mem.id }</li>
		<li>이름 : ${mem.name }</li>
	</ul>
</c:forEach>
<hr>
<h3>08. c:forTokens => 토큰이 있는 반복실행문</h3>
<c:forTokens items="유정환-김민아-김윤정-강범준" delims="-" var="name">
	<p>${name }</p>
</c:forTokens>
<br>
<c:forTokens items="유정환/김민아*김윤정_강범준" delims="/*_" var="irum">
	<p>${irum }</p>
</c:forTokens>
<hr>
<h3>09. c:url => 인터넷 주소 정의문(쓰임 드물다.)</h3>
<c:url var="kang" value="test99.jsp">
	<c:param name="id" value="kangmh" />
	<c:param name="pw" value="1234" />	
</c:url>
<a href="${kang }">데이터 던지기</a>
<!-- ${kang } = "test99.jsp?id=kang&pw=1234" -->
</body>
</html>