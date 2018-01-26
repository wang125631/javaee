package com.wpx.threadpool.demo06;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 *   BlockingQueue接口
 * 
 *   ArrayBlockQueue:基于数组的阻塞队列实现,在ArrayBlockQueue内部,维护了一个定长的数组,
 *   便于缓存队列中的数据对象,,其内部没有实现读写分离,也就意味着生产和消费不能完全并行,长度需要定义,
 *   可以指定先进先出或者先进后出,也叫有界队列
 * 
 * @author wangpx
 */
public class ArrayBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		//创建arrayBlockingQueue
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(4);
		//添加元素
		arrayBlockingQueue.add("a");
		arrayBlockingQueue.add("b");
		arrayBlockingQueue.add("c");
		arrayBlockingQueue.add("d");
		//向队列中添加元素  返回值为boolean 参数分别为 添加元素 ,时长,时间单位
		System.out.println(arrayBlockingQueue.offer("e", 1, TimeUnit.SECONDS));
		arrayBlockingQueue.add("error");
	}
}
