package com.wpx.spring.demo21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext21.xml")
public class SpringTest21 {

	@Autowired
	private AccountService accountService;
	
	@Test
	public void demo01() {
		accountService.transfer("wpx", "wangpx", 200d);
	}
}
