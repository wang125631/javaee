<%@page import="com.wpx.servlet.demo19.Student"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forEach</title>
</head>
<body>

<h6>遍历数组</h6>
<%
	String[] arrs= {"value01","value02","value03"};
	request.setAttribute("arrs", arrs);
%>
<c:forEach var="s" items="${arrs }">
	${s }
</c:forEach>

<h6>遍历集合</h6>
<%
	List<String> list= new ArrayList<String>();
	list.add("list_value01");
	list.add("list_value02");
	list.add("list_value03");
%>
<c:forEach var="s" items="${list }">
	${s }
</c:forEach>

<h6>遍历Map</h6>
<%
	Map<String,String> map = new HashMap<String,String>();
	map.put("map01", "map_value01");
	map.put("map02", "map_value02");
	map.put("map03", "map_value03");
	request.setAttribute("map", map);
%>
<c:forEach var="m" items="${map }">
	${m.key }------${m.value }
</c:forEach>

<h6>遍历对象的集合</h6>
<%
	 List studentList= new ArrayList<Student>();
	 studentList.add(new Student(1,"student01"));
	 studentList.add(new Student(2,"student02"));
	 studentList.add(new Student(3,"student03"));
	 request.setAttribute("studentList",studentList);
%>
<c:forEach var="s" items="${studentList }">
	${s.id }-----${s.name }
</c:forEach>

<h6>迭代</h6>
<c:forEach var="i" begin="1" end="10" step="1">
	${i }
</c:forEach>

<h6>计算从1加到100的和</h6>
<c:set var="sum" value="0" scope="page"></c:set>
<c:forEach var="i" begin="1" end="100" step="1" varStatus="status">
	<c:set var="sum" value="${sum+i }"></c:set>
</c:forEach>
${sum }

<h6>遍历10到100的偶数，每到第3个数，显示红色</h6>
<c:forEach var="i" begin="10" end="100" step="2" varStatus="status">
	<c:choose>
		<c:when test="${status.first }">
			<font color="blue">${i }</font>
		</c:when>
		<c:when test="${status.count % 3 eq 0 }">
			<font color="red">${i }</font>
		</c:when>
		<c:otherwise>
			${i }
		</c:otherwise>
	</c:choose>
</c:forEach>

</body>
</html>