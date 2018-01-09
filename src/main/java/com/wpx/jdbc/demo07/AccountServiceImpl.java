package com.wpx.jdbc.demo07;

import java.sql.Connection;

public class AccountServiceImpl implements AccountService{

	private AccountDao accountDao =new AccountDaooImpl();
	
	
	@Override
	public void transfer(String from, String to, int money) {
		 Connection con;
		try {
			con = JdbcUtils.getConnection();
			accountDao.out(con, from, money);
			int a=1/0;
			accountDao.in(con, to, money);
			System.out.println("转账成功");
		} catch (Exception e) {
			System.out.println("转账失败");
			e.printStackTrace();
		}
	}



}
