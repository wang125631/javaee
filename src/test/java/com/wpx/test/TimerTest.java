package com.wpx.test;
import java.util.Timer;
import java.util.TimerTask;


public class TimerTest {

	//3秒后执行任务
	public static void main(String[] args) {
		//新建作业类
		Timer timer = new Timer();
		//指定时间作业,3秒后执行,之后每一秒执行一次
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Hello Timer ....");
			}
		}, 3000,1000);
	}
	
}
