package com.wpx.spring.demo09;
/**
 * 被代理对象具体实现
 * @author wangpx
 */
public class UserDaoImpl implements UserDao{

	public void add() {
		System.out.println("add method ...");
	}

	public void update() {
		System.out.println("update method ...");
	}

}
