package com.baiyu.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) throws Exception {
        if(true) {
            throw new Exception("some exception");
        }
        model.addAttribute("now" , "33");
        model.addAttribute("test", "aa");
        return "hello";
    }
}
