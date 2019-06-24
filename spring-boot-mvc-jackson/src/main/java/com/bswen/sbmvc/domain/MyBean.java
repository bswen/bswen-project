package com.bswen.sbmvc.domain;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created on 2019/6/23.
 */
@JsonRootName(value = "user")
public class MyBean {
    private int id;
    private String name;

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
}
