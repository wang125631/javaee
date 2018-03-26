package com.wpx.mybatis.demo03;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wpx.mybatis.demo03.mapper.PersonMapper;
import com.wpx.mybatis.demo03.vo.Person;

public class Client {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException {
		String resource = new String("mybatis/SqlMapConfig.xml");
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testFindPersonById() {
		SqlSession openSession = sqlSessionFactory.openSession();
		PersonMapper mapper = openSession.getMapper(PersonMapper.class);
		Person person = mapper.getPersonById(2);
		System.out.println(person);
	}
}
