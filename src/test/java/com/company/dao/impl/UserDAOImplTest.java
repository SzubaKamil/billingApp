package com.company.dao.impl;
import com.company.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class UserDAOImplTest {

    @org.junit.Before
    public void setup (){

    }

    @Test
    void getUserByLogin() {
        UserDAOImpl userDAO = mock(UserDAOImpl.class);
        when(userDAO.getUserByLogin("login")).thenReturn(meterMocData());

        User user = userDAO.getUserByLogin("login");
        assertEquals(user.getId(), 10);
        assertEquals(user.getLogin(), "login");
        assertEquals(user.getPasswd(), "passwd");
    }

    @Test
    void getPriceById() {
        UserDAOImpl userDAO = mock(UserDAOImpl.class);
        when(userDAO.getPriceById(5)).thenReturn(meterMocDataPrice());

        int price = userDAO.getPriceById(5);
        assertEquals(price, 150);
    }

    private User meterMocData(){
        return new User(10, User.Role.ADMIN, "login", "passwd", "name", "surname", "address", 123456789, 10  );
    }

    private int meterMocDataPrice(){
        return 150;
    }
}