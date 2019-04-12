package org.litespring.core.type;

import org.litespring.core.annotation.AnnotationAttributes;

import java.util.Set;

/**
 * Created by liyinyong on 2018/7/15.
 * 为了方便使用，底层ASM visitor不需要暴露
 */
public interface AnnotationMetadata extends ClassMetadata{
    Set<String> getAnnotationTypes();


    boolean hasAnnotation(String annotationType);

    public AnnotationAttributes getAnnotationAttributes(String annotationType);
}
