package com.bswen.domain;

import java.util.Date;

/**
 * for tbl_spboot_users
 * Created with IntelliJ IDEA.
 * User: zhaocw
 * Date: 15-7-27
 * Time: 下午5:02
 * To change this template use File | Settings | File Templates.
 */
public final class User {
    private int id;
    private String name;
    private Date pubDate;

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
