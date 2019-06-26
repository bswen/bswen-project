package com.bswen.sbmvc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created on 2019/6/23.
 */
@JsonRootName(value = "user")
public class MyBean {
    private int id;
    private String name;

    //@JsonSerialize(using = CustomDateSerializer.class) //not valid
    @JsonFormat(pattern = "yyyyMMddHHmmss")
    private Date bornDate;

    private Date marryDate;

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


    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Date getMarryDate() {
        return marryDate;
    }

    public void setMarryDate(Date marryDate) {
        this.marryDate = marryDate;
    }
}
