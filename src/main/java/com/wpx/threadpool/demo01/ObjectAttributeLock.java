package com.wpx.threadpool.demo01;
/**
 * 
 * 对象属性的修改不会影响锁本身
 * 
 * @author wangpx
 */
public class ObjectAttributeLock {

	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public synchronized void changeAttribute(String name,int age) {
		try {
			System.out.println("当前线程 "+Thread.currentThread().getName()+ " 开始执行....");
			this.setAge(age);
			this.setName(name);
			Thread.sleep(3000);
			System.out.println("当前线程"+Thread.currentThread().getName()+" 执行完毕.....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		final ObjectAttributeLock oal = new ObjectAttributeLock();
		new Thread( () -> { oal.changeAttribute("wangpx", 21); }) .start();
		Thread.sleep(3000);
		new Thread( () -> { oal.changeAttribute("wangpx", 22); }) .start();
	}
	
	
}
