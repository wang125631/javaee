package com.wpx.spring.demo19;

public interface AccountDao {
	/**
	 * 转入的方法
	 * to:要转入的人
	 * money:要转入的金额
	 */
	public void in(String to,Double money);
	/**
	 * 转出的方法
	 * from:要转出的人
	 * money:要转出的金额
	 */
	public void out(String from,Double money);
}
