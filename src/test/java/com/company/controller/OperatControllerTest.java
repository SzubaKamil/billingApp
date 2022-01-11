package com.company.controller;


import com.company.controllers.OperatController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperatControllerTest {

    private OperatController operatController;

    @org.junit.Before
    public void setup (){
        OperatController operatController = new OperatController();
    }

    @Test(expected = NullPointerException.class)
    public void showMenuTest (){
        assertEquals(operatController.showMenu(), "operat");

    }

}
