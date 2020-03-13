package com.learning.springbootTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("info", "Hello world!");
        return "hello";
    }
}
