package com.medkhelifi.tutorials.todolist.models.dao;

import com.medkhelifi.tutorials.todolist.models.entities.User;

public interface IUserDao {
    User findByUsername (String username);
}
