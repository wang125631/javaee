package com.wpx.hibernate.demo07;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wpx.hibernate.demo03.HibernateUtils;


/**
 * 一对一关系映射
 * 
 * @author wangpx
 */
public class Hibernate {

	@Test
	public void demo01() {
		//加载特定的映射文件
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Dep.class,Manager.class);
		//开启session
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction(); 
		

		Manager manager = new Manager("wangpx");
		Dep dep = new Dep("开发部");
		dep.setManager(manager);
		session.save(dep);
		
		
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
