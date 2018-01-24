<%@page import="java.util.List"%>
<%@page import="com.wpx.servlet.demo19.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h6>获取域对象中的值</h6>
<%
	pageContext.setAttribute("page_name", "page_value");
	request.setAttribute("request_name", "request_value");
%>
${pageScope.page_name}
${requestScope.request_name}

<h6>获取域中数组的值</h6>
<%
	String [] arrs = {"value01","value02","value03","value04"};
	request.setAttribute("request_arrs", arrs);
%>
${request_arrs[2]}

<h6>获取域中Map的值</h6>
<%
	Map<String,String> map= new HashMap<String,String>();
	map.put("map01", "map_value01");
	map.put("map02", "map_value02");
	map.put("map03", "map_value03");
	request.setAttribute("request_map", map);
%>
${request_map.map02}

<h6>获取域中集合有对象的值</h6>
<%
	 List<Student> studentList= new ArrayList<Student>();
	 studentList.add(new Student(1,"name01"));
	 studentList.add(new Student(2,"name02"));
	 request.setAttribute("studentList", studentList);
%>
${ studentList[1].name}

<h6>EL的运算</h6>
<%
		request.setAttribute("n1", 10);
		request.setAttribute("n2", 20);
		request.setAttribute("n3", 30);
		request.setAttribute("n4", 40);
%>
<h6>运算</h6>
${ n2+n3 }
<h6>大于</h6>
${ n1 > n2 }   ${ n2 gt n1}
<h6>少于</h6>
${ n1 < n2 }   ${ n1 lt n2 }
<h6>等于</h6>
${ n1 == n2 }   ${ n1 eq n2 }
<h4>不等于</h4>
${ n1 != n2 }	${ n1 ne n2 }

<h4>大于等于</h4>
${ n1 >= n2 }	${ n1 ge n2 }

<h4>小于等于</h4>
${ n1 <= n2 }	${ n1 le n2 }

<h3>逻辑运算</h3>
<h4>与</h4>
${ n1 > n2 && n3 > n4 }		${ n1 > n2 and n3 > n4 }

<h4>或</h4>
${ n1 > n2 || n3 > n4 }		${ n1 > n2 or n3 > n4 }

<h4>非</h4>
${ !(n1 > n2) }		${ not (n1 > n2) }


</body>
<!--1256317570@qq.com  -->
</html>