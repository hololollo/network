<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> 
<%@ page import="org.kh.dto.Member" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL(Java Standard Tag Library) FMT(Format)</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<hr>
<h3>FMT(Format : 표시, 출력 형식)</h3>
<c:set var="num" value="12345678.9876543"/>
<c:set var="data" value="3,652,733"/>
<c:set var="su1" value="0"/>
<c:set var="su2" value="4"/> 
<c:set var="su3" value="-6500000"/> 
<c:set var="today" value="<%=new Date() %>"/> 
<br><hr><br>
<h3>01. fmt:parseNumber => 숫자로 바꾸는 데이터 변환문 </h3>
<c:out value="${data }"/>
<p><fmt:parseNumber value="${data }" pattern="0,000" var="data2"/></p>
<p>${data2 }</p>
<p>1년은 ${data2/10000 }일 입니다.</p>
<hr>
<h3>02. fmt:formatNumber => 숫자 표시형식 변환문</h3>
<p>groupingUsed 속성 : 천단위 구분기호 사용여부</p>
<p><fmt:formatNumber value="${num }" groupingUsed="true" /></p>
<p><fmt:formatNumber value="${su1 }" groupingUsed="true" /></p>
<p><fmt:formatNumber value="${su3 }" groupingUsed="true" /></p>
<br>
<p>pattern 속성 활용 : 천단위 구분기호 사용여부</p>
<p><fmt:formatNumber value="${num }" pattern="#,##0" /></p>
<p><fmt:formatNumber value="${su1 }" pattern="#,##0" /></p>
<p><fmt:formatNumber value="${su3 }" pattern="#,##0" /></p>
<p><fmt:formatNumber value="${num }" pattern="\ #,##0" /></p>
<br>
<p><fmt:formatNumber value="${num }" pattern="#,##" /></p>
<p><fmt:formatNumber value="${su1 }" pattern="#,##" /></p>
<p><fmt:formatNumber value="${su3 }" pattern="#,##" /></p>
<br>
<p><fmt:formatNumber value="${num }" pattern="0.00" /></p>
<p><fmt:formatNumber value="${su1 }" pattern="0.00" /></p>
<p><fmt:formatNumber value="${su3 }" pattern="0.00" /></p>
<br>
<h3>type 속성 : percent</h3>
<p><fmt:formatNumber value="${num }" type="percent"/></p>
<p><fmt:formatNumber value="${su1 }" type="percent"/></p>
<p><fmt:formatNumber value="${su3 }" type="percent"/></p>
<br>
<h3>type 속성 : currency</h3>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<br>
<h3>국가-언어 코드 설정</h3>
<h4>대한민국(ko_KR)</h4>
<fmt:setLocale value="ko_kr"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<h4>일본(ja_JP)</h4>
<fmt:setLocale value="ja_jp"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<h4>미국(en_US)</h4>
<fmt:setLocale value="en_us"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<h4>중국(zh_CN)</h4>
<fmt:setLocale value="zh_cn"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<h4>대만(zh_TW)</h4>
<fmt:setLocale value="zh_tw"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<h4>베트남(vi_VN)</h4>
<fmt:setLocale value="vi_vn"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<h4>말레이시아(ms_MY)</h4>
<fmt:setLocale value="ms_my"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<h4>프랑스(fr_FR)</h4>
<fmt:setLocale value="fr_FR"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<h4>독일(de_DE)</h4>
<fmt:setLocale value="de_DE"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<fmt:setLocale value="ko_kr"/>
<p><fmt:formatNumber value="${num }" type="currency"/></p>
<p><fmt:formatNumber value="${su1 }" type="currency"/></p>
<p><fmt:formatNumber value="${su3 }" type="currency"/></p>
<p><fmt:formatDate value="${today }" pattern="yyyy-MM-dd EEEE a hh:mm:ss"/></p>
<br>
<hr>
<br>
<c:set var="data1" value="2024-03-25"/>
<c:set var="time1" value="09:26:29"/>
<c:set var="today2" value="<%=new Date() %>"/>
<br>
<h2>날짜 데이터 표시형식 지정</h2>
<h3>문자열을 날짜/시간 데이터로 변환</h3>
<fmt:parseDate value="${date1 }" pattern="yyyy-MM-dd" var="date2"/>
<fmt:parseDate value="${time1 }" pattern="HH:mm:ss" var="time2"/>
<p>문자열을 날짜 클래스의 데이터로 변환 : ${date2 }</p>
<p>문자열을 시간 클래스의 데이터로 변환 : ${time2 }</p>
<br>
<h3>날짜/시간 표시형식을 지정</h3>
<h4>type속성 : both, date, type</h4>
<p>type : both - <fmt:formatDate value="${today2 }" type="both"/></p>
<p>type : date - <fmt:formatDate value="${today2 }" type="date"/></p>
<p>type : time - <fmt:formatDate value="${today2 }" type="time"/></p>
<h3>dateStyle속성 : full, long, medium, short</h3>
<h4>type: date, dateStyle:full, long, medium, short</h4>
<p>dateStyle : full - <fmt:formatDate value="${today2 }" type="date" dateStyle="full"/></p>
<p>dateStyle : long - <fmt:formatDate value="${today2 }" type="date" dateStyle="long"/></p>
<p>dateStyle : medium - <fmt:formatDate value="${today2 }" type="date" dateStyle="medium"/></p>
<p>dateStyle : short - <fmt:formatDate value="${today2 }" type="date" dateStyle="short"/></p>
<br>
<h4>type: time, dateStyle:full, long, medium, short</h4>
<p>dateStyle : full - <fmt:formatDate value="${today2 }" type="time" dateStyle="full"/></p>
<p>dateStyle : long - <fmt:formatDate value="${today2 }" type="time" dateStyle="long"/></p>
<p>dateStyle : medium - <fmt:formatDate value="${today2 }" type="time" dateStyle="medium"/></p>
<p>dateStyle : short - <fmt:formatDate value="${today2 }" type="time" dateStyle="short"/></p>
<br>
<h4>type: both, dateStyle:full, long, medium, short</h4>
<p>dateStyle : full - <fmt:formatDate value="${today2 }" type="both" dateStyle="full"/></p>
<p>dateStyle : long - <fmt:formatDate value="${today2 }" type="both" dateStyle="long"/></p>
<p>dateStyle : medium - <fmt:formatDate value="${today2 }" type="both" dateStyle="medium"/></p>
<p>dateStyle : short - <fmt:formatDate value="${today2 }" type="both" dateStyle="short"/></p>
<!-- y:연도, M:월, d:일, D:현재 연도 1월1일부터 몇일째인지, E:요일, a:오전/오후, h:12시간제, H:24시간제, m:분, s:초, S:밀리초 -->
<br>
<hr>
<br>
<h3>표시형식 코드</h3>
<p>y:연도, M:월, d:일, D:현재 연도 1월1일부터 몇일째인지, E:요일, a:오전/오후, h:12시간제, H:24시간제, m:분, s:초, S:밀리초</p>
<h4>pattern 속성</h4>
<p>날짜 표시형식 코드를 지정하여 출력</p>
<p><fmt:formatDate value="${today2 }" pattern="yyyy년 MM월 dd일 EEEE a hh:mm:ss"/></p>
<p><fmt:formatDate value="${today2 }" pattern="yy/M/d E H:m:s"/></p>
<br>
<hr>
<br>
<h2>timeZone(시간대) 태그</h2>
<p>setLocale은 지정된 다음부터 변경 전까지 계속 변경되지만, timeZone은 해당 하위 요소에만 적용</p>
<p>즉, setLocale과 다르게 일회성 </p>
<h3>서울</h3>
<fmt:timeZone value="Asia/Seoul">
	<fmt:formatDate value="${today2 }" pattern="yyyy/MM/dd EEEE a hh:mm:ss" />
