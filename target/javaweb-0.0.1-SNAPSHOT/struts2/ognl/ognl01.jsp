<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ognl</title>
</head>
<body>
<h1>使用ognl通过对象来调用方法</h1>
<s:property value="'wangpx'.length()"/>
<br><hr>
<s:property value="@java.lang.Math@max(10,20)"/>

</body>
<!--1256317570@qqcom  -->
</html>