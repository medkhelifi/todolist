package com.medkhelifi.tutorials.todolist.models.dao;

import com.medkhelifi.tutorials.todolist.models.entities.User;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserDao implements IUserDao {

    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Transactional
    public User findByUsername(String username) {
        List<User> users;
        users = sessionFactory.getCurrentSession().createQuery("from User where username =?").setParameter(0, username).list();
        if(users.size()>0) {
            return  users.get(0);
        }else {
            return null;
        }
        
    }



    public SessionFactory getSessionFactory() {  return sessionFactory;  }
    public void setSessionFactory(SessionFactory sessionFactory) {   this.sessionFactory = sessionFactory;  }
}
