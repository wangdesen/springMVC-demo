package com.demo.springmvc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类 y：年 M：月 d：日 H：时 m：分 s：秒
 * 
 * @author jay
 * 
 */
public class DateUtil {

	/**
	 * 取得系统的当前日期，字串格式yyyyMMdd 20140929
	 * 
	 * @return 系统当前日期字串
	 */
	public static String getDate() {
		return getDate("yyyyMMdd");
	}

	/**
	 * 取得系统的当前时间，字串格式HHmmss 125514
	 * 
	 * @return 系统当前日期字串
	 */
	public static String getTime() {
		return getDate("HHmmss");
	}

	/**
	 * 取得系统的当前日期时间，字串格式yyyyMMddHHmmss 20140929125514
	 * 
	 * @return 系统当前日期字串
	 */
	public static String getDateTime() {
		return getDate("yyyyMMddHHmmss");
	}

	/**
	 * 根据指定的日期格式取得系统的当前日期
	 * 
	 * @param pattern
	 *            日期格式，如yyyy-MM-dd、yyyyMMdd、HHmmss
	 * @return 格式化后的系统当前日期的字符串
	 */
	public static String getDate(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}

	/**
	 * 取系统当前时间毫秒
	 * 
	 * @return 长整型的系统当前时间毫秒数
	 */
	public static long getTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 根据指定的日期格式将字符串转换为指定格式yyyyMMdd的日期
	 * 
	 * @param str
	 *            需转换的字符串
	 * @return 转换后的日期
	 * @throws ParseException
	 *             字符串不能被解析成日期格式异常
	 */
	public static Date parseDate(String str) throws ParseException {
		return parseDate(str, "yyyyMMdd");
	}

	/**
	 * 根据指定的日期格式将字符串转换为日期
	 * 
	 * @param str
	 *            需转换的字符串
	 * @param pattern
	 *            转换成日期格式，如"yyyy-MM-dd"
	 * @return 转换后的日期
	 * @throws ParseException
	 *             字符串不能被解析成日期格式异常
	 */
	public static Date parseDate(String str, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(str);
	}

	/**
	 * 根据指定的日期格式将日期转换为字符串
	 * 
	 * @param date
	 *            需进行转换的日期，格式为"yyyyMMdd"
	 * @param pattern
	 *            转换成的日期格式 如"yyyy-MM-dd"
	 * @return 转换后的日期字符串
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 根据指定的日期格式将yyyyMMdd格式的源日期字串转换为目标字串
	 * 
	 * @param date
	 *            需进行转换的日期字符串
	 * @param pattern
	 *            指定的日期格式
	 * @return 目标字符串
	 */
	public static String formatDate(String date, String pattern) throws ParseException {
		return formatDate(date, "yyyyMMdd", pattern);
	}

	/**
	 * 根据指定的日期格式将指定格式的源日期字串转换为目标字串
	 * 
	 * @param date
	 *            源日期字符串
	 * @param srcPattern
	 *            源日期格式
	 * @param pattern
	 *            指定的格式
	 * @return 指定格式的字符串
	 */
	public static String formatDate(String date, String srcPattern, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(parseDate(date, srcPattern));
	}

	/**
	 * 根据指定的增量模式对日期进行加操作 。
	 * 如果传入的是String类型的日期，返回的也是String类型，如果传入的是Date类型，返回的也是Date类型<br>
	 * <p>
	 * <b>使用范例：</b><br>
	 * dateAdd ("20110320", "Y", 1) 执行结果：20120320<br>
	 * dateAdd ("20110320", "M", 3) 执行结果：20110620<br>
	 * dateAdd ("20110320", "D", 1) 执行结果：20110325<br>
	 * 
	 * @param date
	 *            要进行加操作的日期
	 * @param pattern
	 *            增量模式 "Y":年，"M":月，"D":日,默认对日添加
	 * @param num
	 *            增加的数量，支持负数
	 * @return 增加num数量后的日期字符串或者
	 * @throws ParseException
	 */
	public static Object dateAdd(Object date, String pattern, int num) throws ParseException {
		Date dt = null;
		if (date instanceof String) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			try {
				dt = sdf.parse((String) date);
				dt = changeDate(dt, pattern, num);
				return sdf.format(dt);
			} catch (ParseException e) {
				throw e;
			}
		}
		if (date instanceof Date)
			dt = changeDate((Date) date, pattern, num);
		return dt;
	}

	/**
	 * 根据指定的增量模式对日期进行加或减操作，如果传入的是正数，那么进行加操作，如果是负数，那么进行减操作。 如：changeDate(Date d,
	 * "Y", 5) 等效于dateAdd(date,"Y",5)，changeDate(Date d, "Y", -5)
	 * 等效于dateMinus(date,"Y",5)
	 * 
	 * @param d
	 *            要进行操作的日期
	 * @param pattern
	 *            操作的模式 "Y":年，"M":月，"D":日,默认对日操作
	 * @param num
	 *            操作的数量
	 * @return 操作后的日期
	 */
	private static Date changeDate(Date d, String pattern, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		char c = pattern.toCharArray()[0];
		switch (c) {
		case 'Y':
			calendar.add(Calendar.YEAR, num);
			break;
		case 'M':
			calendar.add(Calendar.MONTH, num);
			break;
		case 'D':
			calendar.add(Calendar.DAY_OF_MONTH, num);
			break;
		default:
			calendar.add(Calendar.DAY_OF_MONTH, num);
			break;
		}
		return calendar.getTime();
	}

}
