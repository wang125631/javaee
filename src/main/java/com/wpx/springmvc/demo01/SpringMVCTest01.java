package com.wpx.springmvc.demo01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 点击/spring-mvc/demo01下的demo01.jsp页面中
 * 的超链接跳转到success 页面
 * 
 * @author wangpx
 */
@Controller
@RequestMapping("/spring-mvc")
public class SpringMVCTest01 {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello springmvc");
		return "success";
	}
}
