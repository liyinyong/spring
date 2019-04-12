package org.newspring.test.v4;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.factory.annotation.AutowiredFieldElement;
import org.litespring.beans.factory.annotation.InjectionElement;
import org.litespring.beans.factory.annotation.InjectionMetadata;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.Resource;
import org.newspring.dao.v4.AccountDao;
import org.newspring.dao.v4.ItemDao;
import org.newspring.service.v4.PetStoreService;

import java.lang.reflect.Field;
import java.util.LinkedList;

/**
 * Created by liyinyong on 2018/7/22.
 */
public class InjectionMetadataTest {
    @Test
    public void testInjection() throws Exception{
        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource =new ClassPathResource("petstore-v4.xml");
        reader.loadBeanDefinitions(resource);

        Class<?> clz = PetStoreService.class;
        LinkedList<InjectionElement> elements = new LinkedList<InjectionElement>();
        {
            Field f = PetStoreService.class.getDeclaredField("accountDao");
            InjectionElement injectionElement = new AutowiredFieldElement(f, true, factory);
            elements.add(injectionElement);
        }
        {
            Field f = PetStoreService.class.getDeclaredField("itemDao");
            InjectionElement injectionElement = new AutowiredFieldElement(f, true, factory);
            elements.add(injectionElement);
        }
        InjectionMetadata metadata = new InjectionMetadata(clz, elements);
        PetStoreService petStore = new PetStoreService();

        metadata.inject(petStore);

        Assert.assertTrue(petStore.getAccountDao() instanceof AccountDao);

        Assert.assertTrue(petStore.getItemDao() instanceof ItemDao);
    }
}
