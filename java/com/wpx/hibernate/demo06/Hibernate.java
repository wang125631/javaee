package com.wpx.hibernate.demo06;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wpx.hibernate.demo03.HibernateUtils;
import com.wpx.hibernate.demo05.Customer;
import com.wpx.hibernate.demo05.Order;

/**
 * 多对多关系双向 一方放弃
 * 
 * @author wangpx
 */
public class Hibernate {

	@Test
	public void demo01() {
		//加载特定的映射文件
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Course.class,Student.class);
		//开启session
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction(); 
		
		Student student = new Student("wpx");
		Course course01 = new Course("java");
		Course course02 = new Course("C++");
		HashSet<Course> hashSet = new HashSet<Course>();
		hashSet.add(course01);
		hashSet.add(course02);
		student.setCourses(hashSet);

		session.save(student);
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
}
