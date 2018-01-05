package com.wpx.spring.demo13;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext13.xml")
public class SpringTest13 {

	@Resource
	private UserDao userDao;
	
	@Test
	public void demo01() {
		userDao.add();
		userDao.delete();
		userDao.update();
		userDao.find();
	}
}
