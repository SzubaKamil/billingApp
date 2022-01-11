package com.company.session;

import com.company.model.User;
import com.company.session.SessionObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionObjectTest {

    private SessionObject sessionObject;
    private User user;

    @org.junit.Before
    public void setup (){
        sessionObject = new SessionObject();
        user = new User();
    }

    @Test
    public void getAndSetLoggedUser(){
        assertNull(sessionObject.getLoggedUser());
        sessionObject.setLoggedUser(user);
        assertEquals(user, sessionObject.getLoggedUser());
        sessionObject.setLoggedUser(null);
        assertNull(sessionObject.getLoggedUser());
    }

    @Test
    public void isLogged (){
        assertFalse(sessionObject.isLogged());
        sessionObject.setLoggedUser(user);
        assertTrue(sessionObject.isLogged());
        sessionObject.setLoggedUser(null);
        assertFalse(sessionObject.isLogged());
    }
}
