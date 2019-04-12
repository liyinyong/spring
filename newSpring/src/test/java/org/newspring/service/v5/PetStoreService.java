package org.newspring.service.v5;


import org.litespring.beans.factory.annotation.Autowired;
import org.litespring.stereotype.Component;
import org.newspring.dao.v5.AccountDao;
import org.newspring.dao.v5.ItemDao;
import org.newspring.util.MessageTracker;


@Component(value="petStore")
public class PetStoreService {		
	@Autowired
	AccountDao accountDao;
	@Autowired
	ItemDao itemDao;
	
	public PetStoreService() {		
		
	}
	
	public ItemDao getItemDao() {
		return itemDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}
	
	public void placeOrder(){
		System.out.println("place order");
		MessageTracker.addMsg("place order");
		
	}	
	public void placeOrderWithException(){
		throw new NullPointerException();
	}
}
