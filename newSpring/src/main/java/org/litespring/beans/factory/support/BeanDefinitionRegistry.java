package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * Created by liyinyong on 2018/6/18.
 */
public interface BeanDefinitionRegistry {
    BeanDefinition getBeanDefinition(String beanID);
    void registerBeanDefinition(String beanID, BeanDefinition bd);
}
