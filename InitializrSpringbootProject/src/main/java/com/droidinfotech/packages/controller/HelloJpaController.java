package com.droidinfotech.packages.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ACER
 */
//@RestController
@RequestMapping("/hello/")
public class HelloJpaController {

    @RequestMapping("/")
    public String hellotest() {
        return "Welcome to spring boot w ith template";
    }

    // inject via application.properties
    @Value("${welcome.message:test}")
    private final String message = "Hello World";
    
    @RequestMapping("/add")
    public String welcome(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "welcome";
    }

    
}
