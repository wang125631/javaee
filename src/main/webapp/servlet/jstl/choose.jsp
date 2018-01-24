<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>catch</title>
</head>
<body>

<h1>传统</h1>
<%
	int i = 5;
	if( i > 5){
		out.print("大于5");
	} else if( i < 5){
		out.print("小于5");
	}else{
		out.print("等于5");
	}
%>

<h1>JSTL</h1>
<c:set var="a" value="10" scope="page"></c:set>
<c:choose>
	<c:when test="${a ge 10 }">
		大于10
	</c:when>
	<c:when test="${i lt 10 }">
		小于10
	</c:when>
	<c:otherwise>
		等于10
	</c:otherwise>
</c:choose>
</body>
<!--1256317570@qq.com  -->
</html>