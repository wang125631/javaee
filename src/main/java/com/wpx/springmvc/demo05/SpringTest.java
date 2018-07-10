package com.wpx.springmvc.demo05;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wpx.springmvc.User;

@RequestMapping("/spring-mvc/demo05")
@Controller
@SessionAttributes({"user"})
public class SpringTest {


	
	private static final String SUCCESS="success";
	
	/**
	 * 映射请求头信息
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader("Accept-Language") String la) {
		System.out.println(" TestRequestHeader Accept Language "+la);
		return SUCCESS;
	}
	
	/**
	 * 
	 * 测试Cookie值
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String id) {
		System.out.println(" TestCookieValue JSESSIONID  " +id);
		return SUCCESS;
	}
	
	/**
	 * springmvc对原生的ServletApi的支持
	 * 可接受的类型参数:
	 * 	HttpServletRequest	HttpServletResponse
	 * HttpSession java.security.Principal
	 * Locale InputStream OutputStream 
	 * Reader Writer
	 * @throws IOException 
	 * 
	 */
	@RequestMapping("/testServletAPI")
	public String testServletAPI(HttpServletRequest request) throws IOException {
		String requestParater=(String) request.getParameter("username");
		System.out.println(requestParater);
		return SUCCESS;
	}
	
	/**
	 * 测试ModelAndView
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView mav=new ModelAndView("success");
		mav.addObject("message", "ModelAndView请求信息");
		return mav;
	}
	
	/**
	 * 测试Model
	 */
	@RequestMapping("/testModel")
	public String testModel(Model model) {
		model.addAttribute("message", "model信息");
		return SUCCESS;
	}
	
	/**
	 *测试Map 
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String,Object> map) {
		map.put("message", "map信息");
		return SUCCESS;
	}
	/**
	 * 测试SessionAttribute
	 */
	@RequestMapping("/testSessionAttibute")
	public String testSessionAttribute(Map<String,Object> map) {
		User user=new User(1, "wangpx", 21);
		map.put("user", user);
		return SUCCESS;
	}
	
	/**
	 * 测试ModelAttribute
	 */
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(User user) {
		System.out.println("修改  : "+user);
		return SUCCESS;
	}
	/**
	 * ModelAttribute注解
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false)Integer id,Map<String,Object> map) {
		if(id != null) {
			//模拟从数据库中获取数据
			User user=new User(1,"wangpx",22);
			System.out.println("从数据库中获取一个对象: "+user);
			map.put("user", user);
		}
	}
	
	
}
