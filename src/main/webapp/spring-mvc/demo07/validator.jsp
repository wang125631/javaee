<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试springmvc 数据校验</title>
</head>
<body>

<form action="testValidator" method="post">

id:<input type="text" name="id"><font color="red">${errors.getFieldError("id").defaultMessage }</font><br>
name:<input type="text" name="name"><font color="red">${errors.getFieldError("name").defaultMessage }</font><br>
email:<input type="text" name="email"><font color="red">${errors.getFieldError("email").defaultMessage }</font><br>
birthday:<input type="text" name="birthday"><font color="red">${errors.getFieldError("birthday").defaultMessage }</font><br>
<input type="submit" value="提交">
</form>

</body>
</html>