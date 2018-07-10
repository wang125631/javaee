package com.wpx.hibernate.demo08;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.wpx.hibernate.demo03.HibernateUtils;
/**
 *
 * 常用检索方式
 * 	1.OID get/load
 *  2.HQL
 *  3.QBC
 *  4.本地SQL
 * 
 * @author wangpx
 */
@SuppressWarnings("all")
public class Hibernate {

	
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
	/**
	 *插入数据
	 * 
	 */
	@Test
	public void demo01() {
	
		Customer customer = new Customer("wangpx", 21);
		customer.getOrders().add(new  Order("河南",customer));
		customer.getOrders().add(new  Order("广东",customer));
		session.save(customer);
	
	}
	/**
	 * Hibernate中三种检索方式
	 */
	@Test
	public void demo02(){
		//使用HQL查询
		List<Customer> list = session.createQuery("from Customer").list();
		for(Customer c : list) {
			System.out.println(c);
		}
		//使用QBC的方式
		List<Order>  orderList= session.createCriteria(Order.class).list();
		for(Order o : orderList) {
			System.out.println(o);
		}
		
		//使用SQL封装到实体对象中
		List<Customer> customerList = session.createSQLQuery("select * from t_customer08").addEntity(Customer.class).list();
		for(Customer c : customerList) {
			System.out.println(c);
		}
	}

	/**
	 * 使用别名
	 */
	@Test
	public void demo03() {
		//使用别名带查询参数
		List<Customer> list = session.createQuery("from Customer as  c where c.name = ? ").setString(0, "wangpx").list();
		System.out.println(list);		
	}
	
	/**
	 * 排序
	 */
	@Test
	public void demo04() {
		//使用HQL
		List<Customer> list = session.createQuery("from Customer c order by c.cid desc").list();
		for(Customer c: list) {
			System.out.println(c);
		}
		//使用QBC
		List list2 = session.createCriteria(Order.class).addOrder(org.hibernate.criterion.Order.desc("oid")).list();
		System.out.println(list2);
	}
	/**
	 * 分页查询
	 */
	@Test
	public void demo05() {
		//HQL
		Query query = session.createQuery("from Order");
		query.setFirstResult(2);
		query.setMaxResults(5);
		List<Order> orderList = query.list();
		System.out.println(orderList);
		//QBC
		Criteria criteria = session.createCriteria(Order.class);
		List<Order> ol = criteria.setFirstResult(1).setMaxResults(3).list();
		System.out.println(ol);
	}
	/**
	 * 检索单个对象
	 */
	@Test
	public void demo06() {
		//HQL
		 Customer c = (Customer) session.createQuery("from Customer c where  c.cid = ?").setInteger(0, 1).uniqueResult();
		 System.out.println(c);
		 //QBC
		Customer customer= (Customer) session.createCriteria(Customer.class).add(Restrictions.eq("cid",3)).uniqueResult();
		System.out.println(customer);
	}
	
	/**
	 * 绑定参数
	 */
	@Test
	 public void demo07() {
		//Hql参数绑定 使用?号
		Query query = session.createQuery("from Order o where o.oid =? and o.addr= ? ");
		query.setInteger(0, 2);
		query.setString(1,"广东");
		Order o = (Order) query.uniqueResult();
		System.out.println(o);
		//使用名称的方式
		Query query2 = session.createQuery("from Order o where o.oid= :oid and o.addr= :addr");
		query2.setInteger("oid", 3);
		query2.setString("addr", "广东");
		Order o2= (Order) query2.uniqueResult();
		System.out.println(o2);
	}
	/**
	 * 投影操作:查询对象的几个属性
	 */
	@Test
	public void demo08() {
		//查询名称
		List<String> list =session.createQuery("select c.name from Customer c").list();
		list.stream().forEach(System.out::println);
	
		//多个属性
		 List<Object[]> objList= session.createQuery("select c.cid,c.name from Customer c").list();
		 for(Object[] o: objList) {
			 System.out.println(Arrays.toString(o));
		 }
	}
	/**
	 * QBC条件检索
	 */
	@Test
	public void demo09() {
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("oid", 3));
		criteria.add(Restrictions.eq("addr", "广东"));
		List<Order> list = criteria.list();
		if(list!=null && list.size()>0) {
			System.out.println(list.get(0));
		}
	}
	/**
	 * 模糊查询
	 */
	@Test
	public void demo10() {
		//HQL查询
		Query query = session.createQuery("from Order o where o.addr like ?"); 
		query.setString(0, "%南");
		List<Order> list = query.list();
		System.out.println(list);
		//QBC查询
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.ilike("addr","%东"));
		List<Order> orderList = criteria.list();
		System.out.println(orderList);
	}
	/**
	 * 多表查询
	 */
	@Test
	public void demo11() {
		//内连接是是两个表的交集
		 List<Object[]> list = session.createQuery("from Customer c inner join c.orders").list();
		 for(Object[] o: list) {
			 System.out.println(Arrays.toString(o));
		 }
		 
		 //迫切内连接 fetch(HQL)
		 List<Customer> list2 = session.createQuery("select distinct c from Customer c inner join fetch c.orders").list();
		 for(Customer c: list2) {
			 System.out.println(c);
		 }
	}
	/**
	 * 聚合函数
	 */
	@Test
	public void demo12() {
		//查询所有订单总数
		Long count = (Long) session.createQuery("select count(*) from Order ").uniqueResult();
		System.out.println(count);
	}
	/**
	 * 命名查询
	 * 
	 * 在Customer.hbm.xml中配置
	 * 	
	 * <!-- 命名查询的方式 -->
		<query name="findAll">
			from Customer
		</query>
	 */
	@Test
	public void demo13() {
		List<Customer> list = session.getNamedQuery("findALl").list();
		System.out.println(list);
	}

	/**
	 * 离线条件查询
	 */
	@Test
	public void demo14() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Order.class);
		criteria.add(Restrictions.eq("oid", 3));
		criteria.add(Restrictions.eq("addr", "广东"));
		
		Criteria criteria2 = criteria.getExecutableCriteria(session);
		List<Order> list = criteria2.list();
		System.out.println(list);
	}
	
}

