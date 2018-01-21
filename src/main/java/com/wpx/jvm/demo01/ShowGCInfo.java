package com.wpx.jvm.demo01;
/**
 * 
 * -Xms5m -- 设置java程序启动时的初始堆大小为5m
 * -Xmx20m -- 设置java程序能获得的最大堆大小为20m
 * -XX:+PrintGCDetails -- 打印GC详情信息
 * -XX:+UseSeriaiGC -- 配置串行回收器
 * -XX:+PrintCommandLineFlags -- 可以将隐式或者显示传给虚拟机的参数输出 
 * 查看GC信息
 * @author wangpx
 */
public class ShowGCInfo {
	//-Xms5m -Xmx20m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags

	public static void main(String[] args) {
		 System.out.println("maxMemory: "+Runtime.getRuntime().maxMemory());  
	        System.out.println("freeMemory: "+Runtime.getRuntime().freeMemory());  
	        System.out.println("totalMemory"+Runtime.getRuntime().totalMemory());  
	          
	        byte[] b1=new byte[1*1024*1024];  
	        System.out.println("分配了1M内存");  
	        System.out.println("maxMemory: "+Runtime.getRuntime().maxMemory());  
	        System.out.println("freeMemory: "+Runtime.getRuntime().freeMemory());  
	        System.out.println("totalMemory"+Runtime.getRuntime().totalMemory());  
	      
	        byte[] b2=new byte[(int) (4.5*1024*1024)];  
	        System.out.println("分配了4.5M内存");  
	        System.out.println("maxMemory: "+Runtime.getRuntime().maxMemory());  
	        System.out.println("freeMemory: "+Runtime.getRuntime().freeMemory());  
	        System.out.println("totalMemory"+Runtime.getRuntime().totalMemory());  
	}
}
