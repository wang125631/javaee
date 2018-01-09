package com.wpx.jdbc.demo07;
/**
 * z转账服务接口
 * @author wangpx
 */
public interface AccountService {

	 void transfer(String from, String to, int money);

}
