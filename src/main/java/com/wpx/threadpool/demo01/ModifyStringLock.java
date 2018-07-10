package com.wpx.threadpool.demo01;
/**
 * 
 * 
 * @author wangpx
 */
public class ModifyStringLock {

	private String lock = "lock";
	
	private void method01() {
		synchronized (lock) {
			try {
				//lock = "new lock";
				System.out.println(Thread.currentThread().getName() + "  start ....");
				Thread.sleep(4000);
				System.out.println(Thread.currentThread().getName() + "  end ....");
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ModifyStringLock msl = new ModifyStringLock();
		new Thread( () -> { msl.method01(); },"t1") .start();
		new Thread( () -> { msl.method01(); },"t2") .start();
	}
}
