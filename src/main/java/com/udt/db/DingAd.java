package com.udt.db;
// Generated Oct 18, 2012 5:16:15 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * DingAd generated by hbm2java
 */
public class DingAd  implements java.io.Serializable {


     private Integer id;
     private String url;
     private String img;
     private long groupId;
     private String text;
     private Date time;

    public DingAd() {
    }

    public DingAd(String url, String img, long groupId, String text, Date time) {
       this.url = url;
       this.img = img;
       this.groupId = groupId;
       this.text = text;
       this.time = time;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImg() {
        return this.img;
    }
    
    public void setImg(String img) {
        this.img = img;
    }
    public long getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }




}


