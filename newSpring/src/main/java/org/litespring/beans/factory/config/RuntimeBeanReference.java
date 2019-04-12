package org.litespring.beans.factory.config;

/**
 * Created by liyinyong on 2018/6/24.
 */
public class RuntimeBeanReference {
    private final String beanName;
    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }
    public String getBeanName() {
        return this.beanName;
    }
}
