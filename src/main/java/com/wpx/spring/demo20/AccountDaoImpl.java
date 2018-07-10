package com.wpx.spring.demo20;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	public void in(String to, Double money) {
		 String sql="UPDATE account SET money = money + ? WHERE NAME= ? ";
		 this.getJdbcTemplate().update(sql, money,to);
	}

	public void out(String from, Double money) {
		String sql="UPDATE account SET money = money - ? WHERE NAME= ? ";
		this.getJdbcTemplate().update(sql, money,from);
	}

}
