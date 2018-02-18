package com.wpx.threadpool.demo06;

import java.util.concurrent.SynchronousQueue;

/**
 *   SynchronousQueue同步队列:一种没有缓冲的队列,生产者生产的数据直接会被消费者获取并消费
 * 这个队列没有容量
 * 
 * @author wangpx
 */
public class SynchronousQueueTest {

	public static void main(String[] args) {
		//创建synchronousQueue对象
		SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();
		//添加元素
		synchronousQueue.add(args);
	}
}
