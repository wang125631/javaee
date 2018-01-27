package com.wpx.threadpool.demo07;
/**
 * 
 * @author wangpx
 */
public class Main {

	public static void main(String[] args) {
		Master master = new Master(new Worker(), 10);
		for(int i=0;i<101;i++) {
			Task task = new Task();
			task.setId(i);
			task.setTaskName("task"+i);
		}
		master.execute();
		long start = System.currentTimeMillis();
		while(true) {
			if(master.isComplete()) {
				long result = System.currentTimeMillis()-start;
				System.out.println(result);
				master.getResult().stream().forEach(System.out::print);
				break;
			}
		}
	}
}
