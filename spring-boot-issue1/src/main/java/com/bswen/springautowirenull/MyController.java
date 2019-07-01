package com.bswen.springautowirenull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 2019/7/1.
 */
@Controller
public class MyController {

    @RequestMapping(value="/hello")
    public @ResponseBody
    String hello()  {
        MyService myService = new MyService();
        return myService.getHello();
    }

    @RequestMapping(value="/hello2")
    public @ResponseBody
    String hello2()  {
        return myService.getHello();
    }

    @Autowired
    private MyService myService;
}
