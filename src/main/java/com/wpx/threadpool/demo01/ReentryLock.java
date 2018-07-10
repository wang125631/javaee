package com.wpx.threadpool.demo01;
/**
 * ÖØÈëËø
 * 
 * @author wangpx
 */
public class ReentryLock {

	public synchronized void method01() {
		System.out.println("method01.....");
		method02();
	}
	public synchronized void method02() {
		System.out.println("method02.....");
		method03();
	}
	public synchronized  void method03() {
		System.out.println("method03.....");
	}
	
	public static void main(String[] args) {
		final ReentryLock rl = new ReentryLock();
		new Thread(() -> {rl.method01();} ) .start();
	}
}
