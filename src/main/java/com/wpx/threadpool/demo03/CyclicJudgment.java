package com.wpx.threadpool.demo03;

import java.util.ArrayList;
import java.util.List;

/**
 * 用原始的方法通过不断的循环来判断
 * 
 * @author wangpx
 */
public class CyclicJudgment {

	private volatile static List list = new ArrayList<>();  

	public void add() {
		list.add("wangpx");
	}
	public int size() {
		
	}
	
}
