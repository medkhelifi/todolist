package com.medkhelifi.tutorials.todolist.components;

import com.medkhelifi.tutorials.todolist.models.dao.IUserDao;
import com.medkhelifi.tutorials.todolist.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

    @Autowired
    private IUserDao IUserDao;

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public User getAuthenticatedFacade() {
        Authentication authentication = getAuthentication();
        User user = IUserDao.findByUsername(authentication.getName());

        return user;
    }

}
