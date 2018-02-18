package com.wpx.hibernate.demo04;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.wpx.hibernate.demo03.HibernateUtils;

/**
 * Hibernate 一级缓存
 * 
 * 	缓存就是将数据库/硬盘文件中的数据,放入缓存(就是内存中的一块空间),当再次使用的时候,就可以从内存中获取
 * 	
 * 	缓存的好处: 提升程序的效率,缓存技术是Hibernate的一个优化手段
 * 	
 * 一级缓存为session级别的缓存,一级缓存与sessio的生命周期一致,自带的不可卸载
 * 
 * 
 * 
 * @author wangpx
 */
public class Hibernate04 {

	//插入一条数据
	@Test
	public void demo01() {
		//通过特定类指定映射配置文件
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Person.class);
		//开启Session
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		Person p =new Person(1, "wnagpx", 22);
		session.save(p);
		
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
	
	
	//查询两次查看sql的执行次数
	@Test
	public void demo02() {
		//通过特定类指定映射配置文件
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Person.class);
		//开启Session
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		Person person = session.get(Person.class, 1);
		System.out.println(person);
		Person person2 = session.get(Person.class, 1);
		System.out.println(person2);
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
	
	//向一级缓存存入数据时候,放入一级缓存区和缓存快照区,当更新了一级缓存的时候,
	//事务一旦提交,比对一级缓存和快照区,如果数据一致不更新,如果不一致则跟新数据库
	@Test
	public void demo03() {
		//通过特定类指定映射配置文件
		SessionFactory sessionFactory = HibernateUtils.getSessionSessionFactory(Person.class);
		//开启Session
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		Person person = session.get(Person.class, 1);
		System.out.println(person);
		person.setName("wpx");
		session.save(person);
		Person person2 = session.get(Person.class, 1);
		System.out.println(person2);
		//提交事务
		transaction.commit();
		//释放资源
		session.close();
		sessionFactory.close();
	}
	/**
	 * Hibernate管理一级缓存
	 */
	@Test
	public void demo04() {
		//一级缓存的生命周期一致,session生命周期结束,一级缓存销毁
		//管理一级缓存
		//clear()  清空一级缓存中的所有对象
		//evict(Object obj) 清空一级缓存中的某个对象
		//flush 刷出缓存
		//refresh(Object obj) 将快照区的数据重新覆盖了一级缓存的数据
	}
	/**
	 * Hibernate一级缓存的刷出时机
	 */
	@Test
	public void demo05() {
		//FlushMode:
			//常量:
			//AlWAYS: 每次查询的时候都会刷出 手动调出flush,事务提交的时候
			//AUTO: 默认值,有些查询会刷出.手动调用flush,事务提交的时候
			//COMIT: 在事务提交的时候手动调用flush的时候
			//MANAL: 只有在手动调用flush会刷出

	}
	
}
