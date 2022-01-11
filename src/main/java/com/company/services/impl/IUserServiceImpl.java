package com.company.services.impl;

import com.company.dao.IUserDAO;
import com.company.model.User;
import com.company.services.IUserService;
import com.company.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IUserServiceImpl implements IUserService {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IUserDAO userDAO;

    @Override
    public void authenticate(User user) {
        User userFromDatabase = this.userDAO.getUserByLogin(user.getLogin());
        if(userFromDatabase == null) {
            return;
        }

        if(user.getPasswd().equals(userFromDatabase.getPasswd())) {
            this.sessionObject.setLoggedUser(userFromDatabase);
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setLoggedUser(null);
    }

    @Override
    public boolean addUser(User user) {
        if(this.userDAO.getUserByLogin(user.getLogin()) != null) {
            return false;
        }
        return this.userDAO.addUser(user);
    }

    @Override
    public User getUser(User user) {
        return userDAO.getUserByLogin(user.getLogin());
    }

    @Override
    public int getPriceById(int id) {
        return this.userDAO.getPriceById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return this.userDAO.updateUser(user);
    }


}
