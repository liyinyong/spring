package org.litespring.beans.factory.config;

import org.litespring.beans.BeansException;
/*
* bean在初始化前后的钩子方法，可以对BeanDefinition进行修改
* */
public interface BeanPostProcessor {

	Object beforeInitialization(Object bean, String beanName) throws BeansException;

	
	Object afterInitialization(Object bean, String beanName) throws BeansException;

}
