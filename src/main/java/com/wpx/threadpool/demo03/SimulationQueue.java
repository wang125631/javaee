package com.wpx.threadpool.demo03;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过使用wait/notify来模拟一个阻塞的队列(BLocking Queue)
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class SimulationQueue {

	private LinkedList list =new LinkedList();
	
	private int minSize;
	
	private AtomicInteger count =new AtomicInteger(0);
	
	private final int maxSize;
	
	public SimulationQueue(int maxSize) {
		this.maxSize= maxSize;
	}
	
	
	public static void main(String[] args) {
		
	}
}
