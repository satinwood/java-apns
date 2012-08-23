package com.udt.db;
// Generated Aug 21, 2012 6:50:54 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Feedback generated by hbm2java
 */
public class Feedback  implements java.io.Serializable {


     private Integer id;
     private String contact;
     private String content;
     private Date time;
     private String comment;

    public Feedback() {
    }

	
    public Feedback(String content, Date time, String comment) {
        this.content = content;
        this.time = time;
        this.comment = comment;
    }
    public Feedback(String contact, String content, Date time, String comment) {
       this.contact = contact;
       this.content = content;
       this.time = time;
       this.comment = comment;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(String comment) {
        this.comment = comment;
    }




}

