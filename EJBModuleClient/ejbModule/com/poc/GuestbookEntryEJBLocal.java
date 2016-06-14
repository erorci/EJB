package com.poc;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GuestbookEntryEJBLocal {
	List<GuestbookEntry> findEntries();
	void save(GuestbookEntry entry);
}