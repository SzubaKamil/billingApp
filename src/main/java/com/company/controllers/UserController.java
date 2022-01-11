package com.company.controllers;

import com.company.model.Invoice;
import com.company.model.Meter;
import com.company.model.User;
import com.company.model.view.PasswordModel;
import com.company.services.IInvoiceService;
import com.company.services.IMeterService;
import com.company.services.IUserService;
import com.company.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
    IMeterService meterService;
    @Autowired
    IInvoiceService invoiceService;
    @Resource
    SessionObject sessionObject;

    @GetMapping("/uzytkownik")
    public String showMenu (){
        if (!sessionObject.isLogged()){
            return "redirect:/login";
        }
        return "/user/user";
    }

    @GetMapping("/uzytkownik/invoiceList")
    public String userListMeter (Model theModel){
        if (!sessionObject.isLogged()){
            return "redirect:/login";
        }
        Meter meter = meterService.getMeterByUserId(sessionObject.getLoggedUser().getId());
        List<Invoice> invoices = invoiceService.getInvoicesByMeterId(meter.getId());
        theModel.addAttribute("invoices", invoices);
        return "/user/user-invoice-list";
    }

    @RequestMapping("/uzytkownik/passw")
    public String changeUserPassw (Model theModel){
        if (!sessionObject.isLogged()){
            return "redirect:/login";
        }
        PasswordModel passwordModel = new PasswordModel();
        theModel.addAttribute("passwordModel", passwordModel);
        return "/user/user-passw";
    }

    @RequestMapping("/uzytkownik/changePassw")
    public String changePassw(@ModelAttribute("passwordModel") PasswordModel passwordModel){
        if (passwordModel.getPass().equals(passwordModel.getPassw2())){
            User user = sessionObject.getLoggedUser();
            user.setPasswd(passwordModel.getPass());

            if (userService.updateUser(user)){
                System.out.println("Hasło zmieniono pomyślnie");
            } else {
                System.out.println("Coś poszło nie tak");
            }
        } else {
            System.out.println("Wprowadzone hasła nie są takie same!!!");
        }
        return "redirect:/uzytkownik";
    }

}