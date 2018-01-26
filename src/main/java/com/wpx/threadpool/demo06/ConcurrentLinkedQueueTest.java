package com.wpx.threadpool.demo06;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueue:
 * 适用于高并发场景下的队列,通过无锁的方式,实现了高并发状态下的高性能,通常情况下ConcurrentQueue性能好于BlockingQueue
 * 他是一个基于链接节点的无界线程安全队列,该队列的元素遵循先进先出的原则,该队列不允许null元素
 * 
 * ConcurrentLinkedQueue的重要方法
 * add()和offer()都是加入元素的方法,在ConcurrentLinkedQueue中这两个方法没有区别
 * poll()和peek()都是取头元素节点,区别在于前者会删除元素,后者不会
 * 
 * @author wangpx
 */
public class ConcurrentLinkedQueueTest {

	public static void main(String[] args) {
		//创建concurrentLinkedQueue
		ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
		//向队列中添加元素
		concurrentLinkedQueue.add("value01");
		concurrentLinkedQueue.offer("value02");
		
		//从队列中移除元素
		String poll = concurrentLinkedQueue.poll();
		System.out.println(poll);
		System.out.println(concurrentLinkedQueue.size());
		
		String peek = concurrentLinkedQueue.peek();
		System.out.println(peek);
		System.out.println(concurrentLinkedQueue.size());
	}
}
