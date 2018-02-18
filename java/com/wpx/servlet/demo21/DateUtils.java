package com.wpx.servlet.demo21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * 将日期格式化为字符串
	 * 
	 * @param 要转化的日期
	 * @return 
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(date);
		return format;
	}
	/**
	 * 将字符串转化为日期
	 * @param 要转化的字符串
	 * @return
	 * @throws ParseException 
	 */
	public static Date formatString(String str) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.parse(str);
	}
}
