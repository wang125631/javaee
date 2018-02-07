package com.wpx.test;
/**
 * instanceof
 * ≤‚ ‘
 * 
 * @author wangpx
 */
public class InstanceofTest {

	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new  Child();
		System.out.println(c instanceof Child);
		System.out.println(c instanceof Parent);
		System.out.println(p instanceof Child);
	}
	
}

class Parent{
	
}
class Child extends Parent{
	
}