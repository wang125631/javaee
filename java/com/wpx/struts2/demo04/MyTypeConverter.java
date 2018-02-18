package com.wpx.struts2.demo04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
/**
 * 自定义的的类型转化类
 * 
 * 
 * 创建一个类实现TypeConverter接口.
 * 
  				1.实现TypeConverter需要重写
					public Object convertValue(Map<String, Object> context, Object target, Member member, String propertyName, Object value, Class toType);
					如果实现接口，这个方法参数太多(6个)
					
				2.不推荐实现接口，可以继承 DefaultTypeConverter类
					优点:重写的方法参数没有那么多
					 public Object convertValue(Map<String, Object> context, Object value, Class toType) {
							return convertValue(value, toType);
					}
		
				3. 继承DefaultTypeConverter类的一个子类StrutsTypeConverter.
					原因:在这个类中将从页面传递的数据怎样封装，以及action中的数据怎样在页面上显示做了分离.
					
					  public abstract Object convertFromString(Map context, String[] values, Class toClass);
					  public abstract String convertToString(Map context, Object o);
		
 * 
 * 注册一个自定义类型转换器.
				
				1.局部--针对于action
					 配置文件所在位置以及名称:  在Action类所在包 创建 Action类名-conversion.properties , 
					 配置文件书写:    格式 ： 属性名称=类型转换器的全类名 
				2.局部--针对于model
					 配置文件所在位置以及名称:  在model类所在包 创建 model类名-conversion.properties , 
					 配置文件书写:    格式 ： 属性名称=类型转换器的全类名 
				3.全局
					配置文件所在位置以及名称:在src下创建一个xwork-conversion.properties
					配置文件书写:  格式:  要转换的类型全名=类型转换器的全类名 
 * 
 * 
 * @author wangpx
 */
public class MyTypeConverter extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		String value = values[0];
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}

	@Override
	public String convertToString(Map context, Object o) {
		 
		return null;
	}

}
