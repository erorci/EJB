package com.poc;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="GuestbookEntry")
@NamedQueries({
	@NamedQuery(name = "findAll", query = "SELECT g FROM GuestbookEntry g")
})
public class GuestbookEntry implements Serializable {

    private static final long serialVersionUID = -8020012557332377340L;
    private String content;
    private String name;

    @Id @GeneratedValue
    private long id;

    public GuestbookEntry() {
    }

    public String toString() {
        return "Guestbook entry from " + name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}