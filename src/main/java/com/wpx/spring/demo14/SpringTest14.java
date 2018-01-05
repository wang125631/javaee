package com.wpx.spring.demo14;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * 
 * @author wangpx
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext14.xml")
public class SpringTest14 {
	
	@Resource
	private PersonDao personDao;
	
	@Test
	public void demo01() {
		personDao.add();
		personDao.delete();
		personDao.update();
		personDao.find();
		personDao.ex();
	}
}
