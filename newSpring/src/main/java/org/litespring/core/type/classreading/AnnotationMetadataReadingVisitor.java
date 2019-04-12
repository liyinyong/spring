package org.litespring.core.type.classreading;

import org.litespring.core.annotation.AnnotationAttributes;
import org.litespring.core.type.AnnotationMetadata;
import org.springframework.asm.AnnotationVisitor;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.Type;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liyinyong on 2018/7/15.
 * 注解元素数据，包含了注解的信息，注解的属性
 */
public class AnnotationMetadataReadingVisitor extends ClassMetadataReadingVisitor implements AnnotationMetadata {
    private final Set<String> annotationSet = new LinkedHashSet<String>();
    private final Map<String, AnnotationAttributes> attributesMap = new LinkedHashMap<String, AnnotationAttributes>();

    public AnnotationMetadataReadingVisitor() {
    }

    public AnnotationVisitor visitAnnotation(final String desc, boolean visible){
        String className = Type.getType(desc).getClassName();
        this.annotationSet.add(className);
        return new AnnotationAttributesReadingVisitor(className, this.attributesMap);
    }
    public Set<String> getAnnotationTypes() {
        return this.annotationSet;
    }

    public boolean hasAnnotation(String annotationType) {
        return this.annotationSet.contains(annotationType);
    }

    public AnnotationAttributes getAnnotationAttributes(String annotationType) {
        return this.attributesMap.get(annotationType);
    }
}
