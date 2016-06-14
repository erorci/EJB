package com.poc;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class GuestbookEntryEJB
 */

@Stateless(name = "StatelessGuestbookEntryEJB")
public class GuestbookEntryEJB implements GuestbookEntryEJBLocal {

	@Inject
    protected Logger log;

    @PersistenceContext(unitName = "GuestbookEntriesSQL")
    EntityManager sql;
    
    public GuestbookEntryEJB() {
    }

	@Override
	public List<GuestbookEntry> findEntries() {
		
		System.out.println("GuestbookEntryEJB.findEntries()");
		
        TypedQuery<GuestbookEntry> query = 
                sql.createNamedQuery("findAll", GuestbookEntry.class);
        List<GuestbookEntry> list = query.getResultList();
        return list;
    }

	@Override
	public void save(GuestbookEntry entry) {
        sql.persist(entry);
        sql.flush();
        log.info("Guestbook entry saved: " + entry.toString());
    }
	

}
