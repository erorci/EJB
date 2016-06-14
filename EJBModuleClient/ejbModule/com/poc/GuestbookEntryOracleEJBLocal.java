package com.poc;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GuestbookEntryOracleEJBLocal {	
	List<GuestbookEntry> findEntries();
	void save(GuestbookEntry entry);
	String replicar();

}
