package com.wpx.hibernate.demo03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 三种持久态说明
 * 
 * 
 * OID	纳入到session管理	对象的状态
 *  无		否			   瞬时态
 *  有		是			   持久态			 
 *  有		否			   游离态
 * 
 * 
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class Hibernate03 {

	@Test
	public void demo01() {
		//加载配置文件
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addClass(Student.class);
		//注册标准服务
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		//通过配置获取sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//通过sessionFactory 获取Session
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		/**
		 * 通过session对数据库进行操作
		 */
		Student student =new Student(1, "wangpx", 22);  //瞬时态 seesion操作前
		session.save(student);//持久态 session操作时  持久态有改变数据库的能力
		
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
		
		student.setAge(student.getAge()+1);  //托管态(游离态) session操作后
	}
}
