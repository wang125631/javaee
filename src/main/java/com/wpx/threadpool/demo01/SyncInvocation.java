package com.wpx.threadpool.demo01;
/**
 * 
 * 同步:synchronized
 *  同步的概念就是共享 对于共享的资源   保证线程的原子性和互可见性
 *  异步:asynchronized
 *  异步的概念为独立,相互之间不受到任何的制约
 * @author wangpx
 */
public class SyncInvocation {

	public synchronized  void method01() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/** 不加synchronized  t1,t2会同时打印,t1线程先持有d的对象锁,t2线程可以以异步的方式去调用对象中没有用synchronized修饰的方法
	 * 加synchronized   t1, 等待4秒 t2 t1先获得d的对象锁,t2线程需要等待锁,也就是会同步
	 **/
	public synchronized void method02() {
		System.out.println(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		final SyncInvocation si=new SyncInvocation();
		Thread t1 = new Thread( () -> { si.method01(); } ,"t1") ;
		Thread t2 = new Thread( () -> { si.method02(); } ,"t2") ;
		t1.start();
		t2.start();
	}
}
