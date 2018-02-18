package com.wpx.springmvc.demo07;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/spring-mvc/demo07")
public class SpringmvcTest {

	private static final String SUCCESS="success";
	
	@RequestMapping("testValidator")
	public String testValidator(@Valid Person person,BindingResult result,Map<String,Object> map) {
	
		if(result.getErrorCount()>0) {
			for(FieldError error :result.getFieldErrors() ) {
				System.out.println(error.getField()+" : "+error.getDefaultMessage());
			}
		map.put("errors", result);
		//TODO 为了更好的体验,可以设置回显表单
		return "demo07/validator";
		}
		return SUCCESS;
	}
}
