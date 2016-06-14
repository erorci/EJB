package com.poc;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class GuestbookEntryController {
    @EJB
    private GuestbookEntryEJB entryEJB;
    private GuestbookEntry entry = new GuestbookEntry();

    public void save() {
        entryEJB.save(entry);
    }

    public List<GuestbookEntry> findEntries() {
        return entryEJB.findEntries();
    }
 

    public GuestbookEntry getEntry() {
        return entry;
    }

    public void setEntry(GuestbookEntry entry) {
        this.entry = entry;
    }

    public GuestbookEntryEJB getEntryEJB() {
        return entryEJB;
    }

    public void setEntryEJB(GuestbookEntryEJB entryEJB) {
        this.entryEJB = entryEJB;
    }
}