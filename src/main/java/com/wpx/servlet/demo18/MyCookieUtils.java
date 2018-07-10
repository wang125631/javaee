package com.wpx.servlet.demo18;

import javax.servlet.http.Cookie;

/**
 * 通过cookie名称查找出对应的cookie
 * 
 * @author wangpx
 */
public class MyCookieUtils {

	public static Cookie getCookieByName(Cookie[] cookies,String cookiesName) {
		if(cookies==null) {
			return null;
		}else {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals(cookiesName)) {
					return cookie;
				}
			}
			return null;
		}
	
	}
	
}
