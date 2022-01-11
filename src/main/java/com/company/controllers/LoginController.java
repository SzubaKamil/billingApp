package com.company.controllers;

import com.company.model.User;
import com.company.services.IUserService;
import com.company.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Autowired
    IUserService userService;
    @Resource
    SessionObject sessionObject;

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public String loginForm(){
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        if(this.sessionObject.isLogged()) {
            return redirectByRole(sessionObject.getLoggedUser().getRole());
        }
        model.addAttribute("userModel", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute User user) {
        this.userService.authenticate(user);
        if(this.sessionObject.isLogged()) {
            return redirectByRole(sessionObject.getLoggedUser().getRole());
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/backToHome", method = RequestMethod.GET)
    public String backToUserPage (){
        User.Role role = sessionObject.getLoggedUser().getRole();
        return redirectByRole(role);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.userService.logout();
        return "redirect:/login";
    }

    public String redirectByRole (User.Role role){
        if (role.equals(User.Role.ADMIN)){
            return "redirect:/admin";
        }
        if (role.equals(User.Role.OPERAT)){
            return  "redirect:/operator";
        }
        return "redirect:/uzytkownik";
    }
}
