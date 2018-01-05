package com.wpx.spring.demo11;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author wangpx
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest11 {

	@Autowired(required=true)
	@Qualifier("customerDaoProxy")
	private CustomerDao customerDao;
	@Test
	public void demo01() {
		customerDao.add();
		customerDao.delete();
		customerDao.update();
		customerDao.find();
	}
}
