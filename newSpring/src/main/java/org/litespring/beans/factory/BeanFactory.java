package org.litespring.beans.factory;

import org.litespring.beans.BeanDefinition;

/**
 * Created by liyinyong on 2018/6/18.
 */
public interface BeanFactory {
    Object getBean(String beanID);

    /**
     * 获取bean对应的class
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    Class<?> getType(String name) throws NoSuchBeanDefinitionException;
}
