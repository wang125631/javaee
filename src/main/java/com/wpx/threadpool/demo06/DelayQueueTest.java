package com.wpx.threadpool.demo06;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *  DelayQueue带有延迟时间的Queue,其中的元素只有当指定的延迟时间到了,才能够从队列中获取到该元素
 	DelayQueue中的元素必须实现Dalayed接口
 	DelayQueue没有大小限制
 	DelayQueue应用场景: 对缓存超时的数据移除,任务超时处理,空闲连接的关闭
 	
 * 
 * @author wangpx
 */
public class DelayQueueTest implements Runnable{

	private DelayQueue<WangMin> queue =new DelayQueue<WangMin>();
	private boolean yingye=true;
	
	public void shangji(String name,Integer id,int money) {
	
		WangMin wangMin = new WangMin(id, name, 1000*money+System.currentTimeMillis());
		System.out.println("网名为"+wangMin.getName()+" 身份证为 "+wangMin.getId()+" 交钱 "+money+" 块开始上网");
		this.queue.add(wangMin);
	}
	public void xiaji(WangMin wangMin) {
		System.out.println("网名为 "+wangMin.getName()+" 身份证为 "+wangMin.getId()+" 下机了 ");
	}
	
	@Override
	public void run() {
		while(yingye) {
			try {
				WangMin wangMin = queue.take();
				xiaji(wangMin);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("网吧开始营业....");
		DelayQueueTest dq = new DelayQueueTest();
		Thread shangwang = new Thread(dq);
		shangwang.start();
		dq.shangji("wangpx", 1, 1);
		dq.shangji("wpx", 2, 2);
		
	}
}
/**
 * 网民实体类
 * 
 * @author wangpx
 */
class WangMin implements Delayed{

	private Integer id;
	private String name;
	private long endTime;
	private TimeUnit timeUnit=TimeUnit.SECONDS;
	public WangMin() {
	}
	public WangMin(Integer id, String name, long endTime) {
		super();
		this.id = id;
		this.name = name;
		this.endTime = endTime;
	}


	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@Override
	public int compareTo(Delayed delayed) {
		WangMin wangMin = (WangMin) delayed;
		return this.getDelay(this.timeUnit) - wangMin.getDelay(this.timeUnit) > 0 ? 1 :0 ;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return endTime - System.currentTimeMillis() ;
	}
	
}