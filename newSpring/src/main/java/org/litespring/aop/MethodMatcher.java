package org.litespring.aop;

import java.lang.reflect.Method;

/**
 * Created by liyinyong on 2018/7/29.
 */
public interface MethodMatcher {
    boolean matches(Method method/*, Class<?> targetClass*/);

}
