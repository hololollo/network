<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 전달 및 스코프 결과 페이지</title>
</head>
<body>
<p> 데이터 전달  </p>
<%
	List<String> lst = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<Integer, String> map = new HashMap<>();
	
	lst = (ArrayList<String>) request.getAttribute("lst"); // 형 변환 필요
	set = (HashSet<String>)request.getAttribute("set");
	map = (HashMap<Integer, String>)request.getAttribute("map");
	
	out.println("<h2>List 접근</h2>");
	out.println("<ul>");
	for(String s : lst) {
		out.println("<li>" + s + "</li>");
	}
	//for(int i = 0; i < list.size(); i++) {
		//out.println("<li>" + lst.get(i) + "</li>");
	//}
	out.println("</ul><hr>");
	
	out.println("<h2>Set 접근</h2>");
	out.println("<ul>");
	for(String s : set) {
		out.println("<li>" + s + "</li>");
	}
	out.println("</ul><hr>");	
	
	out.println("<h2>Map 접근</h2>");
	out.println("<ul>");
	Collection<String> val = map.values(); // 값만 가져오면 되니까.
	for(String s : val) {
		out.println("<li>" + s + "</li>");
	}
	out.println("</ul><hr>");	
	
%>
<h2>데이터 전달 및 스코프 결과 페이지</h2>
<p>스코프 결과</p>
<%
	pageContext.setAttribute("pageData", "페이지");
	request.setAttribute("reqData", "요청데이터");
	session.setAttribute("sesData", "세션데이터");
	application.setAttribute("appData", "애플리케이션데이터");
	
	out.println("page : " + pageContext.getAttribute("pageData"));
	out.println("request : " + pageContext.getAttribute("reqData"));
	out.println("session : " + pageContext.getAttribute("sesData"));
	out.println("application : " + pageContext.getAttribute("appData"));
%>
<div>
	<a href="test09.jsp?msg=테스트해보기">테스트 09로 이동</a>
</div>
</body>
</html>