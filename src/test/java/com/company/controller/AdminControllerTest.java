package com.company.controller;

import com.company.controllers.AdminController;
import com.company.model.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

public class AdminControllerTest {

    private AdminController adminController;
    private User user;

    @org.junit.Before
    public void setup (){
        adminController = new AdminController();
        user = new User(1, User.Role.USER, "login", "haslo", "Imie", "Nazwisko", "Adres", 123, 100 );
    }

//    @Test(expected =  NullPointerException.class)
//    public void addUserTest() throws NullPointerException{
//        assertEquals(adminController.addUser(user), "redirect:/admin");
//    }

}
