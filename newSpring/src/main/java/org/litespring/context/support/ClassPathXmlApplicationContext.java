package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

/**
 * Created by liyinyong on 2018/6/18.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);

    }

    @Override
    protected Resource getResourceByPath(String path) {

        return new ClassPathResource(path, this.getBeanClassLoader());
    }
}
