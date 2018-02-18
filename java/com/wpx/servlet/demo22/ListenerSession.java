package com.wpx.servlet.demo22;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 用于监听Session的创建于销毁
 * 
 * @author wangpx
 */
public class ListenerSession implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println(" Session Created ...");
		//可以从中获取session对象
		HttpSession session = se.getSession();
		//集合是在ServletContext中存储的，我们只需要从ServletContext中获取就可以。
		ServletContext context = session.getServletContext();
		List<HttpSession> sessions=(List<HttpSession>) context.getAttribute("sessions");
		sessions.add(session);
		System.out.println(session.getId() +"  添加到了集合中");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println(" Session Destroyed ...");
	}

}
