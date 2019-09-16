package com.bswen.sbrc.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2019/6/27.
{
     type: "success",
     value: {
         id: 10,
         quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
     }
 }
 */
public class Quote {
    private String type;
    private Value value;
    private Map<String,String> otherProps = new HashMap<>();
    @JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    private Date theDate;

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

    public Value getValue() {
        return value;
    }

    @JsonSetter("theValue")
    public void setValue(Value theValue) {
        this.value = theValue;
    }

    public Map<String, String> getOtherProps() {
        return otherProps;
    }

    public void setOtherProps(Map<String, String> otherProps) {
        this.otherProps = otherProps;
    }

    //@JsonAnySetter
    public void add(String key, String value) {
        otherProps.put(key, value);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", otherProps=" + otherProps +
                ", date=" + theDate +
                '}';
    }

    //    @JsonCreator
//    public Quote(@JsonProperty("type") String type,
//            @JsonProperty("theValue") Value theValue) {
//        this.type = type;
//        this.value = theValue;
//    }
}
