package com.wpx.servlet.demo22;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ListenerSessionAttribute  implements  HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// se.getSession(); 获取事件源，也就是获取session对象.
		System.out.println(se.getName());
		System.out.println(se.getValue());
		System.out.println("向session中添加属性");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("从session中移除属性");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("将session中的属性修改");
	}

}
