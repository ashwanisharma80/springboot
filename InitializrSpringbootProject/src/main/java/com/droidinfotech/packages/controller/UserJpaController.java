package com.droidinfotech.packages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.droidinfotech.packages.model.User;
import com.droidinfotech.packages.model.UserRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.ResponseBody;
//import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.ModelAndView;

@Controller    // This means that this class is a Controller
@RequestMapping(path = "/Users") // This means URL's start with /demo (after Application path)
public class UserJpaController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/add")
    public String addAction(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Add User");
        model.addAttribute("addStatus", true);
        return "user/adduser";
    }

    @PostMapping(path = "/add") // Map ONLY GET Requests
    public String addNewUser(@ModelAttribute User user, Model model, HttpServletRequest request) {
        //System.out.println(user.getEmail());
        /*String name=request.getParameter("name");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        User n = new User();
        n.setName(name);
        n.setPassword(password);
        n.setEmail(email);
        n.setCreatedOn("2018-10-30");
        userRepository.save(n);*/
        String password = request.getParameter("password");
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        user.setCreatedOn(ft.format(date));
        if (!"".equals(password)) {
            user.setPassword(getMd5(password));
        }
        userRepository.save(user);
        model.addAttribute("user", user);
        return "redirect:/Users/list";
        //return "Saved";
    }

    public static String getMd5(String input) {
        try {
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping("/listAll")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("user/listUser");
        modelAndView.addObject("userlist", userRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView("user/listUser");
        modelAndView.addObject("userlist", userRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/{id}/edit", method = GET)
    public String editAction(Model model, @PathVariable("id") int id) {
        model.addAttribute("title", "Edit User");
        model.addAttribute("addStatus", true);
        model.addAttribute("user", userRepository.findById(id));
        model.addAttribute("editId", id);
        return "user/adduser";
    }

    @RequestMapping(value = "/{id}/delete", method = GET)
    public String deleteAction(Model model, @PathVariable("id") int id) {
        userRepository.deleteById(id);
        return "redirect:/Users/list";

    }

}
