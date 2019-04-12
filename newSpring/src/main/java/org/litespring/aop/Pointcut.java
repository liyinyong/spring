package org.litespring.aop;

/**
 * Created by liyinyong on 2018/7/29.
 */
public interface Pointcut {
    MethodMatcher getMethodMatcher();
    String getExpression();
}
