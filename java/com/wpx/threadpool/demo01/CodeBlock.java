package com.wpx.threadpool.demo01;
/**
 * 代码块
 * 
 * @author wangpx
 */
public class CodeBlock {

	public void method01() {
		synchronized (this) { 			//对象锁
			try {
				System.out.println("method01 ......");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void method02() {
		synchronized (CodeBlock.class) {  //类锁
			try {
				System.out.println("method02 .....");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private Object lock = new Object();
	
	public void method03() {
		synchronized (lock) {
			try {
				System.out.println("method03 ......");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		final CodeBlock cb=new CodeBlock();
		 new Thread( () ->  { cb.method01();},"t1").start();
		 new Thread( () ->  { cb.method02();cb.method02();},"t2").start();
		 new Thread( () ->  { cb.method03();},"t3").start();
		 
	}
	
}
