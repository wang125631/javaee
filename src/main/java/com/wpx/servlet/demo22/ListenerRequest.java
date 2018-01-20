package com.wpx.servlet.demo22;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ListenerRequest implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println(" Request has Destroyed ...");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println(" Request has Initialized ...");
	}

}
