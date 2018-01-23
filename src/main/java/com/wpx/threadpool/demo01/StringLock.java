package com.wpx.threadpool.demo01;
/**
 * 尽量不要用String常量作为锁,会出现死循环的问题
 * 
 * 
 * @author wangpx
 */
public class StringLock {

	public void method01() {
		/**
		 * 将new String("字符串常量") 直接替换为一个字符串常量试试
		 */
		synchronized (new String("字符串常量")) {
			try {
				while(true) {
					System.out.println(Thread.currentThread().getName()+" start ...");
					Thread.sleep(1000);
					System.out.println(Thread.currentThread().getName()+" end ...");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		final StringLock sl = new StringLock();
		new Thread( () -> { sl.method01(); },"t1") .start();
		new Thread( () -> { sl.method01(); },"t2") .start();
	}
}
