package com.wpx.servlet.demo22;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class ListenerServletContext implements ServletContextListener{

	//线程安全的list集合
	private List<HttpSession> sessions=Collections.synchronizedList(new ArrayList<HttpSession>());
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//项目启动时执行,得到ServletContext
		ServletContext servletContext = sce.getServletContext();
		//将集合保存到session中
		servletContext.setAttribute("sessions", sessions);
		//创建Timer对象
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
			}
		}, 1000);
		
		System.out.println("ServletContext Initialized ....");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext has Destoryed....");
		
	}

}
