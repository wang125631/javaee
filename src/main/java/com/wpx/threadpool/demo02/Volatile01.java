package com.wpx.threadpool.demo02;
/**
 * volatile关键字使变量在多线程之间可见
 * 
 * @author wangpx
 */
public class Volatile01 extends Thread {

	/**
	 * 不设置volatile,运行结果:
	 
	         运行状态设置为了false
      false
	因为 isRunning变量虽然已经修改为false,但线程所持有的变量并没有发生改变,因为线程间是相关不可见的
	
	
		通过volatile修饰会使线程相互可见
	 */
	private volatile boolean isRunning = true;


	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void run() {
		while(isRunning == true) {
			
		}
		System.out.println("线程执行完毕....");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Volatile01 v = new Volatile01();
		v.start();
		Thread.sleep(2000);
		v.setRunning(false);
		
		System.out.println("运行状态设置为了false");
		Thread.sleep(3000);
		System.out.println(v.isRunning);
	}
	
}
