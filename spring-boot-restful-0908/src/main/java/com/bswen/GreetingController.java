package com.bswen;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created with IntelliJ IDEA.
 * User: zhaocw
 * Date: 15-9-8
 * Time: 下午4:31
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class GreetingController {
    private static Log log = LogFactory.getLog(GreetingController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }

    @RequestMapping("/enc")
    public Result enc(@RequestParam(value="key") String key) {
        try {
            String result = EncryptUtils.hmac(key,"zhaocwzhaocwzhaocw");
            return new Result(result);
        } catch (Exception e) {
            log.error("",e);
            return null;
        }
    }
}
