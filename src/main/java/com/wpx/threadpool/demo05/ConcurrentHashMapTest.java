package com.wpx.threadpool.demo05;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 *  同步类容器:如Vector,HashTable这些容器的同步功能其实都是JDK的Collections,synchronized等工厂方法创建实现
 * 
 *  同步类容器都是线程安全的,但某些场景下需要加锁保护复合操作
 *  如:迭代(反复访问元素,遍历完容器中的所有元素)
 *  跳转(根据当前元素按照特定顺序去查找下一个元素)
 * 
 *  ConcurrentMap接口有两个重要的实现
 *	ConcurrentHashMap
 *  ConcurrentSkipListMap (支持并发排序功能,弥补ConcurrentMapHashMap)
 * 
 *  ConcurrentHashMap内部使用断来表示这些不同的部分,每个段其实就是一个小的HashTale他们有自己的锁
 *  只要多个修改操作发生在不同的段上,他们就可以并发的记性,把一个整体分成了16个段,也就是最高支持16个线程的并发修改操作
 *  这也是在多线程场景时减少锁粒度从而降低锁竞争的一种方案,将大多共享变量使用volatile关键字声明,进而实时的获得修改的内容
 * 
 * @author wangpx
 */
public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		//创建ConcurrentHashMap
		ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String,Object>();
		//向concurrentHashMap中添加元素
		concurrentHashMap.put("key01", "value01");
		//如果key01不存在则添加,否则添加
		concurrentHashMap.putIfAbsent("key01", "value值");
		//遍历concurrentHashMap
		for(Map.Entry<String,Object> m : concurrentHashMap.entrySet() ) {
			System.out.println("key is "+m.getKey() +" and value is "+m.getValue());
		}
	}
}
