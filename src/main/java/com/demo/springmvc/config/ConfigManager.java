package com.demo.springmvc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.demo.springmvc.util.IOUtils;
import com.demo.springmvc.util.Log4jUtil;
import com.demo.springmvc.util.StringUtil;

public class ConfigManager {
	
	public static ConfigManager INSTANCE = new ConfigManager();
	public static String ENV_DEVELOP = "develop";
	public static String ENV_PRODUCT = "product";
	public static String ENV_TEST = "test";
	private Properties config;
	
	private ConfigManager() {
	}

	private Properties getConfig() {
		if (config == null) {
			InputStream is = null;
			try {
				config = new Properties();
				is = this.getClass().getClassLoader().getResourceAsStream("config.properties");
				Properties p = getProperties(is);
				for (Object key : p.keySet()) {
					config.put(key.toString(), (String) p.getProperty(key.toString()));
				}
				String environment = p.getProperty("environment");
				Log4jUtil.info(this, "部署环境：" + environment);
				is = this.getClass().getClassLoader().getResourceAsStream("config." + environment + ".properties");
				p = getProperties(is);
				for (Object key : p.keySet()) {
					config.put(key.toString(), (String) p.getProperty(key.toString()));
				}
				p.clear();
				p = null;
			} catch (IOException e) {
				e.printStackTrace();
				Log4jUtil.error(this, "读取配置文件出错.", e);
			} finally {
				IOUtils.closeQuietly(is);
			}
		}
		return config;
	}

	/**
	 * 文件中有中文时读出来会出现乱码，后续需转码ISO8859-1——>GBK
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	protected static Properties getProperties(InputStream is) throws IOException {
		Properties p = new Properties();
		p.load(is);
		return p;
	}
	
	/**
	 * 文件中有中文时读出来会出现乱码，后续需转码ISO8859-1——>GBK
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	protected static Properties getProperties(String filePath) throws IOException {
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
			p.load(is);
		} finally {
			IOUtils.closeQuietly(is);
		}
		return p;
	}

	/**
	 * 根据key获取properties文件的配置信息
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public Object getProperty(String key, Object defaultValue) {
		if (getConfig() == null)
			return defaultValue;
		String ret = getConfig().getProperty(key);
		if (StringUtil.isTrimEmpty(ret))
			return defaultValue;
		if (defaultValue instanceof Boolean)
			return Boolean.parseBoolean(ret);
		else if (defaultValue instanceof Integer)
			return Integer.parseInt(ret);
		else if (defaultValue instanceof Double)
			return Double.parseDouble(ret);
		else {
			/*
			 * try { ret = new
			 * String(getConfig().getProperty(key).getBytes("ISO8859-1"),
			 * "GBK"); } catch (UnsupportedEncodingException e) {
			 * e.printStackTrace(); return getConfig().getProperty(key); }
			 */
			return ret;
		}
	}

	public static Object get(String key, Object defaultValue) {
		ConfigManager mgr = ConfigManager.INSTANCE;
		return mgr.getProperty(key, defaultValue);
	}

	public static void set(String key, String value) {
		ConfigManager mgr = ConfigManager.INSTANCE;
		mgr.setProperty(key, value);
	}

	public static Properties getProperties() {
		return ConfigManager.INSTANCE.getConfig();
	}

	public void setProperty(String key, String value) {
		getConfig().setProperty(key, value);
	}

	public static String getString(String key, Object defaultValue) {
		return (String) get(key, defaultValue);
	}

	public static boolean getBoolean(String key, Object defaultValue) {
		return (Boolean) get(key, defaultValue);
	}

	public static int getInteger(String key, Object defaultValue) {
		return (Integer) get(key, defaultValue);
	}

	public static double getDouble(String key, Object defaultValue) {
		return (Double) get(key, defaultValue);
	}

	/**
	 * 获取当前运行环境
	 * @return
	 */
	public static String getRunningEnv() {
		return getProperties().getProperty("environment");
	}
	
	/**
	 * 是否开放环境
	 * @return
	 */
	public static boolean isDevelopEnv() {
		String environment = getProperties().getProperty("environment");
		return ENV_DEVELOP.equals(environment);
	}
	
	/**
	 * 是否产品环境
	 * @return
	 */
	public static boolean isProductEnv() {
		String environment = getProperties().getProperty("environment");
		return ENV_PRODUCT.equals(environment);
	}
	
	/**
	 * 是否产品环境
	 * @return
	 */
	public static boolean isTestEnv() {
		String environment = getProperties().getProperty("environment");
		return ENV_TEST.equals(environment);
	}
	
}
