package com.poc;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class GuestbookEntryOracleEJB
 */
@Stateless(name = "StatelessGuestbookEntryOracleEJB")
public class GuestbookEntryOracleEJB implements GuestbookEntryOracleEJBLocal {

	@Inject
    protected Logger log;
	
	@PersistenceContext(unitName = "GuestbookEntriesORA")
	EntityManager em;
		
	@PersistenceContext(unitName = "GuestbookEntriesSQL")
	EntityManager sql;
    
    public GuestbookEntryOracleEJB() {
    }

	@Override
	public List<GuestbookEntry> findEntries() {
		System.out.println("GuestbookEntryOracleEJB.findEntries()");
		TypedQuery<GuestbookEntry> query = 
                em.createNamedQuery("findAll", GuestbookEntry.class);
        List<GuestbookEntry> list = query.getResultList();
        return list;
	}

	@Override
	public void save(GuestbookEntry entry) {
		em.persist(entry);
        em.flush();
        log.info("Guestbook entry saved in Oracle: " + entry.toString());		
	}

	@Override
	public String replicar() {
		
		String retorno = "OK";
		
		TypedQuery<GuestbookEntry> querySQL = sql.createNamedQuery("findAll", GuestbookEntry.class);
        List<GuestbookEntry> listSQL = querySQL.getResultList();
        
        try {		
        	for(GuestbookEntry g : listSQL) {
            	save(g);
            }
		} catch (Exception e) {
			retorno = "Erro";
			log.info(e.getMessage());
		}               
		
		return retorno ;
	}

}
