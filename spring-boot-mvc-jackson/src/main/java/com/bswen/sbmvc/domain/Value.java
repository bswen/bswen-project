package com.bswen.sbmvc.domain;

import java.util.Map;

/**
 * Created on 2019/6/27.
 */
public class Value {
    private long id;
    private String quote;
    private Map<String, String> properties;

    public Value(long id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
