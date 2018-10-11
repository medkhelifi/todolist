package com.medkhelifi.tutorials.todolist.services;

import com.medkhelifi.tutorials.todolist.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MyUserDetailsService  implements UserDetailsService {

    private UserDao userDao;

    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.medkhelifi.tutorials.todolist.models.entities.User user   = userDao.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        }else{
            return buildUserForAuthentification(user);
        }
    }

    private User buildUserForAuthentification(com.medkhelifi.tutorials.todolist.models.entities.User user){
        return new User(user.getUsername(), user.getPassword(), null);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
