package org.newspring.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.core.io.ClassPathResource;
import org.newspring.service.v1.PetStoreService;

import static org.junit.Assert.*;

/**
 * Created by liyinyong on 2018/6/18.
 */
public class BeanFactoryTest {
    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;
    @Before
    public void setUp(){
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }
    @Test
    public void testGetBean() {
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");
        assertTrue(bd.isSingleton());

        assertFalse(bd.isPrototype());

        assertEquals(BeanDefinition.SCOPE_DEFAULT,bd.getScope());
        assertEquals("org.newspring.service.v1.PetStoreService", bd.getBeanClassName());
        PetStoreService petStoreService = (PetStoreService)factory.getBean("petStore");
        assertNotNull(petStoreService);
        PetStoreService petStore1 = (PetStoreService)factory.getBean("petStore");

        assertTrue(petStoreService.equals(petStore1));
    }
    @Test
    public void testInvalidBean(){
        reader.loadBeanDefinitions(new ClassPathResource("petstore-v1.xml"));
        try{
            factory.getBean("invalidBean");
        }catch(BeanCreationException e){
            return;
        }
        Assert.fail("expect BeanCreationException ");
    }
    @Test
    public void testInvalidXML(){

        try{
            reader.loadBeanDefinitions(new ClassPathResource("xxxx.xml"));
        }catch(BeanDefinitionStoreException e){
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException ");
    }
}
