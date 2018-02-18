package com.wpx.hibernate.demo08;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wpx.hibernate.demo03.HibernateUtils;

/**
 * 
 * 
 * @author wangpx
 */
@SuppressWarnings("unchecked")
public class Hibernate02 {

	SessionFactory sessionFactory=null;
	Session session=null;
	Transaction transaction=null;
	
	@Before
	public void before() {
		//加载指定的映射文件
		 sessionFactory = HibernateUtils.getSessionSessionFactory(Customer.class,Order.class);
		//使用sessionSessionFactory开启session
		 session = sessionFactory.openSession();
		//开启事务
		 transaction = session.beginTransaction(); 
	}
	@After
	public void after() {
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
	
	
	/*
	 * <set>没有配置fetch 和lazy情况
	 */
	@Test
	public void demo01() {
		Customer customer = session.get(Customer.class, 1);//发送查询客户的SQL
		System.out.println(customer.getOrders().size()); //再次发送一条SQL
	}
	
	/**
	 * <set>配置fetch="join" lazy会被忽略
	 * 
	 */
	@Test
	public void demo02() {
		Customer customer = session.get(Customer.class, 1);
		System.out.println(customer.getOrders().size());
	}
	
	/*
	 * 	 在<set>集合上配置
	 * 	 fetch="select" lazy="true"
	 * 	 lazy:true-使用延迟检索 
	 * 	 发送多条SQL,查询关联对象
	 */
	@Test
	public void demo03() {
		Customer customer = session.get(Customer.class, 1);
		System.out.println(customer.getOrders().size());
	}

	 /**
	 * 在<set>集合上配置
	 * 	 fetch="select" lazy="false"
	 * 	 lazy:false:关联对象的检索不使用延迟
	 */

	@Test
	public void demo04() {
		Customer customer = session.get(Customer.class, 9);
		System.out.println(customer.getOrders().size());
	}
	
	/**
	 * 批量抓取
	 * 	通过订单批量抓取客户:
	 * 		需要在客户一端<class>标签上配置batch-size
	 */
	@Test
	public void demo05() {
		List<Order> list = session.createQuery("from Order").list();
		for(Order order : list) {
			System.out.println(order.getCustomer().getName());
		}
	}
	
	/**
	 * 批量抓取
	 * 在客户一端配置
	 * <set> 集合上配置batch-size="3"
	 */
	@Test
	public void demo06() {
		List<Customer> list = session.createQuery("from Customer").list();
		for(Customer c :list) {
			for(Order o: c.getOrders()) {
				System.out.println(o.getAddr());
			}
		}
	}
	
	/**
	 * 
	 * 在<many-to-one> 标签上配置
	 * fetch="select" lazy="proxy"
	 */
	@Test
	public void demo07() {
		Order order = session.get(Order.class,1);
		System.out.println(order.getCustomer().getName());
	}
	
	
}
