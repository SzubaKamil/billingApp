package com.company.controllers;

import com.company.model.Meter;
import com.company.model.User;
import com.company.services.IMeterService;
import com.company.services.IUserService;
import com.company.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Random;

@Controller
public class AdminController  {

    @Autowired
    IUserService userService;
    @Autowired
    IMeterService meterService;
    @Resource
    SessionObject sessionObject;

    @RequestMapping("/admin")
    public String showForm (Model theModel){
        if (!sessionObject.isLogged()){
            return "redirect:/login";
        }
        User user = new User();
        theModel.addAttribute("user", user);
        return "/admin/admin";
    }

    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user, Model model2){
        user.setLogin( new Random().nextInt(1000) + "");
        user.setPasswd(user.getPhone()+"");
        user.setRole(User.Role.USER);

        if (userService.addUser(user)){
            meterService.addMeter(new Meter(userService.getUser(user).getId()));
            model2.addAttribute("saved", true);
        }
        else {
            model2.addAttribute("saved", false);
        }
        return "/admin/admin-add-result";
    }
}
