package com.wpx.threadpool.demo01;
/**
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class ThreadLock {

	private static int number =0;
	
	/**
	 *  
	 *  
	 	不加static下面两句同时打印,也就意味着两个线程同时进入方法中
	 	这个创建了两个对象,每个对象一把锁
	 	
	 	加static修饰后,只有一个线程进入了方法中,
	 	即静态方法上的锁为类级别的锁,无论实例创建多少都只有一把锁

	 */
	public static synchronized void printNum(String num) {
		try {
			if(num.equals("a")) {
				number=100;
				System.out.println("num a,set num over!");
				Thread.sleep(2000);
			}else {
				number=200;
				System.out.println("num b,set num over!");
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			new RuntimeException("出现异常");
		}
	}
	
	public static void main(String[] args) {
		
		final ThreadLock tl01 = new ThreadLock();
		final ThreadLock tl02 = new ThreadLock();
		Thread t1 =new Thread( () -> { tl01.printNum("a"); });
		Thread t2=new Thread( () -> { tl02.printNum("b"); });
		
		t1.start();
		t2.start();
		
		
		
	}
}
