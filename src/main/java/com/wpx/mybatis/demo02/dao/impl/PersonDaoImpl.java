package com.wpx.mybatis.demo02.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wpx.mybatis.demo01.vo.Person;
import com.wpx.mybatis.demo02.dao.PersonDao;

public class PersonDaoImpl implements PersonDao{

	private SqlSessionFactory sqlSessionFactory;
	
	public PersonDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public Person findUserById(int id) {
		//´´½¨sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person p = sqlSession.selectOne("demo01.findUserById", id);
		return p;
	}

}
