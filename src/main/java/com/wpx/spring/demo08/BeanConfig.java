package com.wpx.spring.demo08;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BeanConfig {

	@Bean(name="city")
	public City initCity() {
		City city=new City();
		city.setName("°²Ñô");
		city.setCode(123456);
		return city;
	}
}
