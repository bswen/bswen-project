package com.bswen.sbmvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created on 2019/6/27.
{
     type: "success",
     theValue: {
         id: 10,
         quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
     }
 }
 */
@JsonIgnoreProperties({ "attr2" })
public class Quote {
    private String type;
    private Value theValue;
    private String attr1;
    private String attr2;
    private Date theDate;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getTheDate() {
        return theDate;
    }

    public void setTheDate(Date theDate) {
        this.theDate = theDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getTheValue() {
        return theValue;
    }

    public void setTheValue(Value theValue) {
        this.theValue = theValue;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }
}
