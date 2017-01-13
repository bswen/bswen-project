package com.bswen.multids.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: xxx
 * Date: 15-7-27
 * Time: 下午5:02
 * To change this template use File | Settings | File Templates.
 */
public final class User {
    private int id;
    private String name;
    private Date pubDate;
    private int departId;

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}
