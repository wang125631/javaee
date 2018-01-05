package com.wpx.spring.demo18;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext18.xml")
public class SpringTest18 {

	@Resource
	private AccountService accountService;
	
	@Test
	public void demo01() {
		accountService.transfer("wpx", "wangpx", 200d);
	}
}
