package com.company.dao;

import com.company.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    boolean addUser(User user);
    int getPriceById(int id);
    boolean updateUser (User user);
}
