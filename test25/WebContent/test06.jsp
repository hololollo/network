<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP의  기본 8 객체</title>
</head>
<body>
<h2>JSP 내장 객체(문법, Rule)</h2>
<p>out : 브라우저에 출력할 경우 사용(jsp코드 자체가 out객체로 이루어져 있다.])</p>
<%
	out.print("<a href=''></a>"); // 코드 자체가 생략되어있다고 생각하면 편하다.
%>
<p>request : 요청 정보를 담는 객체</p>
<p>response : 응답 정보를 담는 객체</p>
<p>session : 세션 정보를 담는 객체</p>
<p>application : 웹 애플리케이션 정보를 담는 객체</p>
<p>config : 웹 설정정보를 담는 객체</p>
<p>page : 웹 페이지 정보를 담는 객체</p>
<p>exception : 예외 처리 정보를 담는 객체(에러 페이지)</p>
<%
	// servlet에서는 해당 객체들을 기본으로 지원하지 않는다.
	
	// servlet에서 page 객체 생성하기
	// HttpServlet spageContext = new HttpServlet();
	// Object spage = pageContext.getPage();
	
	// Servlet에서 out 객체 생성하기
	// PrintWriter out = response.getWriter();
	
	// Servlet에서 request객체 생성하기
	// ServletRequest request = pageContext.getRequest();
	
	// Servlet에서 response객체 생성하기
	// ServletResponse response = pageContext.getResponse();
	
	
	// ★ Servlet에서 session 객체 생성하기
	// HttpSession session = pageContext.getSession();
	
	// Servlet에서 application 객체 생성하기
	// ServletContext application = pageContext.getServletContext();

	// Servlet에서 config 객체 생성하기
	// ServletConfig config = pageContext.getServletConfig();
	
	// Servlet에서 exception 객체 생성하기
	// Exception exception = pageContext.getException();
	
	// Servlet에서 jsp 객체 생성하기		
	// JspWriter jspOut = pageContext.getOut();
	
	String name = "강범준";
	out.println("<h2>"+name+"</h2>");
	out.println("<br>");
	
%>
	<h2><%=name %></h2>
<%
	
	out.println("<h2>스크립트릿(Scriptlet) 내에서만 사용하는 JSP 8 객체</h2>");
	JspWriter jspOut = pageContext.getOut(); // out 객체 만들기
	out.println("<h2>  out : 태그를 포함한 내용을 출력할 수 있는 객체 </h2>");
	out.println(jspOut == out);
	
	ServletRequest jspReq = pageContext.getRequest();
	out.println("<h2>request : 브라우저를 통하여 요청한 정보를 저장하는 객체</h2>");
	out.println(jspReq == response);
	
	
	ServletResponse jspRes = pageContext.getResponse();
	out.println("<h2>response : 브라우저를 통하여 반환한 결과를 저장하는 객체</h2>");
	out.println(jspRes == response);

	HttpSession jspSes = pageContext.getSession();
	out.println("<h2>session(세션) : 인가된 사용자 정보를 저장하는 객체</h2>");
	out.println("<h3>session(세션)은 로그아웃 전 또는 브라우저를 종료하기 전 까지 그 정보가 유지된다.</h3>");	
	out.println(jspSes == session);	
	
	ServletContext jspApp = pageContext.getServletContext();
	out.println("<h2>application(앱) : 인가된 사용자 정보를 저장하는 객체</h2>");
	out.println("<h3>application(앱)은 브라우저 종료 전까지 그 정보가 유지된다.</h3>");	
	out.println(jspApp == application);	
	
	ServletConfig jspCon = pageContext.getServletConfig();
	out.println("<h2>config(설정) : 애플리케이션 설정 정보를 저장하는 객체</h2>");
	out.println(jspCon == config);
	
	Exception jspExc = pageContext.getException();
	Exception exception = pageContext.getException();	
	out.println("<h2>exception(예외 처리) : 예외 처리 정보를 저장하는 객체</h2>");
	out.println(jspExc == exception);
	
	Object jspPage = pageContext.getPage();
	out.println("<h2>page(페이지) : 현재 페이지 정보를 저장하는 객체</h2>");
	out.println("<h3>page(페이지)는 그 정보가 현재 페이지 내에서만 정보가 유지된다.</h3>");
	
	out.println("<h3>전송된 값은 그 정보가 목적지까지만 유지되며, 다른 페이지에서는 해당 정보를 확인할 수 없다.</h3>");
	out.println("<p>웹 환경에서의 Scope : 그 정보가 어디(언제)까지 유지되는지</p>");
	out.println("정보 저장 크기 : page < trans < session < application");
	out.println("trans : request, response");
	
	
%>
<hr>
<div>
	<a href="test07.jsp">테스트 07로 이동</a>
</div>
</body>
</html>