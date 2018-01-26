package com.wpx.threadpool.demo04;

/**
 * 
 * 线程局部变量,是一种多线程并发访问变量的解决方案,与synchronized等锁的方式不同
 * ThreadLocal是完全不提供锁的,而使用空间换时间的方式,为每一个线程提供变量的独立脚本,以保证线程的安全
 * 从性能上来讲,ThreadLocal不具有绝对的优势,在并发不是很高的时候,加锁的性能会更好
 * ThreadLocal可以在一定程度上减小锁竞争
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class ThreadLocalTest {

	private static ThreadLocal<String> th = new ThreadLocal();

	public void getTh() {
		System.out.println("线程"+Thread.currentThread().getName()+"  "+ this.th.get());
	}

	public  void setTh(String value) {
		th.set(value);
	}
	 public static void main(String[] args) {
		 
		 ThreadLocalTest tl = new ThreadLocalTest();
	
		 new Thread( () ->  {
			 tl.setTh("wpx");
			 tl.getTh();
		 }).start();
		 	
		 new Thread( () -> {
			 try {
				Thread.sleep(3000);
				tl.getTh();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }) .start();
		 
	 }
	
}
