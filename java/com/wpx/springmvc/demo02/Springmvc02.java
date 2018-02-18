package com.wpx.springmvc.demo02;


/**
	springMVC的工作流程
	
	1.用户发送一个请求到DispatherServlet
	
	2.DispatherServlet接受到请求调用HandlerMapping处理器映射器
	
	3.处理器映射器找到具体的处理器，将处理器对象或处理拦截器（如果有）一并返回给DispatherServlet
	
	4.DispatherServlet调用HandlerAdapter处理器适配器
	
	5.HandlerAdapter处理器适配器调用相应的处理器Controller
	
	6.Controller执行返回ModelAndView
	
	7.HandlerAdapter将Controller执行结果ModelAndView返回给DispatherServlet
	
	8.DispatherServlet将ModelAndView传递给viewReslover视图解析器
	
	9.viewReslover视图解析器解析后返回具体的view
	
	10.DispatherServlet将具体的view进行渲染
	
	11.DispatherServlet将数据响应给用户请求
 * 
 * @author wangpx
 */

public class Springmvc02 {

	
}
