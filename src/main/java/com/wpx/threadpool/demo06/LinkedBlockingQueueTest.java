package com.wpx.threadpool.demo06;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 *   LinkedBlockingQueue:基于链表的阻塞队列,,同ArrayBlockingQueue类似,其内部也维持着一个数据缓冲队列
 *  队列由数据缓冲队列,队列由一个链表构成,LinkedBlockingQueue之所以能高效的处理并发数据是因为其内部采用分离锁
 *  从而实现生产者和消费者的完全并行处理
 * 
 * @author wangpx
 */
public class LinkedBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		//创建linkedBlockingQueue对象
		LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
		//向linkedBlockingQueue中添加元素
		linkedBlockingQueue.add("a");
		linkedBlockingQueue.add("b");
		linkedBlockingQueue.add("c");
		System.out.println(linkedBlockingQueue.offer("d", 1, TimeUnit.SECONDS));
		
		ArrayList<String> arrayList = new ArrayList<String>();
		int drainTo = linkedBlockingQueue.drainTo(arrayList,2);
		System.out.println(drainTo);
		System.out.println(linkedBlockingQueue.size());
		System.out.println(arrayList.size());
		
	}
}
