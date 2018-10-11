package com.medkhelifi.tutorials.todolist.services;

import com.medkhelifi.tutorials.todolist.models.dao.UserDao;
import com.medkhelifi.tutorials.todolist.models.entities.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
public class MyUserDetailsService  implements UserDetailsService {

    private UserDao userDao;

    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.medkhelifi.tutorials.todolist.models.entities.User user   = userDao.findByUsername(s);
        List<GrantedAuthority> grantedAuthorities = buildAuthoritiesForUser(user.getRoleByRoleId());
        if(user == null){
            throw new UsernameNotFoundException(s);
        }else{
            return buildUserForAuthentification(user, grantedAuthorities);
        }
    }

    private List<GrantedAuthority> buildAuthoritiesForUser(Role role) {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(Collections.singleton(simpleGrantedAuthority));
        return grantedAuthorities;

    }

    private User buildUserForAuthentification(com.medkhelifi.tutorials.todolist.models.entities.User user, List<GrantedAuthority> grantedAuthorities){
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
