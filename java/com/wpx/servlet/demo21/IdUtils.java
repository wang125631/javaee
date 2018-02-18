package com.wpx.servlet.demo21;

import java.util.UUID;

/**
 * 用于生成特定id
 * 
 * @author wangpx
 */
public class IdUtils {

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
