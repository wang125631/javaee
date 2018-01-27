package com.wpx.hibernate.demo05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import com.wpx.hibernate.demo03.HibernateUtils;
/**
 * Hibernate中关系映射一对多 双向关联
 * 
 * @author wangpx
 */
public class Hibernate {

	/**
	 * 测试级联属性,保存订单时将用户也保存
	 * 
	 */
	@Test
	public void demo01() {
		//加载指定的映射文件
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Customer.class,Order.class);
		//使用sessionSessionFactory开启session
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction(); 
		
		Customer customer = new Customer("wangpx", 21);
		Order order = new Order("GuangDong", customer);
		session.save(order);
		
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
	/**
	 * 测试级联delete 删除客户时将其订单也删除
	 */
	@Test
	public void demo02() {
		//加载指定的映射文件
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Customer.class,Order.class);
		//使用sessionSessionFactory开启session
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction(); 
		
		Customer customer = session.get(Customer.class, 1);
		session.delete(customer);
		
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	} 
}
