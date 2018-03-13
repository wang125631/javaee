package com.wpx.mybatis.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wpx.mybatis.demo01.vo.Person;

public class Client {
	
	//会话工厂
	private SqlSessionFactory sqlSessionFactory;
	//创建工厂
	@Before
	public void init() throws IOException {
		//配置文件
		String resource = "mybatis/SqlMapConfig.xml";
		//加载配置文件到输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * 插入数据并提交
	 */
	@Test
	public void testInsertUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person person = new Person();
		person.setId(3);
		person.setName("wangpx");
		person.setBirthday(new Date());
		person.setSex("男");
		person.setAddress("中国");
		
		try {
			sqlSession.insert("demo01.insertUser", person);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	/**
	 *通过id查询数据
	 */
	@Test
	public void testFindUserById() {
		//通过sqlSession工厂创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person person=null;
		try {
			person=sqlSession.selectOne("demo01.findUserById",2);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println(person);
	}
	/**
	 * 根据用户名查询
	 */
	@Test
	public void testFindByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Person> list=new ArrayList<Person>();
		try {
			list = sqlSession.selectList("demo01.findUserByName", "%ang%");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		for (Person person : list) {
			System.out.println(person);
		}
	}
	
	@Test
	public void testUpdateUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person p=null;
		try {
			
			p = sqlSession.selectOne("findUserById", 1);
			p.setName("王鹏霄");
			sqlSession.update("demo01.updateUserById", p);
			sqlSession.commit();
			p = sqlSession.selectOne("findUserById", 1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		System.out.println(p);
	}
	
	@Test
	public void deleteUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete("demo01.deleteUserById", 1);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
}
