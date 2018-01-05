package com.wpx.spring.demo18;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService{

	private AccountDao accountDao;
	private TransactionTemplate transactionTemplcate;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void setTransactionTemplcate(TransactionTemplate transactionTemplcate) {
		this.transactionTemplcate = transactionTemplcate;
	}

	public void transfer(final String from, final String to, final Double money) {
		transactionTemplcate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				accountDao.out(from, money);
				int d = 1 / 0;
				accountDao.in(to, money);
			}
		});

	}

}
