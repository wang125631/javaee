package com.wpx.threadpool.demo01;
/**
 * synchronized遇上异常,自动释放锁
 * 
 * @author wangpx
 */
public class Exception {
	private  int  i=0;
	
	public synchronized void operation() {
		while(true) {
			try {
				i++;
				System.out.println(Thread.currentThread().getName()+" ,i= "+i);
				Thread.sleep(100);
				if(i == 10) {
					Integer.parseInt("a");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Exception e=new Exception();
		new Thread( () -> {e.operation();}) .start();;
	}
}
