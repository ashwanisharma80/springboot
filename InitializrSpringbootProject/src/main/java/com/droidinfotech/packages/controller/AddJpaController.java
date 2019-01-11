/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.droidinfotech.packages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author earthlink
 */
@Controller
@RequestMapping("/welcome/")
public class AddJpaController {
    // inject via application.properties

    @RequestMapping("/add1")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Ashwani");
        model.addAttribute("name", "Tom");
        model.addAttribute("formatted", "<b>blue</b>");
        return "welcome";
    }

}
