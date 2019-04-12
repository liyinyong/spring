package org.litespring.beans;

import java.util.List;

/**
 * Created by liyinyong on 2018/6/18.
 */
public interface BeanDefinition {
    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    String getBeanClassName();

    boolean isSingleton();

    boolean isPrototype();

    String getScope();

    void setScope(String scope);

    List<PropertyValue> getPropertyValues();

    ConstructorArgument getConstructorArgument();

    String getID();

    boolean hasConstructorArgumentValues();

    Class<?> resolveBeanClass(ClassLoader classLoader) throws ClassNotFoundException;

    Class<?> getBeanClass() throws IllegalStateException;

    boolean hasBeanClass();
}
