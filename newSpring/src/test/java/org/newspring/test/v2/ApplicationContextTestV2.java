package org.newspring.test.v2;

import org.junit.Test;
import org.litespring.context.ApplicationContext;
import org.litespring.context.support.ClassPathXmlApplicationContext;
import org.newspring.dao.v2.AccountDao;
import org.newspring.dao.v2.ItemDao;
import org.newspring.service.v2.PetStoreService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ApplicationContextTestV2 {

	@Test
	public void testGetBeanProperty() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore-v2.xml");
		PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");
		assertNotNull(petStore.getAccountDao());
		assertNotNull(petStore.getItemDao());
		assertTrue(petStore.getAccountDao() instanceof AccountDao);
		assertTrue(petStore.getItemDao() instanceof ItemDao);
		assertEquals("liuxin",petStore.getOwner());
		assertEquals(2, petStore.getVersion());

	}

}
