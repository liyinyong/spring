package org.newspring.service.v4;

import org.litespring.beans.factory.annotation.Autowired;
import org.litespring.stereotype.Component;
import org.newspring.dao.v4.AccountDao;
import org.newspring.dao.v4.ItemDao;

@Component(value="petStore")

public class PetStoreService {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ItemDao  itemDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}
	
	
}