package com.wpx.hibernate.demo02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * * Customer customer = session.get(Customer.class ,1);
	* Customer customer = session.load(Customer.class,1);

	***** get 和load的区别:
	* 1.发送SQL的时机:
	* load这个方法采用了一个技术.lazy延迟加载(懒加载).真正使用这个对象的数据的时候.(对象的数据不包括主键).
	* get这个方法是立即检索.当执行session.get()方法的时候,马上发送SQL语句查询.
	
	* 2.返回的对象:
	* load方法返回的是代理对象.
	* get方法返回的是真实的对象.
	
	* 3.查询一个不存在的数据:
	* load方法抛异常:ObjectNotFoundException.
	* get方法抛异常:NullPointException./ 5版本返回null不会抛异常
	 
	1.加载核心配置文件:
		核心配置有两种:
		* hibernate.properties:
		* 加载:
		* Configuration configuration = new Configuration();
		* hibernate.cfg.xml:
		* 加载:
		* Configuration configuration = new Configuration().configure();
		
	2.加载映射文件:
		* 第一种写法:
		* configuration.addResource("Customer.hbm.xml");
		* 第二种写法:(要求:映射文件名称要规范,类与映射在同一个包下)
		* configuration.addClass(Customer.class);


	
 * 
 * @author wangpx
 */
public class Hibernate02 {

	//通过get
	@Test
	public void demo01() {
		//读取配置文件
		Configuration configure = new Configuration().configure("hibernate.cfg.xml").addClass(Customer.class);
		//注册标准服务
		StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
		//通过配置文件创建SessionFactory
		SessionFactory sessionFactory = configure.buildSessionFactory(build);
		//开启session 相当于jdbc中Connection
		Session session = sessionFactory.openSession();
		//开启事务
		session.beginTransaction();
		
		/**
		 * org.hibernate.ObjectNotFoundException: No row with the given identifier 
		 * exists: [com.wpx.hibernate.demo01.Customer#100]
		 */
		Customer customer = session.get(Customer.class, 100);
		System.out.println(customer);
		
		
		
		//提交事务
		session.getTransaction().commit();
		//关闭资源
		session.close();
		sessionFactory.close();
	}
	//通过load方法
	@Test
	public void demo02() {
		//读取配置文件
		Configuration configure = new Configuration().configure("hibernate.cfg.xml").addResource("Customer01.hbm.xml");
		//注册标准服务
		StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build();
		//通过配置文件创建SessionFactory
		SessionFactory sessionFactory = configure.buildSessionFactory(build);
		//开启session 相当于jdbc中Connection
		Session session = sessionFactory.openSession();
		//开启事务
		session.beginTransaction();
		
		Customer customer = session.load(Customer.class, 100);
		System.out.println(customer);
		
		//提交事务
		session.getTransaction().commit();
		//关闭资源
		session.close();
		sessionFactory.close();
	}
}
