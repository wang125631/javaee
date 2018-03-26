package com.wpx.test;
/**
 * 判断给定的字符串s1 s2
 * s2是否能够被s1循环移位包含
 * 
 * @author wangpx
 */
public class Test01 {

	public static void main(String[] args) {
		
		String s= new String("ASAC");
		String s2 = new String("SACASAC");
		int s2length = s2.length();
		int slength = s.length();
		
		int num=s2length/slength;
		num+=1;
		StringBuffer sb= new StringBuffer();
		for(int i=0;i<num;i++) {
			sb.append(s);
		}
		System.out.println(isHave(sb.toString(), s2));
	}
	
	private static boolean isHave(String s1,String s2) {
		if(s1.contains(s2)) {
			return true;
		}else {
			return false;
		}
	}
}
