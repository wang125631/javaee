package com.wpx.spring.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		 System.out.println("第五步:初始化之前执行....");
		return bean;
	}

	public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
		 System.out.println("第八步:初始化后执行....");
			// 动态代理:
		 if(beanName.equals("customerService")) {
			 Object proxy =Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
				// 调用目标方法的时候,调用invoke方法.
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					if("add".equals(method.getName())) {
						System.out.println("权限校验...");
						Object result=method.invoke(bean, args);
						return result;
					}
					return method.invoke(bean, args);
				}
			});
			 return proxy;
		 }
		return bean;
	}

}
