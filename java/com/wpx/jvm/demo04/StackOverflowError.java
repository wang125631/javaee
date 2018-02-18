package com.wpx.jvm.demo04;
/**
 * 
 * -Xss 栈参数
 * 
 * @author wangpx
 */
public class StackOverflowError {
		//-Xss1m  调用最大深入：22257
		//-Xss5m  调用最大深入：64995
		
		//栈调用深度
		private static int count;
		
		public static void recursion(){
			count++;
			recursion();
		}
		public static void main(String[] args){
			try {
				recursion();
			} catch (Throwable t) {
				System.out.println("调用最大深入：" + count);
				t.printStackTrace();
			}
	}
}