</fmt:timeZone>
<h3>세계 표준시(UTC) </h3>
<fmt:timeZone value="UTC">
	<fmt:formatDate value="${today2 }" pattern="yyyy/MM/dd EEEE a hh:mm:ss" />
</fmt:timeZone>
<br>
<h2>setTimeZone(시간대) 태그</h2>
<p>setLocale은 해당 화폐단위와 언어가 모두 변경되지만, setTimeZone은 해당 지역의 시간대로 날짜/시간만 적용</p>
<h3>서울</h3>
<p>
	<fmt:setTimeZone value="Asia/Seoul"/>
	<fmt:formatDate value="${today2 }" pattern="yyyy/MM/dd EEEE a hh:mm:ss" />	
</p>
<br>
<h3>일본</h3>
<p>
	<fmt:setTimeZone value="Asia/Tokyo"/>
	<fmt:formatDate value="${today2 }" pattern="yyyy/MM/dd EEEE a hh:mm:ss" />	
</p>
<br>
<h3>미국</h3>
<p>
	<fmt:setTimeZone value="America/New_York"/>
	<fmt:formatDate value="${today2 }" pattern="yyyy/MM/dd EEEE a hh:mm:ss" />	
</p>
<br>
<h3>영국</h3>
<p>
	<fmt:setTimeZone value="Europe/London"/>
	<fmt:formatDate value="${today2 }" pattern="yyyy/MM/dd EEEE a hh:mm:ss" />	
</p>
<!-- 계속 영국에 맞춰서 진행되니 한국으로 다시 변경 -->
<fmt:setTimeZone value="Asia/Seoul"/>
<br>
<hr>
<br>
<p style="font-size:32px;color:red"><strong>※DB(datetime) -> Java(String) -> WebPage(parseDate -> formatDate)</strong></p>
</body>
</html>