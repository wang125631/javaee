package com.wpx.threadpool.demo06;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 
 * PriorityBlockingQueue:是一种基于优先级的阻塞队列,
 * 优先级的判断通过函数传入的Compator对象来决定,也就是说传入队列的对象必须实现Comparae接口
 * 在实现priorityBlockingQueue时,内部控制线程同步采用的锁是公平锁,是一个无界队列
 * 
 * @author wangpx
 */
public class PriorityBlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		//创建priorityBlockingQueue对象
		PriorityBlockingQueue<Student> priorityBlockingQueue = new PriorityBlockingQueue<Student>();
		Student s1 = new Student(2, "wpx2");
		Student s2 = new Student(12, "wpx12");
		Student s3 = new Student(23, "wpx23");
		Student s4 = new Student(26, "wpx26");
		Student s5 = new Student(82, "wpx82");
		Student s6 = new Student(52, "wpx52");
		
		priorityBlockingQueue.add(s1);
		priorityBlockingQueue.add(s2);
		priorityBlockingQueue.add(s3);
		priorityBlockingQueue.add(s4);
		priorityBlockingQueue.add(s5);
		priorityBlockingQueue.add(s6);
		
		priorityBlockingQueue.stream()
							 .map( (e) -> e.getName())
							 .forEach(System.out::println);
		System.out.println("-----------------------");
		int size = priorityBlockingQueue.size();
		for(int i=0;i<size;i++) {
			System.out.println(priorityBlockingQueue.take().getName());
		}
	}
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
 