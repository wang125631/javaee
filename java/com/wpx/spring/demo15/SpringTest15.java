package com.wpx.spring.demo15;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext15.xml")
public class SpringTest15 {
	
	@Resource
	private StudentDao studentDao;
	
	@Test
	public void demo01() {
		studentDao.add();
	}
}
