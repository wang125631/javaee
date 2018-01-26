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

	private LinkedList<Object> list =new LinkedList<>();
	
	private int minSize = 0;
	
   AtomicInteger count =new AtomicInteger(0);
	
	private final int maxSize;
	
	public SimulationQueue(int maxSize) {
		this.maxSize= maxSize;
	}
	private final Object lock = new Object();
	
	//向队列中放入对象
	public void putObject(Object obj) {
		synchronized (lock) {
			while( count.get() == maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(obj);
			count.incrementAndGet();
			System.out.println("新添加的元素为" +obj);
			lock.notify();
		}
	}
	//从队列中取出对象
	public Object takeObject() {
		Object result = null;
		synchronized (lock) {
			while( count.get() == minSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			result = list.removeFirst();
			count.decrementAndGet();
			System.out.println("移除的元素为"+result);
			lock.notify();
		}
		return result;
	}
	//获取当前队列大小
	public int getSize() {
		return this.count.get();
	}

	public static void main(String[] args) {
		SimulationQueue sq = new SimulationQueue(5);
		for(int i = 0;i < 5; i++) {
			sq.putObject(i+"");
		}
		System.out.println("队列中对象数量为: "+sq.getSize());
		
		new Thread( () ->  {
			sq.putObject("6");
			sq.putObject("7");
			System.out.println("队列中对象数量为: "+sq.getSize());
		}).start();
		
		new Thread( () ->  {
			 String object = (String) sq.takeObject();
			 System.out.println(object + "元素被移除...");
		} ).start();
	
	}


}
