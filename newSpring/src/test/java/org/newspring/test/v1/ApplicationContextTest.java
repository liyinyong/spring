package org.newspring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.litespring.context.support.FileSystemXmlApplicationContext;
import org.newspring.service.v1.PetStoreService;

/**
 * Created by liyinyong on 2018/6/18.
 */
public class ApplicationContextTest {
    @Test
    public void testGetBean(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v1.xml");
        PetStoreService petStoreService = (PetStoreService)ctx.getBean("petStore");
        Assert.assertNotNull(petStoreService);
    }
    @Test
    public void TestGetBeanFromFileSystemContext(){
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("");
//        PetStoreService petStoreService = (PetStoreService)ctx.getBean("petStore");
//        Assert.assertNotNull(petStoreService);
    }
}
