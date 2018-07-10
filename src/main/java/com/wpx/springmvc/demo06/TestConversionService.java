package com.wpx.springmvc.demo06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wpx.springmvc.User;

/**
 * 
 * ConversionService 是Spring类型转换体系的核心接口
 * 
 * 可以利用ConversionServiceFactoryBean在Spring的IOC容器中定义ConversionService
 * 
 * Spring将自动识别出IOC容器中的ConversionService,并在Bean属性配置及Spring MVC处理方法入参绑定等场合
 * 
 * 使用进行数据的转化
 * 
 * @author wangpx
 */
@Controller
@RequestMapping("/spring-mvc/demo06")
public class TestConversionService {

	private static final String SUCCESS ="success";
	
	@RequestMapping("/testUserConverter")
	public String testUserConverter(@RequestParam("user") User user) {
		System.out.println(user);
		return SUCCESS;
	}
}
