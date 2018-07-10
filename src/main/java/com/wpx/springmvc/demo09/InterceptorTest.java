package com.wpx.springmvc.demo09;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterceptorTest implements HandlerInterceptor{

	/**
	 * 这个方法在DispatherServlet完全处理完请求后被执行,可以在该方法中进行一些资源清理的操作
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		 
		
	}

	/**
	 * 这个方法在业务处理器处理完请求后,DispatcherServlet向客户端返回响应前被调用
	 * 在该方法中对用户请求request处理
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		 
		
	}
	/**
	 * 这个方法在业务处理器处理请求前被调用,在该方法中对用户请求request进行处理
	 * 如果还要调用其他拦截器,或者业务处理器进行处理,返回true
	 * 如果不再需要调用其他的组件处理请求,则返回false
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		 
		return false;
	}

}
