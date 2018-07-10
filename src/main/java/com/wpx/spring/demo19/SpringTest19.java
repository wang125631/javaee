package com.wpx.spring.demo19;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext19.xml")
public class SpringTest19 {
	
	@Autowired
	@Qualifier("transactionProxy")
	private AccountService accountService;
	
	@Test
	public void demo01() {
		accountService.transfer("wpx", "wangpx", 200d);
	}
}
