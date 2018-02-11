<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMvc相关注解测试</title>
</head>
<body>

	<a href="testRequestHeader">测试请求头</a>
	<br>
	<a href="testCookieValue">测试Cookie值</a>
	<br>
	<a href="testServletAPI?username=wpx">测试原生的ServletAPI</a>
	<br>
	<a href="testModelAndView">测试ModelAndView</a>
	<br>
	<a href="testModel">测试Model</a>
	<br>
	<a href="testMap">测试Map</a>
	<br>
	<a href="testSessionAttibute">测试SessionAttibute</a>
	<br>
	
	<form action="testModelAttribute">
		<input type="hidden" name="id" value="1">
		
		<br>
		<input type="text" name="age" value="21">
		<input type="submit" value="提交" >
	</form>
	
</body>
<!--1256317570@qqcom  -->
</html>