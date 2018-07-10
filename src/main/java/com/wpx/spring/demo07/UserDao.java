package com.wpx.spring.demo07;

import org.springframework.stereotype.Repository;
/**
 * 将UserDao装配成一个bean
 * 
 * @author wangpx
 */
@Repository("userDao")
public class UserDao {
	
	public void say() {
		System.out.println("say hello...");
	}
	
}
