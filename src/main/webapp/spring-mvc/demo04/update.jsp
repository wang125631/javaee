<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script type="text/javascript">

		$(function(){
			var gender=$("#gender").val();
			var depId=$("#departmentId").val();
			$("#s_gender option[value='"+gender+"']").attr("selected","selected");
			$("#s_departmentId option[value='"+depId+"']").attr("selected","selected");
		})

</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/spring-mvc/demo04/emp" method="post"  >
	<input type="hidden" name="_method" value="PUT"> 
	<div style="padding-top: 280px" align="center">
		姓名: <input name="name" value="${employee.name}"><br>
		邮箱: <input name="email" value="${employee.email }"><br>
		性别:
		<input type="hidden" id="gender" value="${employee.gender}">
		 <select id="s_gender" name="gender">
			<option id="男" value="男" >男</option>
			<option id="女" value="女">女</option>
		</select>
		
		部门:
		<input type="hidden" id="departmentId" value="${employee.department.id}">
		<select id="s_departmentId" name="departmentId">
			<option  value="1">Name-01</option>
			<option  value="2">Name-02</option>
			<option  value="3">Name-03</option>
			<option  value="4">Name-04</option>
		</select>
		
		<input type="submit" value="提交">
	</div>	
</form>
</body>
</html>