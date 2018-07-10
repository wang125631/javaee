package com.wpx.threadpool.demo03;

import java.util.ArrayList;
import java.util.List;

/**
 * 用原始的方法通过不断的循环来判断
 * 
 * wait/notify要和synchronized关键字一起使用
 *
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class CyclicJudgment {

	private volatile static List list = new ArrayList<>();  

	public void add() {
		list.add("wangpx");
	}
	public int size() {
		return list.size();
	}
	public static void main(String[] args) {
		final CyclicJudgment cj = new CyclicJudgment();
		final Object lock = new Object();
		Thread t1 = new Thread( () -> {
			try {
				synchronized (lock) {
					for(int i = 0;i < 10;i++) {
						cj.add();
						System.out.println(Thread.currentThread().getName()+"添加了一个元素...");
						Thread.sleep(3000);
						//当集合大小等于5时去发送通知
						if(cj.size() == 5) {
							lock.notify();
							System.out.println("发出通知,唤醒另一个线程....");
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}) ;
		
		Thread t2 = new Thread( () ->  {
			synchronized (lock) {
				if(cj.size() != 5) {
					try {
						lock.wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() +"当前线程收到通知...");
				int i = 1/0;
			}
		});
		
		t2.start();
		t1.start();
		
		/**
		 *  Thread-0添加了一个元素...
			Thread-0添加了一个元素...
			Thread-0添加了一个元素...
			Thread-0添加了一个元素...
			Thread-0添加了一个元素...
			发出通知,唤醒另一个线程....
			Thread-0添加了一个元素...
			Thread-0添加了一个元素...
			Thread-0添加了一个元素...
			Thread-0添加了一个元素...
			Thread-0添加了一个元素...
			Thread-1当前线程收到通知...
			Exception in thread "Thread-1" java.lang.ArithmeticException: / by zero
				at com.wpx.threadpool.demo03.CyclicJudgment.lambda$1(CyclicJudgment.java:57)
				at java.lang.Thread.run(Thread.java:748)
			
			执行结果如上,这是因为wait会释放锁,而notify不会释放锁,线程2先启动,执行到wait后释放锁,线程1开始进入执行,当size()==5时,
			当线程发出通知后,线程2虽然接到通知,但无法获取到lock锁,故等线程1执行后获得锁开始执行线程2的内容

		 */
	}
}
