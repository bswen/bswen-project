package com.bswen.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 2019/7/2.
 */
@Controller
public class HelloController {
    @GetMapping({"/", "/hello"})
    public String hello(@RequestParam(value="name", required=false, defaultValue="World")
                                    String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
