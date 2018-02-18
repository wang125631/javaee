package com.wpx.threadpool.demo07;
/**
 *定义任务类
 * 
 * @author wangpx
 */
public class Task {

	private Integer id;
	private String taskName;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

}
