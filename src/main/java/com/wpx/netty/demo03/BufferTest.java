package com.wpx.netty.demo03;
import java.nio.IntBuffer;

import org.junit.Test;
/**
 * 缓冲区:原来传输为直连传输,先新增加入缓冲区,
 * 
 * @author wangpx
 */
public class BufferTest {

	/**
	 * buffer的结构
	 */
	@Test
	public void demo01() {
		//创建指定长度的缓冲区
		IntBuffer buffer =IntBuffer.allocate(10);
		buffer.put(12); //position的位置 : 0 -> 1
		buffer.put(21); //position的位置 :	1 -> 2
		buffer.put(33); //position的位置: 2 -> 3
		//将position的位置复位为0 
		System.out.println("复位前"+buffer);
		buffer.flip();
		System.out.println("复位后"+buffer);
	}
	
	@Test
	public void demo02() {
		//创建指定长度的缓冲区
		IntBuffer buffer =IntBuffer.allocate(10);
		buffer.put(12); //position的位置 : 0 -> 1
		buffer.put(21); //position的位置 :	1 -> 2
		buffer.put(33); //position的位置: 2 -> 3
		
		buffer.flip();
		System.out.println("获取下标为1 的元素 "+buffer.get(1));
		System.out.println("get(index方法)方法,position位置不改变"+buffer);
		buffer.put(1, 4);
		System.out.println("put(index,change)方法,position位置不变"+buffer);
	}
	/**
	 * get(index)
	 * put(index,change)
	 * get()
	 */
	@Test
	public void demo03() {
		//创建指定长度的缓冲区
		IntBuffer buffer =IntBuffer.allocate(10);
		buffer.put(12); //position的位置 : 0 -> 1
		buffer.put(21); //position的位置 :	1 -> 2
		buffer.put(33); //position的位置: 2 -> 3
		
		buffer.flip();
		for(int i=0;i<buffer.limit();i++) {
			//调用get方法会使其缓冲区位置(position)向后递增一位
			System.out.println(buffer.get()+"\t");
		}
		System.out.println("buffer对象遍历之后为: "+buffer);
	}
	
	/**
	 * wrap方法
	 * wrap方法会包裹一个数组,warp方法修改缓冲区对象的时候,数组本身也会跟着发生变化
	 * 
	 */
	@Test
	public void demo04(){
		//新建一数组
		int[] arr =new int[] {1,2,3};
		IntBuffer buffer = IntBuffer.wrap(arr);
		System.out.println(buffer);
		
		IntBuffer buffer2 = IntBuffer.wrap(arr, 0, 2);
		System.out.println(buffer2);
	}
	/**
	 * 其他方法
	 * 
	 */
	@Test
	public void demo05() {
		IntBuffer buffer = IntBuffer.allocate(10);
		int[] arr = new int[] {1,2,3,4};
		buffer.put(arr);
		System.out.println(buffer);
		//一种复制的方法
		IntBuffer buffer2 = buffer.duplicate();
		System.out.println(buffer2);
		
		//设置buffer的位置属性
		buffer.position(0);
		System.out.println(buffer);
		buffer2.flip();
		System.out.println(buffer2);
	
		
		System.out.println("可读数据为"+buffer.remaining());
		System.out.println("可读数据为"+buffer2.remaining());
		
		
	}
	
	
}
