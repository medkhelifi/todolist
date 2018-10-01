package com.medkhelifi.tutorials.todolist.models.dao.impl;

import com.medkhelifi.tutorials.todolist.models.dao.UserDao;
import com.medkhelifi.tutorials.todolist.models.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImp implements UserDao {

    private SessionFactory sessionFactory;

    public User findByUsername(String username) {

        return null;
    }



    public SessionFactory getSessionFactory() {  return sessionFactory;  }
    public void setSessionFactory(SessionFactory sessionFactory) {   this.sessionFactory = sessionFactory;  }
}
