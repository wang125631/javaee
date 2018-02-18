package com.wpx.threadpool.demo07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *  *  Master-Worker模式
 *  Master-Worker模式是常用的并行计算模式,核心思想是由两类进程协作工作Master和Worker
 *  
 * @author wangpx
 */
public class Master {

	//承装任务的集合
	private ConcurrentLinkedQueue<Task> workQueue=new ConcurrentLinkedQueue<>();
	//所有的work对象
	private HashMap<String,Thread> works = new HashMap<>();
	//work执行任务的结果集
	private ConcurrentHashMap<String,Object> resultMap= new ConcurrentHashMap<>();
	//一个构造方法来统计worker
	public Master(Worker worker,int workCount) {
		worker.setWorkQueue(this.workQueue);
		worker.setResultMap(this.resultMap);
		for(int i=0;i<workCount;i++) {
			works.put("节点"+Integer.toString(i), new Thread(worker));
		}
	}
	
	//提交方法 工作队列添加任务
	public void submit(Task task) {
		this.workQueue.add(task);
	}
	//执行方法 让所有的Worker工作
	public void execute() {
		for(Map.Entry<String,Thread> m: works.entrySet()) {
			m.getValue().start();
		}
	}
	//判断所有线程是否执行完毕
	public boolean isComplete() {
		for(Map.Entry<String, Thread> m : works.entrySet()) {
			if( m.getValue().getState() != Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}
	public List<Object> getResult(){
		List<Object> list=new ArrayList<>();
		for(Map.Entry<String,Object> m: resultMap.entrySet()) {
			list.add(m);
		}
		return list;
	}
	
}
