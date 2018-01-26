package com.wpx.threadpool.demo05;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * @author wangpx
 */
public class CopyOnWriteArrayListTest {

	public static void main(String[] args) {
		//创建copyOnWriteArrayList对象
		CopyOnWriteArrayList<String> copyOnWriteArrayList = new  CopyOnWriteArrayList<String>();
		//添加元素
		copyOnWriteArrayList.add("value01");
		copyOnWriteArrayList.add("value02");
		//遍历元素
		for(String s : copyOnWriteArrayList) {
			System.out.println(s);
		}
	}
}
