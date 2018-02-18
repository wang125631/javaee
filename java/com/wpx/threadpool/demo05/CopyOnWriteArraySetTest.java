package com.wpx.threadpool.demo05;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 应用场景为读多写少
 * 
 * @author wangpx
 */
public class CopyOnWriteArraySetTest {

	public static void main(String[] args) {
		//创建copyOnWriteArraySet
		CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
		//向copyOnWriteArraySet中添加元素
		copyOnWriteArraySet.add("value01");
		copyOnWriteArraySet.add("value02");
		//遍历copyOnWriteArraySet集合
		for(String s : copyOnWriteArraySet) {
			System.out.println(s);
		}
		
	}
}
