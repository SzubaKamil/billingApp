package com.company.services;

import com.company.model.User;

public interface IUserService {
    void authenticate(User user);
    boolean addUser(User user);
    User getUser(User user);
    int getPriceById(int id);
    void logout();
    boolean updateUser (User user);

}
