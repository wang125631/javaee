package com.wpx.threadpool.demo07;
/**
 *定义工作类
 * 
 * @author wangpx
 */

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable{

	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String,Object> resultMap;
	public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.workQueue = workQueue;
	}
	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	@Override
	public void run() {
		while(true) {
			Task input = this.workQueue.poll();
			if(input == null) {
				break;
			}
			Object output = handler(input);
			this.resultMap.put(Integer.toString(input.getId()), output);
		}
	}
	
	public Object handler(Task input) {
		Object output = null;
		try {
			//模拟义务处理
			Thread.sleep(1000);
			output=input.getTaskName();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return output;
	}
	
}
