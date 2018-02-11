package com.wpx.springmvc.demo06;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.wpx.springmvc.User;

/**
 *  自定的类型转换器
 * 	通过实现Converter接口
 * 	将String型字符串解析为 User类型
 * 
 * @author wangpx
 */
@Component
public class UserConverter implements Converter<String, User>{

	@SuppressWarnings("null")
	@Override
	public User convert(String source) {
		if(source == null && source.trim().length()<=0) {
			return null;
		}
		String[] us = source.split("-");
		if(us.length == 3) {
			User user =new User(Integer.valueOf(us[0]),us[1],Integer.valueOf(us[2]));
			return user;
		}
		return null;
	}

}
