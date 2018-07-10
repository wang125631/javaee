package com.wpx.spring.demo20;
public class AccountServiceImpl implements AccountService{

	private AccountDao accountDao;

	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void transfer( String from,  String to,  Double money) {
		
		accountDao.out(from, money);
		int d = 1 / 0;
		accountDao.in(to, money);

	}

}
