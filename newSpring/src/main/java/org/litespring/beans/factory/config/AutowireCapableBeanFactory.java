package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

/**
 * Created by liyinyong on 2018/7/22.
 * 为获取autowire注解的实例
 */
public interface AutowireCapableBeanFactory extends BeanFactory{
    Object resolveDependency(DependencyDescriptor descriptor);
}
