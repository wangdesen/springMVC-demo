package com.demo.springmvc.config;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.demo.springmvc.util.Log4jUtil;

public class SpringPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		//使用ConfigManager统一管理Properties配置文件，比如加解密
		Log4jUtil.debug(this, "Spring PropertyPlaceholderConfigurer加载配置文件config.Properties...");
		super.processProperties(beanFactoryToProcess, ConfigManager.getProperties());
	}
	
}
