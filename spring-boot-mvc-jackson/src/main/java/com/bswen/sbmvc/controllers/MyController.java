package com.bswen.sbmvc.controllers;

import com.bswen.sbmvc.domain.MyBean;
import com.bswen.sbmvc.domain.Quote;
import com.bswen.sbmvc.domain.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * Created on 2019/6/3.
 */
@RestController
public class MyController {

    @RequestMapping(value="/myBean")
    public @ResponseBody
    MyBean myBean()  {
        MyBean result =  new MyBean();
        result.setId(1);
        result.setName("Jackson");
        result.setBornDate(new Date());
        result.setMarryDate(new Date());
        return result;
    }

    @RequestMapping(value="/quote")
    public @ResponseBody
    Quote quote()  {
        Quote result =  new Quote();
        result.setType("success");
        result.setTheValue(new Value(10,"Really loving bswen.com"));
        result.getTheValue().setProperties(new HashMap<>());
        result.getTheValue().getProperties().put("k1","v1");
        result.getTheValue().getProperties().put("k2","v2");

        result.setAttr1("value1");
        result.setAttr2("value2");

        result.setCountry("China");

        result.setTheDate(new Date());
        return result;
    }

}
