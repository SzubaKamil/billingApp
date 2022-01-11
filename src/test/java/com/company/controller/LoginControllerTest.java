package com.company.controller;

import com.company.controllers.LoginController;
import com.company.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginControllerTest {

    private LoginController loginController;

    @org.junit.Before
    public void setup (){
        loginController = new LoginController();
    }

    @Test
    public void loginFormTest (){
        assertEquals(loginController.loginForm(), "redirect:/login");
    }

    @Test(expected =  NullPointerException.class)
    public void logoutTest(){
        assertEquals(loginController.logout(), "redirect:/login");
    }

    @Test
    public void redirectByRoleTest (){
        assertEquals(loginController.redirectByRole(User.Role.ADMIN),"redirect:/admin" );
        assertEquals(loginController.redirectByRole(User.Role.OPERAT),"redirect:/operator" );
        assertEquals(loginController.redirectByRole(User.Role.USER),"redirect:/uzytkownik" );
    }

}
