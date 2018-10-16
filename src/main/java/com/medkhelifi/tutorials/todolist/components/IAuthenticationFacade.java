package com.medkhelifi.tutorials.todolist.components;

import com.medkhelifi.tutorials.todolist.models.entities.User;
import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
    Authentication getAuthentication();

    User getAuthenticatedFacade();
}
