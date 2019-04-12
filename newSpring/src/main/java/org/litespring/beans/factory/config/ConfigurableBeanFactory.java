package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

import java.util.List;

/**
 * Created by liyinyong on 2018/6/20.
 */
public interface ConfigurableBeanFactory extends AutowireCapableBeanFactory{
    void setBeanClassLoader(ClassLoader beanClassLoader);
    ClassLoader getBeanClassLoader();
    void addBeanPostProcessor(BeanPostProcessor postProcessor);
    List<BeanPostProcessor> getBeanPostProcessors();
}
