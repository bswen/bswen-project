package com.bswen.sbmvc.controllers;

import com.bswen.sbmvc.domain.MyBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        return result;
    }

}