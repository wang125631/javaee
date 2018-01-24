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
<h6>传统方式</h6>
<%
	request.setAttribute("name", "value");
%>
<%=request.getAttribute("name") %>
<%
	request.removeAttribute("name");
%>
<%=request.getAttribute("name") %>
<h6>JSTL</h6>
<c:set var="jstl_name" value="jstl_value" scope="page"></c:set>
${jstl_name}
<c:remove var="jstl_name"/>
${jstl_name }
</body>
<!--1256317570@qq.com  -->
</html>