package com.wpx.hibernate.demo01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
/**
 * 主程序
 * 通过hibernate学会基础面向对象的增删改查
 * @author wangpx
 */
public class Hibernate01 {
	//添加客户
	@Test
	public void demo01() {
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
		
		Customer customer=new Customer(); 
		customer.setAge(21);
		customer.setName("wpx");
		session.save(customer);
		
		//提交事务
		session.getTransaction().commit();
		//关闭资源
		session.close();
		sessionFactory.close();
	}
		//查找客户
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
			
			Customer customer = session.get(Customer.class, 1);
			System.out.println(customer);
			
			//提交事务
			session.getTransaction().commit();
			//关闭资源
			session.close();
			sessionFactory.close();
		}
			//修改客户
			@Test
			public void demo03() {
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
				
				Customer customer = session.get(Customer.class, 1);
				System.out.println(customer);
				customer.setAge(customer.getAge()+1);
				session.save(customer);
				
				//提交事务
				session.getTransaction().commit();
				//关闭资源
				session.close();
				sessionFactory.close();
			}
			//删除客户
			@Test
			public void demo04() {
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
				
				Customer customer = session.get(Customer.class, 1);
				if(customer!=null) {
					try {
						session.delete(customer);
						System.out.println("删除成功");
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("删除失败");
					}
				}
				
				//提交事务
				session.getTransaction().commit();
				//关闭资源
				session.close();
				sessionFactory.close();
			}
}
