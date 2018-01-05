package com.wpx.spring.demo07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope
public class UserService {

	//@Resource(name="userDao")
	@Autowired(required=true)
	@Qualifier("userDao")
	private UserDao userDao;
	
	public void say() {
		userDao.say();
	}
	
}
