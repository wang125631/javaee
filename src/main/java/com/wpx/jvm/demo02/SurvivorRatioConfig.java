package com.wpx.jvm.demo02;
/**
 * 
 * SurivorRatio的配置
 * 
 * -Xmn:可以设置新生带的大小( new generation ),新生代的gc比较频繁,一般设置为整个堆空间的1/3到1/4左右 
 *  -XX:SurvlvoRatio:用来设置新生代中eden空间和form/to空间的比例 
    -XX:SurvivorRatio=eden/from=eden/to 
    -XX:+printGC 遇到Gc就打印
    
    from和to是大小想到的两块区域
    
	     不同的堆分布情况,对系统执行会产生一定的影响,在实际工作中,应该根据系统的特点做出合理的配置 
	    基本策略:尽可能将对象预留在新生带,减少老年代的GC次数 
	    除了可以设置新生带的绝对大小(-Xmn)还可以使用-XX:NewRatio 
	    新生代和老年代的比例
   
 * 
 * @author wangpx
 */
public class SurvivorRatioConfig {

	public static void main(String[] args) {
		// 第一次配置
		//-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC  

		//第二次配置 增大新生代
		//-Xms20m -Xmx20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		

		//第三次配置
		//-Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		
		byte[] b=null;
		for(int i=0;i<10;i++) {
			b=new byte[1024*1024];
		}
		
	}
}
