package com.wpx.jvm.demo03;

import java.util.Vector;
/**
 * 堆异常
 * 
 * @author wangpx
 */
public class HeapDumpOnOutOfMemoryError {

	public static void main(String[] args) {
		
		//-Xms1m -Xmx1m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/HeapDumpOnOutOfMemoryError.dump
		//堆内存溢出 使用mat ( memory analyzer ) 打开.dump文件 
		Vector v = new Vector();
		for(int i=0; i < 5; i ++){
			v.add(new Byte[1*1024*1024]);
		}
		
	}

	
}
