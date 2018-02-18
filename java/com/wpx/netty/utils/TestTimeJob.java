package com.wpx.netty.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 
 * 新建线程
 * 创建一个任务线程池
 * 
 * 
 * @author wangpx
 */
class Task extends Thread{
	@Override
	public void run() {
		System.out.println("任务方法执行...");
	}
}
public class TestTimeJob {

	public static void main(String[] args) {
		Task task = new Task();
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		/**
		 *  4个参数
		 *  task:一个任务,需要成为一个线程
		 *  1:第一次执行时间
		 *  2:没个几秒执行一次
		 *  TimeUnit.SECONDS: 时间度量单位
		 */
		scheduler.scheduleWithFixedDelay(task, 1, 3, TimeUnit.SECONDS);
	}
}
