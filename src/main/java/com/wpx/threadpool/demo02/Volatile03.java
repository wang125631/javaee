package com.wpx.threadpool.demo02;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *automic类只能本身方法的一致性,不能保证多次操作的一次性
 *
 *
 *
 *
 * @author wangpx
 */
public class Volatile03 {
	
	private static AtomicInteger count = new AtomicInteger(0);
	
	public int multiAdd() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count.addAndGet(1);
		count.addAndGet(2);
		count.addAndGet(3);
		count.addAndGet(4);
		
		return count.get();
	}

	public static void main(String[] args) {
	
		final Volatile03 v = new  Volatile03();
		ArrayList<Thread> list = new ArrayList<>();
		for(int i = 100;i > 0;i--) {
			list.add(new Thread( () -> {System.out.println(v.multiAdd());}));
		}
		for (Thread thread : list) {
			thread.start();
		}
		
	}
}
