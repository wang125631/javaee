package com.wpx.threadpool.demo08;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 *  * Executors创建线程池方法
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class ExecutorsTest {

	/**
	 *  	 newFixedThreadPool()方法,该方法返回一定数量的线程池,该方法的线程数始终不变
	 * 当有一个任务提交时 ,若线程池中空闲,则立即执行,若没有,则会被暂缓在一个任务队列中等待空闲的线程执行
	 * @param nThreads
	 */
	@Test
	public void newFixedThreadPoolDemo(int nThread) {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(nThread);
		//new ThreadPoolExecutor(nThread, nThread, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	
	}
	/**
	 *  * newSingleThreadExecutor()方 法,创建一个线程的线程池,若空闲则执行,若没有空闲线程则暂缓在任务队列中
	 */
	@Test
	public void newSingleThreadExcutorTest() {
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		//new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}
	/**
	 *  * newCacheThreadPool()方法,返回一个可根据实际情况调节线程个数的线程池,不限制最大线程数量
	 	* 若有空闲的线程则执行任务,若无则不创建线程并且空闲线程会60秒后自动回收
	 */
	@Test
	public void newCacheThreadPoolTest() {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		//new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
	}
	/**
	 *  * newScheeduledThreadPool(),该方法返回一个 SchedeExecutorService对象
     *    但该线程可以指定线程的数量 corePoolSize
	 */
	@Test
	public void ScheduledThreadPoolTest(int corePoolSize) {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(corePoolSize);
		//DelayQueue队列中对象需要实现Delayed接口
		//new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE, 0, TimeUnit.NANOSECONDS, new DelayQueue<>());
	}
}
