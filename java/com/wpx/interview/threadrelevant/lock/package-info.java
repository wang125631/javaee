/**
 * 并发包下的锁机制
 *  synchronized和lock的区别
 *  	
 *  用法:
 *  	synchronized:在需要同步的对象中加入控制,synchronized可以加在方法上,
 *  	也可以加在特定代码中,括号中表示锁的对象
 *  	lock: 需要显示的指定起始位置和终止位置.一般使用ReentrantLock类为锁,
 *  	多个线程中必须要使用一个ReentrantLock类作为对象才能保证锁的生效
 *  	在加锁和解锁处需要通过lock()和unlock()显示指出,所以通常会在finally中写unlock()防止死锁
 *  性能:
 *  	 synchronized是托管给JVM执行的,而lock是java写的控制锁的代码.
 *  	 synchronized原始使用的是CPU悲观锁机制,即线程获得的是独占锁.
 *  	  独占锁意味着其他线程只能依靠阻塞来等待线程释放锁,会出现锁竞争的问题,
 *  	 会引起CPU频繁的上下文切换导致效率很低
 *  	 lock用的是乐观锁的方式.即每次不加锁而是假设没有冲突去完成某项操作,
 *  	 如果因为冲突就失败,失败就重试,直到成功为止.乐观锁的机制就是CAS操作(Compare and Swap)
 *  	 
 * 
 *  
 *  
 * @author wangpx    
 */
package com.wpx.interview.threadrelevant.lock;