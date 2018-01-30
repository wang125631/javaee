package com.wpx.netty.demo02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;



/**
 * 线程池处理类
 * 
 * @author wangpx
 */
public class ExecutorPoolHandler {

	private ExecutorService executorService;

	public ExecutorPoolHandler(int maxPoolSize,int workQueueSize) {
		this.executorService=new ThreadPoolExecutor(
				Runtime.getRuntime().availableProcessors(),
				maxPoolSize,
				120L,
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(workQueueSize));
	}
	
	public void execute(Runnable task) {
		this.executorService.execute(task);
	}
	
}
