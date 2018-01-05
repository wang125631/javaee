package com.wpx.spring.demo16;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext16.xml")
public class SpringTest16 {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void demo01() {
		
	}
	
}
