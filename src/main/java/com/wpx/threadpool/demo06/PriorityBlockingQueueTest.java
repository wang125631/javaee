package com.wpx.threadpool.demo06;
/**
 * 
 * PriorityBlockingQueue:是一种基于优先级的阻塞队列,
 * 优先级的判断通过函数传入的Compator对象来决定,也就是说传入队列的对象必须实现Comparae接口
 * 在实现priorityBlockingQueue时,内部控制线程同步采用的锁是公平锁,是一个无界队列
 * 
 * @author wangpx
 */
public class PriorityBlockingQueueTest {

}
class Student implements Comparable<Student>{

	private int id;
	private String name;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	@Override
	public int compareTo(Student student) {
		return this.id > student.id ? 1 :(this.id <student.id ? -1 :0);
	}
	
}
 