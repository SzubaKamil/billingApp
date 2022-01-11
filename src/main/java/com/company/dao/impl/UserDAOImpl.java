package com.company.dao.impl;

import com.company.dao.IUserDAO;
import com.company.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class UserDAOImpl extends UpgradeDb implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM com.company.model.User WHERE login = :login");
        query.setParameter("login", login);
        User result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nie znaleziono usera !!");
        }
        session.close();
        return result;
    }

    @Override
    public boolean addUser(User user) {
        return save(user);
    }

    @Override
    public int getPriceById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM com.company.model.User WHERE id = :id");
        query.setParameter("id", id);
        User result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Nie znaleziono usera !!");
        }
        session.close();
        return result.getContractCost();
    }

    @Override
    public boolean updateUser(User user) {
        return update(user);
    }
}
