package com.wpx.threadpool.demo01;
/**
 * 线程中的脏读
 * 
 * 
 * 线程安全概念: 当多个线程访问某一个类(对象或方法)的时候,这个类始终都能  做出正确的行为,
 * 那么这个类(对象或是方法)就是线程安全的               
 *    synchronized:可以在任意的对象或是方法上加锁,而加锁的这段代码称为"互斥区"                
 *             
 *             
 *    当多个线程访问Thread的run方法时,会以排队的方式等待cpu调度,一个线程要想执行synchronized修饰的方法里的代码,
 *    首先要尝试获得这把锁
 *     多个线程去获取锁,同样也会出现锁竞争的问题    
 *     
 *   
 * 
 * @author wangpx
 */
public class DirtyRead {

	private  String username="wpx";
	private  String password="123";

	/**
	 * 
		只在setValue上加synchronized关键字
		username is : wangpx and password is 123
		setValue方法得到的:username= wangpx  123456
	 */
	public  synchronized  void setValue(String username,String password) {
		this.username=username;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.password=password;
		System.out.println("setValue方法得到的:username= "+this.username+"  "+this.password);
	}
	/**
	 * 当前代码运行结果
	 * setValue方法得到的:username= wangpx  123456
		username is : wangpx and password is 123456
	 * 
	 */
	public synchronized void getValue() {
		System.out.println("username is : "+username+ " and password is "+password);
	}
	
	public static void main(String[] args) throws InterruptedException {
		DirtyRead dr=new DirtyRead();
		
		Thread t1 = new Thread( () -> {dr.setValue("wangpx", "123456"); } );
		t1.start();
		/**
		
		setValue 与 getVlaue 均不加synchronized关键字
		username is : wangpx and password is 123
		setValue方法得到的:username= wangpx  123456
				 */
		Thread.sleep(1000);
		dr.getValue();
	}
}
