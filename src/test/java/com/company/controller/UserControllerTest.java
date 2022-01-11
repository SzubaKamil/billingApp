package com.company.controller;

import com.company.controllers.UserController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserControllerTest {

    private UserController userController;

    @org.junit.Before
    public void setup (){
        userController = new UserController();
    }

    @Test (expected = NullPointerException.class)
    public void showMenuTest (){
        assertEquals(userController.showMenu(), "user");
    }
}
